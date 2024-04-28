package com.tapfoods.model;

public class Restaurant {
	private int restaurantId;
	private String name;
	private String imagePath;
	private double rating;
	private String eta;
	private String cuisineType;
	private String address;
	private String isActive;
	private int restaurantOwnerId;

	// zero-parameterized constructor
	public Restaurant() {

	}

	// parameterized constructor
	public Restaurant(int restaurantId, String name, String imagePath, double rating, String eta, String cuisineType,
			String address, String isActive, int restaurantOwnerId) {
		super();
		this.restaurantId = restaurantId;
		this.name = name;
		this.imagePath = imagePath;
		this.rating = rating;
		this.eta = eta;
		this.cuisineType = cuisineType;
		this.address = address;
		this.isActive = isActive;
		this.restaurantOwnerId = restaurantOwnerId;
	}

	//getters & setters
	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getEta() {
		return eta;
	}

	public void setEta(String eta) {
		this.eta = eta;
	}

	public String getCuisineType() {
		return cuisineType;
	}

	public void setCuisineType(String cuisineType) {
		this.cuisineType = cuisineType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public int getRestaurantOwnerId() {
		return restaurantOwnerId;
	}

	public void setRestaurantOwnerId(int restaurantOwnerId) {
		this.restaurantOwnerId = restaurantOwnerId;
	}

	//to-String method
	@Override
	public String toString() {
		return "Restaurant [restaurantId=" + restaurantId + ", name=" + name + ", imagePath=" + imagePath + ", rating="
				+ rating + ", eta=" + eta + ", cuisineType=" + cuisineType + ", address=" + address + ", isActive="
				+ isActive + ", restaurantOwnerId=" + restaurantOwnerId + "]";
	}
	
	

}
