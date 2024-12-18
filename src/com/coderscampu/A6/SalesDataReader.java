package com.coderscampu.A6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SalesDataReader {
	public List<SalesData> readData(String filePath) throws IOException{
		List<SalesData> salesDataList = new ArrayList<>();
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		String line;
		LocalDate date = null;
		
		reader.readLine();
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(",");
			if (parts.length == 3) {
				String model = parts[0];
				int sales = Integer.parseInt(parts[1]);
				
				
					salesDataList.add(new SalesData(model, sales, date));
					
			}
		}
			reader.close();
			return salesDataList;
	}

}
