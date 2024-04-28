package com.tapfoods.model;

public class OrderHistory {

	private int orderHistoryId;
	private int orderId;
	private int userId;

	// zero-parameterized constructor
	public OrderHistory() {
	}

	// parameterized constructor
	public OrderHistory(int orderHistoryId, int orderId, int userId) {
		super();
		this.orderHistoryId = orderHistoryId;
		this.orderId = orderId;
		this.userId = userId;
	}

	//getters & setters
	public int getOrderHistoryId() {
		return orderHistoryId;
	}

	public void setOrderHistoryId(int orderHistoryId) {
		this.orderHistoryId = orderHistoryId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	//to-String method
	@Override
	public String toString() {
		return "OrderHistory [orderHistoryId=" + orderHistoryId + ", orderId=" + orderId + ", userId=" + userId + "]";
	}
	
	
	
	

}
