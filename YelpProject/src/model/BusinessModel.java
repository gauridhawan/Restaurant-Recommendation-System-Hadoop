package model;

import java.util.Map;

public class BusinessModel {
	private String business_id;
	private String name;
	private String address;
	private String city;
	private String state;
	private String postal_code;
	private float latitude;
	private float longitude;
	private float stars;
	private int review_count;
	private float is_open;
	private Map<String, Object> attributes;
	private String categories;
	private Map<String, Object> hours;

	public String getBusiness_id() {
		return business_id;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getPostal_code() {
		return postal_code;
	}

	public float getLatitude() {
		return latitude;
	}

	public float getLongitude() {
		return longitude;
	}

	public float getStars() {
		return stars;
	}

	public int getReview_count() {
		return review_count;
	}

	public float getIs_open() {
		return is_open;
	}

	public Map<String, Object> getAttributes() {
		return attributes;
	}

	public String getCategories() {
		return categories;
	}

	public Map<String, Object> getHours() {
		return hours;
	}

	public void setBusiness_id(String business_id) {
		this.business_id = business_id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public void setStars(float stars) {
		this.stars = stars;
	}

	public void setReview_count(int review_count) {
		this.review_count = review_count;
	}

	public void setIs_open(float is_open) {
		this.is_open = is_open;
	}

	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}

	public void setCategories(String categories) {
		this.categories = categories;
	}

	public void setHours(Map<String, Object> hours) {
		this.hours = hours;
	}
}