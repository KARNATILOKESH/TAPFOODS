package com.tapfoods.model;

public class Menu {

	private int menuId;
	private String name;
	private double price;
	private String description;
	private String imagePath;
	private String isAvailable;
	private double rating;
	private int restaurantId;
	private String veg_nonVeg;

	// zero-parameterized constructor
	public Menu() {
	}

	// parameterized constructor
	public Menu(int menuId, String name, double price, String description, String imagePath, String isAvailable,
			double rating, int restaurantId,String veg_nonVeg) {
		super();
		this.menuId = menuId;
		this.name = name;
		this.price = price;
		this.description = description;
		this.imagePath = imagePath;
		this.isAvailable = isAvailable;
		this.rating = rating;
		this.restaurantId = restaurantId;
		this.veg_nonVeg =veg_nonVeg;
	}

	//getters & setters
	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(String isAvailable) {
		this.isAvailable = isAvailable;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int resturantId) {
		this.restaurantId = resturantId;
	}

	public String getVeg_nonVeg() {
		return veg_nonVeg;
	}

	public void setVeg_nonVeg(String veg_nonVeg) {
		this.veg_nonVeg = veg_nonVeg;
	}

	

	

}
