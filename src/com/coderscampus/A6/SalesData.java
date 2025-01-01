package com.coderscampus.A6;

import java.time.YearMonth;

public class SalesData {
	private int sales;
	private static YearMonth YearMonth;

	public SalesData(YearMonth yearMonth, int sales) {
		this.YearMonth = yearMonth;
		this.sales = sales;
	}

	public int getSales() {
		return sales;
	}

	@Override
	public String toString() {
		return "SalesData [yearMonth=" + YearMonth + "]";
	}

	public YearMonth getYearMonth() {
		return YearMonth;
	}

}
