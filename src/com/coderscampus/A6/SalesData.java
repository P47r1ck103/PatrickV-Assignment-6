package com.coderscampus.A6;

import java.time.YearMonth;

public class SalesData {
	private int sales;
	private YearMonth yearMonth;
	private String modelName;

	public String getModelName() {
		
		return modelName;
	}


	public void setModelName(String modelName) {
		this.modelName = modelName;
	}


	



	public SalesData(YearMonth yearMonth, int sales) {
		this.yearMonth = yearMonth;
		this.sales = sales;
	}

	public int getSales() {
		return sales;
	}

	@Override
	public String toString() {
		return "yearMonth = " + yearMonth + ", sales = " + sales;
	}

	public YearMonth getYearMonth() {
		return yearMonth;
	}

}
