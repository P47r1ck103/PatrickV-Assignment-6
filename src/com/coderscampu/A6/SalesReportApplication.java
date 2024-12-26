package com.coderscampu.A6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SalesReportApplication {
	
	
	private static String worstMonth;

	public static void main(String[] args) throws IOException {
		String[] filePaths = { "model3.csv", "modelS.csv", "modelX.csv" };

		List<SalesData> allSalesData = new ArrayList<>();

		for (String filePath : filePaths) {
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			String line;
			
			reader.readLine();

 			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(",");
				if (parts.length == 2) {
					int sales = Integer.parseInt(parts[0]);
					LocalDate date = LocalDate.parse(parts[1], DateTimeFormatter.ofPattern("YearMonth"));
					allSalesData.add(new SalesData( date, sales));
				}
		}
			reader.close();
		}
		Map<String, List<SalesData>> groupedByModel = allSalesData.stream()
				.collect(Collectors.groupingBy(SalesData::getModel));
				

		for (String model : groupedByModel.keySet()) {
			List<SalesData> modelData = groupedByModel.get(model);
			Map<Object, Integer> yearlySales = modelData.stream().collect(Collectors
					.groupingBy(data -> data.getDate().getYear(), Collectors.summingInt(SalesData::getSales)));
			System.out.println(model + "Yearly Sales Report");
			for (int year = 2016; year <= 2019; year++) {
				int sales = yearlySales.getOrDefault(year, 0);
				System.out.println(year + " ->" + sales);
			}
			Map<Object, Integer> monthlySales = modelData.stream().collect(Collectors.groupingBy(
					data -> data.getDate().getYear() + "-" + String.format("%02d", data.getDate().getMonthValue()),
					Collectors.summingInt(SalesData::getSales)));

			Object bestMonth = monthlySales.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();

			System.out.println("The best month for " + model + " was: " + bestMonth);
			
			System.out.println("The worst month for " + model + " was: " + worstMonth);

		}
	}

}
