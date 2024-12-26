package com.coderscampu.A6;

import java.time.LocalDate;

public class SalesData {
	private int sales;
	private LocalDate date;
	private String worstMonth;
	private String bestMonth;

	public String getBestMonth() {
		return bestMonth;
	}
	public void setBestMonth(String bestMonth) {
		this.bestMonth = bestMonth;
	}
	public SalesData(LocalDate date, int sales) {
		this.date = date;
		this.sales = sales;
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
