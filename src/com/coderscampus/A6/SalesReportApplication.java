package com.coderscampus.A6;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class SalesReportApplication {

	public static void main(String[] args) throws IOException {
		String[] filePaths = { "model3.csv", "modelS.csv", "modelX.csv" };
		List<SalesData> allSalesData = new ArrayList<>();

		for (String filePath : filePaths) {
			
			try {
				SalesDataReader reader = new SalesDataReader();
				allSalesData.addAll(reader.readData(filePath));
			} catch (IOException e) {
				System.out.println("Error reading file: " + filePath + "-" + e.getMessage());
				continue;
			}

		List<SalesData> filteredSalesData = allSalesData.stream().filter(data -> data.getYearMonth() != null)
				.collect(Collectors.toList());

		Map<Integer, Integer> yearlySales = filteredSalesData.stream().collect(Collectors
				.groupingBy(data -> data.getYearMonth().getYear(), Collectors.summingInt(SalesData::getSales)));

		System.out.println(filePath +" Yearly Sales Report");
		for (int year = 2016; year <= 2019; year++) {
			int sales = yearlySales.getOrDefault(year, 0);
			System.out.println(year + "->" + sales);
		}

		Map<String, Integer> monthlySales = filteredSalesData.stream().collect(Collectors
				.groupingBy(data -> data.getYearMonth().toString(), Collectors.summingInt(SalesData::getSales)));

		Map.Entry<String, Integer> bestMonth = null;
		for (Map.Entry<String, Integer> entry : monthlySales.entrySet()) {
			if (bestMonth == null || entry.getValue() > bestMonth.getValue()) {
				bestMonth = entry;
			}
		}
		Map.Entry<String, Integer> worstMonth = null;
		for (Map.Entry<String, Integer> entry : monthlySales.entrySet()) {
			if (worstMonth == null || entry.getValue() > worstMonth.getValue()) {
				worstMonth = entry;
			}
		}
		if (bestMonth != null) {
			System.out.println("The best month was: " + bestMonth.getKey() + " with sales: " + bestMonth.getValue());
		}else {
			System.out.println("No sales data available for the best month.");
		}
		
		if (worstMonth != null) {
			System.out.println("The worst month was: " + worstMonth.getKey() + " with sales: " + worstMonth.getValue());
		}else {
			System.out.println(" no sales data available for the worst month.");
		}
		System.out.println("-------------------");


		}		
	}
}