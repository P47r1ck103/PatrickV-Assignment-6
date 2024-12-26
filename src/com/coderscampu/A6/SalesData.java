package com.coderscampu.A6;

import java.time.LocalDate;

public class SalesData {
	private String model;
	private int sales;
	private LocalDate date;
	private String worstMonth;

	public SalesData(LocalDate date, int sales) {
		this.date = date;
		this.sales = sales;
	}


	public String getModel() {
		return model;
	}

	public int getSales() {
		return sales;
	}

	public LocalDate getDate() {
		return date;
	}

	public String getWorstMonth() {
		return worstMonth;
	}

	public void setWorstMonth(String worstMonth) {
		this.worstMonth = worstMonth;
	}
}
