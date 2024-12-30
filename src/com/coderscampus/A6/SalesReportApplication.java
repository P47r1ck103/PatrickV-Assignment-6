package com.coderscampus.A6;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class SalesReportApplication {
	
	private static String bestMonth;
	private static String worstMonth;
	private static Collection<SalesData> filteredSalesData;
	@SuppressWarnings("rawtypes")
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
		}
		List<SalesData> groupedBySales = allSalesData.stream()
				.filter(data-> data.getYearMonth()!= null)
				.collect(java.util.stream.Collectors.toList());
		
		Map<Integer, Integer> yearlySales = filteredSalesData.stream()
				.collect(Collectors.groupingBy(Data -> data.getYearMonth().getYear(),
						Collectors.summingInt(SalesData::getSales)));

		for (SalesData object : groupedBySales) {
			List<SalesData> salesData = groupedBySales;
			Stream<SalesData> yearlySales = salesData.stream();
			for (int year = 2016; year <= 2019; year++) {
				int sales = ((Map<com.coderscampus.A6.object, Integer>) yearlySales).getOrDefault(year, 0);
				System.out.println(year + " ->" + sales);
			}
			Map<object, Integer> MonthlySales = filteredSalesData.stream()
					.collect(Collectors, groupingBy(
							data -> data.getYearMonth().toString().Collectors.summingInt(SalesData::getSales)));
			Object bestMonth = MonthlySales.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();

			System.out.println("The best month was: " + bestMonth);

			System.out.println("The worst month was: " + worstMonth);

		}
	}
	}

	
