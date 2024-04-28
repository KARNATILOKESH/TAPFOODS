package com.tapfoods.model;

public class CartItem {
	
	private int itemId;
	private String itemName;
	private double price;
	private int  restaurantId;
	private int quantity;
	private String imagePath;
	
	public CartItem() {
	}
	
	
	public CartItem(int itemId, String itemName, double price, int restaurantId,int quantity,String imagePath) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.price = price;
		this.restaurantId = restaurantId;
		this.quantity=quantity;
		this.imagePath=imagePath;
		
	}
	
	public int getItemId() {
		return itemId;
	}

	public void setItemId(int cartId) {
		this.itemId = cartId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getImagePath() {
		return imagePath;
	}
	
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	
	@Override
	public String toString() {
		return "Cart [cartId=" + itemId + ", itemName=" + itemName + ", price=" + price + ", restaurantId="
				+ restaurantId + ", quantity=" + quantity + "]";
	}
	
	

	

}
