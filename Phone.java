package Millionaire_Project;



public class Phone {
	private int countrycode;
	private int citycode;
	private int number;
	
	
	public Phone(int countrycode, int citycode, int number) {
		this.countrycode = countrycode;
		this.citycode = citycode;
		this.number = number;
		
	}
	
	public Phone(int citycode,int number) {
		countrycode = 90;
		this.citycode = citycode;
		this.number = number;
	}
	
	public Phone(int number) {
		countrycode = 90;
		citycode = 232;
		this.number = number;
	}
	
	public String display() {
		return "+" + countrycode +" (" + citycode + ") " + number;
	}
	
	public int getCountrycode() {
		return countrycode;
	}
	public void setCountrycode(int countrycode) {
		this.countrycode = countrycode;
	}
	public int getCitycode() {
		return citycode;
	}
	public void setCitycode(int citycode) {
		this.citycode = citycode;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}

}
