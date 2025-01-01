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
import java.util.stream.Stream;

public class SalesReportApplication {

	
	private static Collection<SalesData> filteredSalesData;


	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws IOException {
		String[] filePaths = { "model3.csv", "modelS.csv", "modelX.csv" };
		List<SalesData> allSalesData = new ArrayList<>();

		for (String filePath : filePaths) {
			try {
				SalesDataReader reader = new SalesDataReader();
				allSalesData.addAll(reader.readData(filePath));
			} catch (IOException e) {
				System.out.println("Error reading file: " + filePath + "-" + e.getMessage());

			reader.close();
		}
		List<SalesData> groupedBySales;
		try {
			groupedBySales = allSalesData.stream()
					.filter(data-> data.getYearMonth()!= null)
					.collect(Collectors(SalesData::getSales));// not right.
		} catch (Exception e) {
			
			e.printStackTrace();
		}

		for (SalesData object : groupedBySales) {
			List<SalesData> salesData = groupedBySales;
			Stream<SalesData> yearlySales = salesData.stream();
			for (int year = 2016; year <= 2019; year++) {
				@SuppressWarnings("unchecked")
				int sales = ((Map<Integer,Integer>) yearlySales).getOrDefault(year, 0);
				System.out.println(year + " ->" + sales);
			}
			Map<Integer, Integer> MonthlySales = filteredSalesData.stream()
					.collect(Collectors(data -> data.getYearMonth().toString( )//somethings not right here
							.Collectors.summingInt(SalesData::getSales)));
			
			System.out.println("The best month was: ");

			System.out.println("The worst month was: ");

		}
	}
}


