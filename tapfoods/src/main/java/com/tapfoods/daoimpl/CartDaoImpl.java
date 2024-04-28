package com.tapfoods.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tapfoods.dao.CartDao;
import com.tapfoods.model.CartItem;
import com.tapfoods.model.OrderHistory;

public class CartDaoImpl  implements CartDao{
	
	private static Connection connection = null;

	//SQl Queries  
	static final String INSERT_QUERY = "INSERT INTO `cart`(`itemName`,`price`,`restaurantId`,`quantity`) VALUES(?,?,?,?)";
	static final String SELECT_QUERY = "SELECT * FROM `cart` WHERE `cartId`=?";
	static final String SELECT_ALL_QUERY = "SELECT * FROM `cart`";
	static final String UPDATE_QUERY = "UPDATE `cart` set `price`=?  WHERE `itemName`=?";
	static final String DELETE_QUERY = "DELETE FROM `cart`  WHERE `cartId`=?";
	static final String TRUNCATE_QUERY = "DELETE FROM `cart`";
	static final String UPDATE_QUANTITY_QUERY1 = "UPDATE `cart` set `quantity`=?  WHERE `cartId`=?";
	static final String UPDATE_QUANTITY_QUERY = "UPDATE `cart` set `quantity`=?  WHERE `itemName`=?";
	static final String SELECT_QUERY_BY_ITEMNAME = "SELECT * FROM `cart` WHERE `itemName`=?";


	public CartDaoImpl() {

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
	public void addCart(CartItem cart) {
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = connection.prepareStatement(INSERT_QUERY);

			prepareStatement.setString(1, cart.getItemName());
			prepareStatement.setDouble(2, cart.getPrice());
			prepareStatement.setInt(3, cart.getRestaurantId());
			prepareStatement.setInt(4, cart.getQuantity());

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
	public CartItem getCart(int cartId) {
		PreparedStatement prepareStatement = null;
		ResultSet res = null;
		CartItem cart = null;

		try {
			prepareStatement = connection.prepareStatement(SELECT_QUERY);

			prepareStatement.setInt(1, cartId);

			res = prepareStatement.executeQuery();

			if (res.next()) {

				
				String itemName = res.getString("itemName");
				double price = res.getDouble("price");
				int restaurantId = res.getInt("restaurantId");
				int quantity = res.getInt("quantity");
				String imagePath = res.getString("imagePath");
				
			 cart = new CartItem(cartId, itemName, price, restaurantId,quantity,imagePath);
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

		return cart;
	}

	@Override
	public List<CartItem> getAllCart() {
		Statement createStatement = null;
		ResultSet res = null;
		CartItem cart = null;
		ArrayList<CartItem> cartList = new ArrayList<CartItem>();

		try {
			createStatement = connection.createStatement();

			res = createStatement.executeQuery(SELECT_ALL_QUERY);

			while (res.next()) {
				int cartId = res.getInt("cartId");
				String itemName = res.getString("itemName");
				double price = res.getDouble("price");
				int restaurantId = res.getInt("restaurantId");
				int quantity = res.getInt("quantity");
				String imagePath = res.getString("imagePath");
				
				 cart = new CartItem(cartId, itemName, price, restaurantId,quantity,imagePath);
				cartList.add(cart);
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
		return cartList;
	}

	@Override
	public void updateCart(CartItem cart) {
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = connection.prepareStatement(UPDATE_QUERY);

			prepareStatement.setDouble(1, cart.getPrice());
			prepareStatement.setString(2, cart.getItemName());
			


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
	public void deleteCart(int cartId) {
		PreparedStatement prepareStatement = null;

		try {
			prepareStatement = connection.prepareStatement(DELETE_QUERY);

			prepareStatement.setInt(1, cartId);

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
	public void truncateCart() {
		
		Statement createStatement = null;
	

		try {
			createStatement = connection.createStatement();

			createStatement.executeUpdate(TRUNCATE_QUERY );

	         
	}
		 catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (createStatement != null)
					try {
						createStatement.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
			}
	}

	@Override
	public int updateQuantity(String itemName,int quantity) {
		PreparedStatement prepareStatement = null;
		int i =0;
		try {
			prepareStatement = connection.prepareStatement(UPDATE_QUANTITY_QUERY);

			prepareStatement.setInt(1, quantity);
			
			prepareStatement.setString(2, itemName);
			 i = prepareStatement.executeUpdate();

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
		return i;
}

	@Override
	public CartItem getCartByItemName(String itemName) {
		PreparedStatement prepareStatement = null;
		ResultSet res = null;
		CartItem cart = null;

		try {
			prepareStatement = connection.prepareStatement(SELECT_QUERY_BY_ITEMNAME);

			prepareStatement.setString(1, itemName);

			res = prepareStatement.executeQuery();

			if (res.next()) {

				
				int cartId = res.getInt("cartId");
				double price = res.getDouble("price");
				int restaurantId = res.getInt("restaurantId");
				int quantity = res.getInt("quantity");
				String imagePath = res.getString("imagePath");
				
			 cart = new CartItem(cartId, itemName, price, restaurantId,quantity,imagePath);
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

		return cart;
	}

	@Override
	public int updateQuantity(int id, int quantity) {
		PreparedStatement prepareStatement = null;
		int i =0;
		try {
			prepareStatement = connection.prepareStatement(UPDATE_QUANTITY_QUERY1);

			prepareStatement.setInt(1, quantity);
			
			prepareStatement.setInt(2, id);
			 i = prepareStatement.executeUpdate();

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
		return i;
	}
}
