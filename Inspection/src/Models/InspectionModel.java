package Models;

public class InspectionModel {

	String serial_number;
	String restaurant_name;
	String location_name;
	String address;
	String city;
	String state;
	String inspection_grade;
	
	

	public InspectionModel() {
		super();
	}

	public InspectionModel(String serial_number, String restaurant_name, String location_name, String address,
			String city, String state, String inspection_grade) {
		this.serial_number = serial_number;
		this.restaurant_name = restaurant_name;
		this.location_name = location_name;
		this.address = address;
		this.city = city;
		this.state = state;
		this.inspection_grade = inspection_grade;
	}

	public String getSerial_number() {
		return serial_number;
	}

	public void setSerial_number(String serial_number) {
		this.serial_number = serial_number;
	}

	public String getRestaurant_name() {
		return restaurant_name;
	}

	public void setRestaurant_name(String restaurant_name) {
		this.restaurant_name = restaurant_name;
	}

	public String getLocation_name() {
		return location_name;
	}

	public void setLocation_name(String location_name) {
		this.location_name = location_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getInspection_grade() {
		return inspection_grade;
	}

	public void setInspection_grade(String inspection_grade) {
		this.inspection_grade = inspection_grade;
	}
}
