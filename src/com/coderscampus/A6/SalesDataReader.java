package com.coderscampus.A6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class SalesDataReader {

	private YearMonth YearMonth;
	

	public List<SalesData> readData(String filePath) throws IOException {
		List<SalesData> salesDataList = new ArrayList<>();
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		String line;
		reader.readLine();
		while ((line = reader.readLine()) != null) {
			String[] parts = line.split(",");
			if (parts.length == 2) {
				int sales = Integer.parseInt(parts[1]);
				salesDataList.add(new SalesData(YearMonth, sales));}
			
				Map<java.time.YearMonth, Integer> MonthlySales = filteredSalesData.stream()
						.collect(Collectors(data -> data.getYearMonth().toString().Collectors.summingInt(SalesData::getSales)));
		}
		
		reader.close();
		return salesDataList;

	}


	}


