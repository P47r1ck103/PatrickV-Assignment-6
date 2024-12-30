package com.coderscampus.A6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SalesReportApplication {

	private static String worstMonth;
	private static Collection<SalesData> filteredSalesData;
	private static Supplier Collectors;

	public static void main(String[] args) throws IOException {
		String[] filePaths = { "model3.csv", "modelS.csv", "modelX.csv" };
		List<SalesData> allSalesData = new ArrayList<>();

		for (String filePath : filePaths) {
			try {
				SalesDataReader reader = new SalesDataReader();
				allSalesData.addAll(reader.readData(filePath));
			} catch (IOException e) {
				System.out.println("Error reading file: " + filePath + "-" + e.getMessage());
			}
			BufferedReader reader = null;
			try {
				reader = new BufferedReader(new FileReader(filePath));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			String line;

			reader.readLine();

			String line;
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(",");

				if (parts.length == 2) {
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM-yy");
					YearMonth sales = YearMonth.parse(parts[0], formatter);
					allSalesData.add(new SalesData(sales, 0));
				}
			}
			reader.close();
		}
		List<SalesData> groupedBySales = allSalesData.stream()
				.filter(data-> data.getYearMonth()!= null)

		for (SalesData object : groupedBySales) {
			List<SalesData> salesData = groupedBySales;
			Stream<SalesData> yearlySales = salesData.stream();
			for (int year = 2016; year <= 2019; year++) {
				int sales = ((Map<com.coderscampus.A6.object, Integer>) yearlySales).getOrDefault(year, 0);
				System.out.println(year + " ->" + sales);
			}
			Map<object, Integer> MonthlySales = filteredSalesData.stream()
					.collect(Collectors,groupingBy(data -> data.getYearMonth().toString()
							.Collectors.summingInt(SalesData::getSales)));
			Object bestMonth = MonthlySales.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();

			System.out.println("The best month was: " + bestMonth);

			System.out.println("The worst month was: " + worstMonth);

		}
	}

}
