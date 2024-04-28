package com.tapfoods.dao;

import java.util.List;

import com.tapfoods.model.Order;
import com.tapfoods.model.Restaurant;

public interface OrderDao {
	void addOrder(Order order);

	Order getOrder(String orderId);

	List<Order> getAllOrders();

	void updateOrder(Order order);

	void deleteOrder(int orderId);

}
