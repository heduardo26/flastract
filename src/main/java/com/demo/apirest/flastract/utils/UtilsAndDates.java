package com.demo.apirest.flastract.utils;

public class UtilsAndDates {
	
	private UtilsAndDates() {
	    throw new IllegalStateException("Utility class");
	  }
	
	/**
	 * Function to get the current date in Mysql format
	 * @return
	 */
	public static String  getCurrentDate() {
		
		java.util.Date dt = new java.util.Date();
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		return sdf.format(dt);
	}
}
