package com.coderscampu.A6;

import java.time.LocalDate;

public class SalesData {
	private String model;
	private int sales;
	private LocalDate date;
	private String worstMonth;

	public SalesData(String model, int sales, LocalDate date2) {
		this.model = model;
		this.sales = sales;
		this.date = date2;
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
