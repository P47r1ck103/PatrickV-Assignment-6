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
					LocalDate date = LocalDate.parse(parts[1], DateTimeFormatter.ofPattern("MMM-yy"));
					allSalesData.add(new SalesData( date, sales));
				}
		}
			reader.close();
		}
		List<SalesData> groupedBySales = allSalesData.stream()
				.collect(Collectors.toList());
				

		for (SalesData object : groupedBySales) {
			List<SalesData> salesData = groupedBySales;
			Map<Object, Integer> yearlySales = salesData.stream().collect(Collectors
					.groupingBy(data -> data.getDate().getYear(), Collectors.summingInt(SalesData::getSales)));
			System.out.println(object);
			for (int year = 2016; year <= 2019; year++) {
				int sales = yearlySales.getOrDefault(year, 0);
				System.out.println(year + " ->" + sales);
			}
			Map<Object, Integer> monthlySales = salesData.stream().collect(Collectors.groupingBy(
					data -> data.getDate().getYear() + "-" + String.format("%02d", data.getDate().getMonthValue()),
					Collectors.summingInt(SalesData::getSales)));

			Object bestMonth = monthlySales.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();

			System.out.println("The best month was: " + bestMonth);
			
			System.out.println("The worst month was: " + worstMonth);

		}
	}

}
