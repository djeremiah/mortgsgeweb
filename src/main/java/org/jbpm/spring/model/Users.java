package org.jbpm.spring.model;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class Users implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String userId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Users [userId=" + userId + "]";
	}
	
	
	public static void main(String[] ar){
		String val = "PAY $50.00".substring("PAY $50.00".indexOf("$"));
		System.out.println(val);;
		
		Calendar cl = Calendar.getInstance();
		String month = cl.getDisplayName(Calendar.MONTH, Calendar.LONG_FORMAT, Locale.ENGLISH);
		String year = cl.getDisplayName(Calendar. WEEK_OF_YEAR,Calendar.LONG_FORMAT, Locale.ENGLISH);
		String date = cl.getDisplayName(Calendar.DATE, Calendar.LONG_FORMAT, Locale.ENGLISH);

		System.out.println(month);;
		System.out.println(year);;

		System.out.println(date);;
		DateFormat df;
	    DateFormat shortDf = DateFormat.getDateInstance(DateFormat.LONG);
	    System.out.println(shortDf.format(cl.getTime()));
	    
	    SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		format.setTimeZone(TimeZone.getTimeZone("CST"));
		String dtStr = format.format(date);
		System.out.println("datatt" + dtStr);
		String msg = "4701#287.31";
		String[] ms =  msg.split("#");
		System.out.println(ms[0]);
		System.out.println(ms[1]);

		
		
		
	}
}
