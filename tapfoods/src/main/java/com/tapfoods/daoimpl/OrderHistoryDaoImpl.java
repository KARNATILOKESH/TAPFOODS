package com.tapfoods.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tapfoods.dao.OrderHistoryDao;
import com.tapfoods.model.OrderHistory;

public class OrderHistoryDaoImpl implements OrderHistoryDao {

	private static Connection connection = null;

	//SQl Queries
	static final String INSERT_QUERY = "INSERT INTO `orderhistory`(`orderId`,`userId`) VALUES(?,?)";
	static final String SELECT_QUERY = "SELECT * FROM `orderhistory` WHERE `orderHistoryId`=?";
	static final String SELECT_ALL_QUERY = "SELECT * FROM `orderhistory`";
	static final String UPDATE_QUERY = "UPDATE `orderhistory` set `orderId`=?,`userId`=?  WHERE `orderHistoryId`=?";
	static final String DELETE_QUERY = "DELETE FROM `orderhistory`  WHERE `orderHistoryId`=?";

	public OrderHistoryDaoImpl() {

		// when we call constructor or create object these things will happen 
		String url = "jdbc:mysql://localhost:3306/tapfoods";
		String username = "root";
		String password = "root";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addOrderHistory(OrderHistory orderHistory) {
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = connection.prepareStatement(INSERT_QUERY);

			prepareStatement.setInt(1, orderHistory.getOrderId());
			prepareStatement.setInt(2, orderHistory.getUserId());

			prepareStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (prepareStatement != null)
				try {
					prepareStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}

	}

	@Override
	public OrderHistory getOrderHistory(int orderHistoryId) {
		PreparedStatement prepareStatement = null;
		ResultSet res = null;
		OrderHistory orderHistory = null;

		try {
			prepareStatement = connection.prepareStatement(SELECT_QUERY);

			prepareStatement.setInt(1, orderHistoryId);

			res = prepareStatement.executeQuery();

			if (res.next()) {

				int orderId = res.getInt("orderId");
				int userId = res.getInt("userId");

				orderHistory = new OrderHistory(orderHistoryId, orderId, userId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (prepareStatement != null)
				try {
					prepareStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}

		return orderHistory;
	}

	@Override
	public List<OrderHistory> getAllOrderHistorys() {
		Statement createStatement = null;
		ResultSet res = null;
		OrderHistory orderHistory = null;
		ArrayList<OrderHistory> orderHistorysList = new ArrayList<OrderHistory>();

		try {
			createStatement = connection.createStatement();

			res = createStatement.executeQuery(SELECT_ALL_QUERY);

			while (res.next()) {
				int orderHistoryId = res.getInt("orderHistoryId");
				int orderId = res.getInt("orderId");
				int userId = res.getInt("userId");

				orderHistory = new OrderHistory(orderHistoryId, orderId, userId);
				orderHistorysList.add(orderHistory);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (createStatement != null)
				try {
					createStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return orderHistorysList;
	}

	@Override
	public void updateOrderHistory(OrderHistory orderHistory) {
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = connection.prepareStatement(UPDATE_QUERY);

			prepareStatement.setInt(1, orderHistory.getOrderId());
			prepareStatement.setInt(2, orderHistory.getUserId());
			prepareStatement.setInt(3, orderHistory.getOrderHistoryId());

			prepareStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (prepareStatement != null)
				try {
					prepareStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}

	}

	@Override
	public void deleteOrderHistory(int OrderHistoryId) {
		PreparedStatement prepareStatement = null;

		try {
			prepareStatement = connection.prepareStatement(DELETE_QUERY);

			prepareStatement.setInt(1, OrderHistoryId);

			prepareStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (prepareStatement != null)
				try {
					prepareStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}

	}

}
