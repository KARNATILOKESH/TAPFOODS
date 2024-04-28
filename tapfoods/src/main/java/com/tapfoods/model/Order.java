package com.tapfoods.model;

import java.sql.Date;

public class Order {
	private String orderId;
	private int restaurantId;
	private int userId;
	private double totalAmount;
	private String modeOfPayment;
	private String status;
	private Date orderDate;

	// zero-parameterized constructor
	public Order() {
	}

	// parameterized constructor
	public Order(String orderId, int restaurantId, int userId, double totalAmount, String modeOfPayment, String status, Date orderDate) {
		super();
		this.orderId = orderId;
		this.restaurantId = restaurantId;
		this.userId = userId;
		this.totalAmount = totalAmount;
		this.modeOfPayment = modeOfPayment;
		this.status = status;
		this.orderDate = orderDate;
	}

	//getters & setters
	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getModeOfPayment() {
		return modeOfPayment;
	}

	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	//to-String method
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", restaurantId=" + restaurantId + ", userId=" + userId + ", totalAmount="
				+ totalAmount + ", modeOfPayment=" + modeOfPayment + ", status=" + status + "]";
	}

}
