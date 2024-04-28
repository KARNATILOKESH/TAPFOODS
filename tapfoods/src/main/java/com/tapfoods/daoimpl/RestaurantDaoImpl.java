package com.tapfoods.daoimpl;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tapfoods.dao.RestaurantDao;
import com.tapfoods.model.Restaurant;

public class RestaurantDaoImpl implements RestaurantDao {
	private static Connection connection = null;

	//SQl queies
	static final String INSERT_QUERY = "INSERT INTO `restaurant`(`name`, `imagePath`, `ratings`, `eta`, `cuisineType`, `address`, `isActive`) VALUES (?,?,?,?,?,?,?)";
	static final String SELECT_QUERY = "SELECT * FROM `restaurant` WHERE `restaurantId`=?";
	static final String SELECT_ALL_QUERY = "SELECT * FROM `restaurant`";
	static final String UPDATE_QUERY = "UPDATE `restaurant` SET  `name`=?, `imagePath`=?, `ratings`=?, `eta`=?, `cuisineType`=?, `address`=?, `isActive`=? WHERE `restaurantId`=?";
	static final String DELETE_QUERY = "DELETE FROM `restaurant` WHERE `restaurantId`=?";
	static final String SELECT_ALL_BY_SEARCH = "SELECT * FROM `restaurant` where name like ?";

	public RestaurantDaoImpl() {
		
		String url = "jdbc:mysql://localhost:3306/tapfoods";
		String username = "root";
		String password = "root";
		try {
			// when we call constructor or create object these things will happen 
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void addRestaurant(Restaurant restaurant) {
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = connection.prepareStatement(INSERT_QUERY);

			
			prepareStatement.setString(1, restaurant.getName());
			prepareStatement.setString(2, restaurant.getImagePath());
			prepareStatement.setDouble(3, restaurant.getRating());
			prepareStatement.setString(4, restaurant.getEta());
			prepareStatement.setString(5, restaurant.getCuisineType());
			prepareStatement.setString(6, restaurant.getAddress());
			prepareStatement.setString(7, restaurant.getIsActive());
			

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
	public Restaurant getRestaurant(int restaurantId) {
		PreparedStatement prepareStatement = null;
		ResultSet res = null;
		Restaurant restaurant = null;

		try {
			prepareStatement = connection.prepareStatement(SELECT_QUERY);

			prepareStatement.setInt(1, restaurantId);

			res = prepareStatement.executeQuery();

			if (res.next()) {
				String name = res.getString("name");
				String imagePath = res.getString("imagePath");
				double ratings = res.getDouble("ratings");
				String eta = res.getString("eta");
				String cuisineType = res.getString("cuisineType");
				String address = res.getString("address");
				String isActive = res.getString("isActive");
				int restaurantOwnerId = res.getInt("restaurantOwnerId");

				restaurant = new Restaurant(restaurantId, name, imagePath, ratings, eta, cuisineType, address, isActive,
						restaurantOwnerId);
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

		return restaurant;
	}

	@Override
	public List<Restaurant> getAllRestaurants() {
		Statement createStatement = null;
		ResultSet res = null;
		Restaurant restaurant = null;

		ArrayList<Restaurant> restaurantsList = new ArrayList<Restaurant>();
		try {
			createStatement = connection.createStatement();

			res = createStatement.executeQuery(SELECT_ALL_QUERY);

			while (res.next()) {
				int restaurantid = res.getInt("restaurantId");
				String name = res.getString("name");
				String imagePath = res.getString("imagePath");
				double ratings = res.getDouble("ratings");
				String eta = res.getString("eta");
				String cuisineType = res.getString("cuisineType");
				String address = res.getString("address");
				String isActive = res.getString("isActive");
				int restaurantOwnerId = res.getInt("restaurantOwnerId");

				restaurant = new Restaurant(restaurantid, name, imagePath, ratings, eta, cuisineType, address, isActive,
						restaurantOwnerId);

				restaurantsList.add(restaurant);

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

		return restaurantsList;
	}

	@Override
	public void updateRestaurant(Restaurant restaurant) {
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = connection.prepareStatement(UPDATE_QUERY);

			prepareStatement.setString(1, restaurant.getName());
			prepareStatement.setString(2, restaurant.getImagePath());
			prepareStatement.setDouble(3, restaurant.getRating());
			prepareStatement.setString(4, restaurant.getEta());
			prepareStatement.setString(5, restaurant.getCuisineType());
			prepareStatement.setString(6, restaurant.getAddress());
			prepareStatement.setString(7, restaurant.getIsActive());

			prepareStatement.setInt(8, restaurant.getRestaurantId());

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
	public void deleteRestaurant(int RestaurantId) {
		PreparedStatement prepareStatement = null;

		try {
			prepareStatement = connection.prepareStatement(DELETE_QUERY);

			prepareStatement.setInt(1, RestaurantId);

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
	public List<Restaurant> getAllRestaurantsBySearch(String searchinput) {
		PreparedStatement prepareStatement = null;
		ResultSet res = null;
		Restaurant restaurant = null;
		ArrayList<Restaurant> restaurantsList = new ArrayList<Restaurant>();

		try {
			prepareStatement = connection.prepareStatement(SELECT_ALL_BY_SEARCH);

			prepareStatement.setString(1,"%"+  searchinput +"%");

			res = prepareStatement.executeQuery();
			while (res.next()) {
				int restaurantid = res.getInt("restaurantId");
				String name = res.getString("name");
				String imagePath = res.getString("imagePath");
				double ratings = res.getDouble("ratings");
				String eta = res.getString("eta");
				String cuisineType = res.getString("cuisineType");
				String address = res.getString("address");
				String isActive = res.getString("isActive");
				int restaurantOwnerId = res.getInt("restaurantOwnerId");

				restaurant = new Restaurant(restaurantid, name, imagePath, ratings, eta, cuisineType, address, isActive,
						restaurantOwnerId);

				restaurantsList.add(restaurant);

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

		return restaurantsList;

	}

}
