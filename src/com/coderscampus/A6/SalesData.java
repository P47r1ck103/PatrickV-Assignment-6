package com.coderscampus.A6;

import java.time.LocalDate;
import java.time.YearMonth;

public class SalesData {
	private int sales;
	private YearMonth YearMonth;
	private LocalDate date;


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
	@Override
	public String toString() {
		return "SalesData [yearMonth=" + YearMonth + "]";
	}
	public java.time.YearMonth getYearMonth() {
	return YearMonth;
	}

}
