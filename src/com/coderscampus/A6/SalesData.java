package com.coderscampus.A6;

import java.time.YearMonth;

public class SalesData {
	private int sales;
	private YearMonth yearMonth;

	public SalesData(YearMonth yearMonth, int sales) {
		this.yearMonth = yearMonth;
		this.sales = sales;
	}

	public int getSales() {
		return sales;
	}

	@Override
	public String toString() {
		return "SalesData [yearMonth = " + yearMonth + ", sales = "+"]";
	}

	public YearMonth getYearMonth() {
		return yearMonth;
	}

}
