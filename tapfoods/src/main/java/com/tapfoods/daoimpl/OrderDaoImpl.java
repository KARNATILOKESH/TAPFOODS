package com.tapfoods.daoimpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tapfoods.dao.OrderDao;
import com.tapfoods.model.Menu;
import com.tapfoods.model.Order;
import com.tapfoods.model.Restaurant;

public class OrderDaoImpl implements OrderDao{

	private static Connection connection = null;
	//Sql queries
	static final String INSERT_QUERY = "INSERT INTO `order`(`orderId`,`restaurantId`, `userId`, `totalAmount`, `modeOfPayment`, `status`)VALUES (?,?,?,?,?,?)";
	static final String SELECT_QUERY = "SELECT * FROM `order` WHERE `orderId`=?";
	static final String SELECT_ALL_QUERY = "SELECT * from `order`";
	static final String UPDATE_QUERY = "UPDATE `order` SET  `restaurantId`=?,`userId`=?,`totalAmount`=?,`modeOfPayment`=?,`status`=? WHERE `orderId`=?";
	static final String DELETE_QUERY = "DELETE FROM `order` WHERE `orderId`=?";
	
	public OrderDaoImpl() {

		// when we call constructor or create object these things will happen 
		String url = "jdbc:mysql://localhost:3306/tapfoods";
		String username = "root";
		String password = "root";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url,username,password);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	
	}
	
	@Override
	public void addOrder(Order order) {
		PreparedStatement prepareStatement=null;
		try {
			prepareStatement = connection.prepareStatement(INSERT_QUERY);
			
			prepareStatement.setString(1,order.getOrderId());
			prepareStatement.setInt(2, order.getRestaurantId());
			prepareStatement.setInt(3, order.getUserId());
			prepareStatement.setDouble(4, order.getTotalAmount());
			prepareStatement.setString(5, order.getModeOfPayment());
			prepareStatement.setString(6,order.getStatus());
			
			
			prepareStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (prepareStatement != null)
					prepareStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public Order getOrder(String orderId) {
		PreparedStatement prepareStatement = null;
		ResultSet res = null;
		Order order=null;

		try {
			prepareStatement = connection.prepareStatement(SELECT_QUERY);

			prepareStatement.setString(1, orderId);

			res = prepareStatement.executeQuery();

			if (res.next()) {
				int restaurantId = res.getInt("restaurantId");
				int userId = res.getInt("userId");
				double totalAmount = res.getDouble("totalAmount");
				String modeOfPayment = res.getString("modeOfPayment");
				String status = res.getString("status");
				Date orderDate = res.getDate("orderDate");
				
			 order = new Order(orderId, restaurantId, userId, totalAmount, modeOfPayment, status,orderDate);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (prepareStatement != null)
					prepareStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return order;
	}

	@Override
	public List<Order> getAllOrders() {
		Statement createStatement = null;
		ResultSet res = null;
		Order order = null;

		ArrayList<Order> orderList = new ArrayList<Order>();
		try {
			createStatement = connection.createStatement();

			res = createStatement.executeQuery(SELECT_ALL_QUERY);

			while (res.next())
			{
				String orderid=res.getString("orderId");
				int restaurantId = res.getInt("restaurantId");
				int userId = res.getInt("userId");
				double totalAmount = res.getDouble("totalAmount");
				String modeOfPayment = res.getString("modeOfPayment");
				String status = res.getString("status");
				Date orderDate = res.getDate("orderDate");
				
			 order = new Order(orderid, restaurantId, userId, totalAmount, modeOfPayment, status,orderDate);
			 orderList.add(order);
				

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (createStatement != null)
					createStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return orderList;
	}

	@Override
	public void updateOrder(Order order) {
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = connection.prepareStatement(UPDATE_QUERY);


			prepareStatement.setInt(1, order.getRestaurantId());
			prepareStatement.setInt(2, order.getUserId());
			prepareStatement.setDouble(3, order.getTotalAmount());
			prepareStatement.setString(4, order.getModeOfPayment());
			prepareStatement.setString(5,order.getStatus());
			prepareStatement.setString(6,order.getOrderId());
			
			
			prepareStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (prepareStatement != null)
					prepareStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void deleteOrder(int orderId) {
		PreparedStatement prepareStatement = null;

		try {
			prepareStatement = connection.prepareStatement(DELETE_QUERY);

			prepareStatement.setInt(1, orderId);

			prepareStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (prepareStatement != null)
					prepareStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

}
