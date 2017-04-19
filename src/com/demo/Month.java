package com.demo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Month {

	public static void main(String[] args) {
		Calendar calendar=Calendar.getInstance();
		int month=calendar.get(Calendar.MONTH)+1;
		int year=calendar.get(Calendar.YEAR);
		calendar.set(year, month, 1, 0, 0);
		Date begin=calendar.getTime();
		calendar.set(year, month+1, 1, 0, 0);
		Date end=calendar.getTime();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("begin:"+sdf.format(begin)+"  end:"+sdf.format(end));
	}
}
