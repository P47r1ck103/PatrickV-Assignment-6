package com.coderscampus.A6;

public class SalesData {
	private String model;
	private int sales;
	private LocalDate date;

	public SalesData(String model, int sales, LocalDate date) {
		this.model = model;
		this.sales = sales;
		this.date = date;
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
}
