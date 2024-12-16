package com.coderscampus.A6;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class SalesDataReader {
	public List<SalesData> readData(String filePath) throws IOException{
		List<SalesData> salesDataList = new ArrayList<>();
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		String line;
		
		reader.readLine();
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(",");
			if (parts.length == 3) {
				String model = parts[0];
				int sales = integer.parseInt(parts[1]);
				LocalDate date = LocalDate.parse(oarts[2]), DateTimeFormatter.ofPatterm("yyyy,MM,dd"));
					salesDataList.add(new SalesData(model, slaes, date));
			}
		}
			reader.close();
			return salesDataList;
	}

}
