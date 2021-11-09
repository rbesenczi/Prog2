package hu.unideb.prog2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

class Date implements Comparable<Date>{

	private int year;
	private int month;
	private int day;

	Date(int y, int m, int d){
		year = y;
		month = m;
		day = d;
	}

	Date(){
		year = 2001;
		month = 1;
		day = 1;
	}

	int getYear() { return year; }
	int getMonth() { return month; }
	int getDay() { return day; }

	void setYear(int y) { year = y; }
	void setMonth(int m) { month = m; }
	void setDay(int d) { day = d; }

	@Override
	public String toString(){
		return year + ". " + month + ". " + day;
	}

	@Override
	public boolean equals(Object dd){

		if (dd == this) return true;
		
		if(!(dd instanceof Date)) return false;

		Date d = (Date) dd;

		return d.year == year && d.month == month && d.day == day;
	}

	@Override
	public int compareTo(Date d){
		
		if(d.year != year) return year - d.year;
		if(d.month != month) return month - d.month;
		if(d.day != day) return day - d.day;

		return 0;
	}
}

public class DateDemo {
	public static void main(String[] args) {
		
		Date today = new Date(2020, 10, 1);
		Date tomorrow = new Date(2021, 11, 4);

		System.out.println(today);
		System.out.println(tomorrow);

		if(today.equals(tomorrow))
			System.out.println("Dates are equal.");
		else
			System.out.println("Dates are not equal.");

		System.out.println("Today compareTo() tomorrow: " + today.compareTo(tomorrow));

		ArrayList<Date> dates = new ArrayList<>();
		dates.add(today);
		dates.add(tomorrow);
		dates.add(new Date(1990, 10, 21));
		dates.add(new Date(2100, 10, 10));

		System.out.println("Print unsorted:");
		for(var date : dates)
			System.out.println(date);

		Collections.sort(dates);

		System.out.println("Print sorted:");
		for(var date : dates)
			System.out.println(date);

		System.out.println("Print using iterator:");

		Iterator<Date> it = dates.iterator();

		while(it.hasNext())
			System.out.println(it.next());

	}
}
