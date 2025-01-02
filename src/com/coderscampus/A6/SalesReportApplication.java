package com.coderscampus.A6;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class SalesReportApplication {

	
	private static Collection<SalesData> filteredSalesData;


	
	public static void main(String[] args) {
		String[] filePaths = { 
				"model3.csv",
				"modelS.csv",
				"modelX.csv" 
				};
		List<SalesData> allSalesData = new ArrayList<>();

		for (String filePath : filePaths) {
			try {
				SalesDataReader reader = new SalesDataReader();
				allSalesData.addAll(reader.readData(filePath));
			} catch (IOException e) {
				System.out.println("Error reading file: " + filePath + "-" + e.getMessage());


		}
		List<SalesData> filteredSalesData = allSalesData.stream()
				.filter(data -> data.getYearMonth()!= null)
				.collect(Collectors.toList());
		Map<Integer,Integer> yearlySales = filteredSalesData.stream()
				.collect(Collectors.groupingBy(data -> data.getYearMonth().getYear(),
						Collectors.summingInt(SalesData:: getSales)));
		
		yearlySales.forEach((year, sales) -> System.out.println(year + "->" + sales));
		
		Map<String, Integer> monthlySales = filteredSalesData.stream()
				.collect(Collectors.groupingBy(data -> data.getYearMonth().toString(),
						Collectors.summingInt(SalesData::getSales)));
		Optional<Map.Entry<String, Integer>> bestMonthEntry = monthlySales.entrySet().stream()
				.max(Map.Entry.comparingByValue());
		Optional<Map.Entry<String, Integer>> worstMonthEntry = monthlySales.entrySet().stream()
				.min(Map.Entry.comparingByValue());
			
		
		bestMonthEntry.ifPresent(entry -> System.out.println("The best month was: " + entry.getKey() + " with sales: " + entry.getValue()));
		worstMonthEntry.ifPresent(entry -> System.out.println("The worst month was: " + entry.getKey() + " with sales: " + entry.getValue()));
			
			

			}
		}
	}

