package com.coderscampus.A6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class SalesDataReader {

	@SuppressWarnings("resource")
	public List<SalesData> readData(String filePath) throws IOException {
		List<SalesData> salesDataList = new ArrayList<>();
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		String line;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM-yy");
		File file = new File(filePath);
		
		if (!file.exists()) {
            System.out.println("File not found: " + filePath);

        }
		
		reader.readLine();
		
		while ((line = reader.readLine()) != null) {
			String[] parts = line.split(",");
			if (parts.length == 2) {
				try {
					YearMonth yearMonth = YearMonth.parse(parts[0].trim(), formatter);
					int sales = Integer.parseInt(parts[1].trim());
					salesDataList.add(new SalesData(yearMonth, sales));
				
			} catch (Exception e) {
				System.out.println("Error parsing line: " + line + "-" + e.getMessage());
			}

				
		}



		
		}
		reader.close();
		return salesDataList;
	}	
}
