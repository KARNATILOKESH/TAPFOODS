package com.tapfoods.dao;

import java.util.List;

import com.tapfoods.model.OrderHistory;

public interface OrderHistoryDao {

	void addOrderHistory(OrderHistory orderHistory);

	OrderHistory getOrderHistory(int orderHistoryId);

	List<OrderHistory> getAllOrderHistorys();

	void updateOrderHistory(OrderHistory orderHistory);

	void deleteOrderHistory(int OrderHistoryId);

}
