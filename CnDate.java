package Millionaire_Project;

public class CnDate {
	private int day;
	private int month;
	private int year;
	
	public CnDate(int day, int month, int year) {
		this.day= day;
		this.month = month;
		this.year = year;
	}
	
	public String display() {
		return day + "." + month + "." + year;
		
		
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

}
