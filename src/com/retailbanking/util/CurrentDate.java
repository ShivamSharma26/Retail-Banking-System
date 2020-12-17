package com.retailbanking.util;


import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.sql.Date;

public class CurrentDate {
	public Date dateToString() {
		//Date date = new Date();
		
		//SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		//String strdate = formatter.format(date);
		//return strdate;
		
		
		LocalDate date1=LocalDate.now();
		Date sqlDate=Date.valueOf(date1);
		System.out.println(sqlDate);
		return sqlDate;
	}
}
