package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BusinessModelOutput {
	private String business_id;
	private String name;
	private String address;
	private String city;
	private String state;
	private float stars;
	private int review_count;
	private List<String> categories;
	private Map<String, Object> hours;

	public BusinessModelOutput() {
	}

	public BusinessModelOutput(BusinessModel business) {
		this.business_id = business.getBusiness_id();
		this.name = business.getName();
		this.address = business.getAddress();
		this.city = business.getCity();
		this.state = business.getState();
		this.stars = business.getStars();
		this.review_count = business.getReview_count();
		this.categories = new ArrayList<String>();
		this.hours = business.getHours();
	}

	public String getBusiness_id() {
		return business_id;
	}

	public void setBusiness_id(String business_id) {
		this.business_id = business_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Map<String, Object> getHours() {
		return hours;
	}

	public void setHours(Map<String, Object> hoursObject) {
		this.hours = hoursObject;
	}

	public float getStars() {
		return stars;
	}

	public void setStars(float stars) {
		this.stars = stars;
	}

	public int getReview_count() {
		return review_count;
	}

	public void setReview_count(int review_count) {
		this.review_count = review_count;
	}

	public List<String> getCategories() {
		return categories;
	}

	public void setCategories(List<String> categories) {
		this.categories = categories;
	}
}