package com.coderscampu.A6;

import java.time.LocalDate;
import java.time.YearMonth;

public class SalesData {
	private int sales;
	private YearMonth yearMonth;
	private String worstMonth;
	private String bestMonth;
	private LocalDate date;

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
	public SalesData(LocalDate date2, YearMonth sales2) {
		// TODO Auto-generated constructor stub
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
