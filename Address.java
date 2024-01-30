package Millionaire_Project;


public class Address {
	private String country;
	private String city;
	private String district;
	private String street;
	private String no;
	
	public Address (String street,String no,  String district ,String city, String country ) {
		this.country = country;
		this.city = city; 
		this.district = district;
		this.street = street;
		this.no = no;
	}
	public Address(String street,String no,  String district ,String city) {
		country = "Turkey";
		this.city = city; 
		this.district = district;
		this.street = street;
		this.no = no;
		
	}
	public String display() {
		return street + ";" + no + ";" + district + ";"  + city + ";" + country + ";" ;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}
	

}
