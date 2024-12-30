package com.coderscampus.A6;

import java.time.LocalDate;
import java.time.YearMonth;

public class SalesData {
	private int sales;
	private YearMonth YearMonth;
	private String worstMonth;
	private String bestMonth;
	private LocalDate date;

	public String getBestMonth() {
		return bestMonth;
	}

	public void setBestMonth(String bestMonth) {
		this.bestMonth = bestMonth;
	}

	public SalesData(YearMonth yearMonth, int sales) {
		this.YearMonth = yearMonth;
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

	@Override
	public String toString() {
		return "SalesData [yearMonth=" + YearMonth + "]";
	}

	public void setWorstMonth(String worstMonth) {
		this.worstMonth = worstMonth;
	}

	public Object getYearMonth() {
		
		return YearMonth;
	}

}
