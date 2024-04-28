package com.tapfoods.daoimpl;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tapfoods.dao.MenuDao;
import com.tapfoods.model.Menu;

public class MenuDaoImpl implements MenuDao{

	private static Connection connection = null;

	static final String INSERT_QUERY = "INSERT INTO `menu`( `name`, `price`, `description`, `imagePath`, `isAvailable`, `rating`, `restaurantId`,'veg_nonVeg`)VALUES (?,?,?,?,?,?,?,?)";
	static final String SELECT_QUERY = "SELECT * FROM `menu` WHERE `menuId`=?";
	static final String SELECT_ALL_QUERY = "SELECT * from `menu`";
	static final String UPDATE_QUERY = "UPDATE `menu` SET  `name`=?,`price`=?,`description`=?,`imagePath`=?,`isAvailable`=?,`rating`=?,`restaurantId`=? WHERE `menuId`=?";
	static final String DELETE_QUERY = "DELETE FROM `menu` WHERE `menuId`=?";
	static final String SELECT_BY_RESTURANTID = "SELECT * FROM `menu` WHERE `restaurantId`=?";
	static final String SELECT_BY_SEARCH = "SELECT * FROM `menu` WHERE `name` like ? And `restaurantId`=?";
	static final String SELECT_TOP_RATED_QUERY = "SELECT * from `menu` WHERE  `restaurantId`=?  order by `rating` desc ";
	static final String SELECT_PRICE_LOW_TO_HIGH_QUERY = "SELECT * from `menu` WHERE `restaurantId`=? order by `price` asc";
	static final String SELECT_PRICE_HIGH_TO_LOW_QUERY = "SELECT * from `menu` WHERE `restaurantId`=? order by `price` desc ";
	static final String SELECT_ONLY_VEG_QUERY = "SELECT * from `menu` WHERE `restaurantId`=? AND `veg_nonVeg`='veg' ";
	static final String SELECT_ONLY_NONVEG_QUERY = "SELECT * from `menu` WHERE `restaurantId`=? AND `veg_nonVeg`='non-veg' ";
	

	public MenuDaoImpl() {
		
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
	public void addMenu(Menu menu) {
		PreparedStatement prepareStatement=null;
		try {
			prepareStatement = connection.prepareStatement(INSERT_QUERY);
			
			
			prepareStatement.setString(1, menu.getName());
			prepareStatement.setDouble(2, menu.getPrice());
			prepareStatement.setString(3, menu.getDescription());
			prepareStatement.setString(4, menu.getImagePath());
			prepareStatement.setString(5, menu.getIsAvailable());
			prepareStatement.setDouble(6, menu.getRating());
			prepareStatement.setInt(7, menu.getRestaurantId());
			prepareStatement.setString(8, menu.getVeg_nonVeg());
			
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
	public Menu getMenu(int menuId) {
		PreparedStatement prepareStatement = null;
		ResultSet res = null;
		Menu menu = null;

		try {
			prepareStatement = connection.prepareStatement(SELECT_QUERY);

			prepareStatement.setInt(1, menuId);

			res = prepareStatement.executeQuery();

			if (res.next()) {
				String name = res.getString("name");
				double price = res.getDouble("price");
				String description = res.getString("description");
				String imagePath = res.getString("imagePath");
				String isAvailable = res.getString("isAvailable");
				double rating = res.getDouble("rating");
				int restaurantId = res.getInt("restaurantId");
				String veg_nonVeg = res.getString("veg_nonVeg");
				 menu = new Menu(menuId, name, price, description, imagePath, isAvailable, rating, restaurantId,veg_nonVeg);
				
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
		return menu;
	}

	@Override
	public List<Menu> getAllMenus() {
		Statement createStatement = null;
		ResultSet res = null;
		Menu menu = null;

		ArrayList<Menu> menuList = new ArrayList<Menu>();
		try {
			createStatement = connection.createStatement();

			res = createStatement.executeQuery(SELECT_ALL_QUERY);

			while (res.next())
			{
				
			    int menuId=res.getInt("menuId");
				String name = res.getString("name");
				double price = res.getDouble("price");
				String description = res.getString("description");
				String imagePath = res.getString("imagePath");
				String isAvailable = res.getString("isAvailable");
				double rating = res.getDouble("rating");
				int restaurantId = res.getInt("restaurantId");
				String veg_nonVeg = res.getString("veg_nonVeg");
				 menu = new Menu(menuId, name, price, description, imagePath, isAvailable, rating, restaurantId,veg_nonVeg);
				
				 menuList.add(menu);
				

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
		return menuList;
	}

	@Override
	public void updateMenu(Menu menu) {
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = connection.prepareStatement(UPDATE_QUERY);


			prepareStatement.setString(1, menu.getName());
			prepareStatement.setDouble(2, menu.getPrice());
			prepareStatement.setString(3, menu.getDescription());
			prepareStatement.setString(4, menu.getImagePath());
			prepareStatement.setString(5, menu.getIsAvailable());
			prepareStatement.setDouble(6, menu.getRating());
			prepareStatement.setInt(7, menu.getRestaurantId());
			prepareStatement.setInt(8,menu.getMenuId());
			
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
	public void deleteMenu(int menuId) {
		PreparedStatement prepareStatement = null;

		try {
			prepareStatement = connection.prepareStatement(DELETE_QUERY);

			prepareStatement.setInt(1, menuId);

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
	public List<Menu> getByRestaurantId(int restaurantId) {
		PreparedStatement prepareStatement = null;
		ResultSet res = null;
		Menu menu = null;
		
		ArrayList<Menu> menuList = new ArrayList<Menu>();

		try {
			prepareStatement = connection.prepareStatement(SELECT_BY_RESTURANTID);

			prepareStatement.setInt(1,restaurantId);

			res = prepareStatement.executeQuery();

			while(res.next()) {
				int menuId=res.getInt("menuId");
				String name = res.getString("name");
				double price = res.getDouble("price");
				String description = res.getString("description");
				String imagePath = res.getString("imagePath");
				String isAvailable = res.getString("isAvailable");
				double rating = res.getDouble("rating");
				String veg_nonVeg = res.getString("veg_nonVeg");
				 menu = new Menu(menuId, name, price, description, imagePath, isAvailable, rating, restaurantId,veg_nonVeg);
				
				 menuList.add(menu);
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
		return menuList;
	}


	@Override
	public List<Menu> getAllBySearch(String input,int rid) {
		PreparedStatement prepareStatement = null;
		ResultSet res = null;
		Menu menu = null;
		
		ArrayList<Menu> menuList = new ArrayList<Menu>();

		try {
			prepareStatement = connection.prepareStatement(SELECT_BY_SEARCH);

			prepareStatement.setString(1,"%"+input+"%");
			prepareStatement.setInt(2,rid );

			res = prepareStatement.executeQuery();

			while(res.next()) {
				int menuId=res.getInt("menuId");
				String name = res.getString("name");
				double price = res.getDouble("price");
				String description = res.getString("description");
				String imagePath = res.getString("imagePath");
				String isAvailable = res.getString("isAvailable");
				double rating = res.getDouble("rating");
				int restaurantId = res.getInt("restaurantId");
				String veg_nonVeg = res.getString("veg_nonVeg");
				 menu = new Menu(menuId, name, price, description, imagePath, isAvailable, rating, restaurantId,veg_nonVeg);
				
				 menuList.add(menu);
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
		return menuList;
	}


	@Override
	public List<Menu> getTopRatedItems(int restaurantId) {
		PreparedStatement prepareStatement = null;
		ResultSet res = null;
		Menu menu = null;
		
		ArrayList<Menu> menuList = new ArrayList<Menu>();

		try {
			prepareStatement = connection.prepareStatement(SELECT_TOP_RATED_QUERY);

			prepareStatement.setInt(1,restaurantId);

			res = prepareStatement.executeQuery();

			while(res.next()) {
				int menuId=res.getInt("menuId");
				String name = res.getString("name");
				double price = res.getDouble("price");
				String description = res.getString("description");
				String imagePath = res.getString("imagePath");
				String isAvailable = res.getString("isAvailable");
				double rating = res.getDouble("rating");
				String veg_nonVeg = res.getString("veg_nonVeg");
				 menu = new Menu(menuId, name, price, description, imagePath, isAvailable, rating, restaurantId,veg_nonVeg);
				
				 menuList.add(menu);
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
		return menuList;
	}


	@Override
	public List<Menu> getPriceLowToHigh(int restaurantId) {
		PreparedStatement prepareStatement = null;
		ResultSet res = null;
		Menu menu = null;
		
		ArrayList<Menu> menuList = new ArrayList<Menu>();

		try {
			prepareStatement = connection.prepareStatement(SELECT_PRICE_LOW_TO_HIGH_QUERY);

			prepareStatement.setInt(1,restaurantId);

			res = prepareStatement.executeQuery();

			while(res.next()) {
				int menuId=res.getInt("menuId");
				String name = res.getString("name");
				double price = res.getDouble("price");
				String description = res.getString("description");
				String imagePath = res.getString("imagePath");
				String isAvailable = res.getString("isAvailable");
				double rating = res.getDouble("rating");
				String veg_nonVeg = res.getString("veg_nonVeg");
				 menu = new Menu(menuId, name, price, description, imagePath, isAvailable, rating, restaurantId,veg_nonVeg);
				
				 menuList.add(menu);
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
		return menuList;
	}


	@Override
	public List<Menu> getPriceHighToLow(int restaurantId) {
		PreparedStatement prepareStatement = null;
		ResultSet res = null;
		Menu menu = null;
		
		ArrayList<Menu> menuList = new ArrayList<Menu>();

		try {
			prepareStatement = connection.prepareStatement(SELECT_PRICE_HIGH_TO_LOW_QUERY);

			prepareStatement.setInt(1,restaurantId);

			res = prepareStatement.executeQuery();

			while(res.next()) {
				int menuId=res.getInt("menuId");
				String name = res.getString("name");
				double price = res.getDouble("price");
				String description = res.getString("description");
				String imagePath = res.getString("imagePath");
				String isAvailable = res.getString("isAvailable");
				double rating = res.getDouble("rating");
				String veg_nonVeg = res.getString("veg_nonVeg");
				 menu = new Menu(menuId, name, price, description, imagePath, isAvailable, rating, restaurantId,veg_nonVeg);
				
				 menuList.add(menu);
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
		return menuList;
	}


	@Override
	public List<Menu> getOnlyVeg(int restaurantId) {
		PreparedStatement prepareStatement = null;
		ResultSet res = null;
		Menu menu = null;
		
		ArrayList<Menu> menuList = new ArrayList<Menu>();

		try {
			prepareStatement = connection.prepareStatement(SELECT_ONLY_VEG_QUERY);

			prepareStatement.setInt(1,restaurantId);
			

			res = prepareStatement.executeQuery();

			while(res.next()) {
				int menuId=res.getInt("menuId");
				String name = res.getString("name");
				double price = res.getDouble("price");
				String description = res.getString("description");
				String imagePath = res.getString("imagePath");
				String isAvailable = res.getString("isAvailable");
				double rating = res.getDouble("rating");
				String veg_nonVeg = res.getString("veg_nonVeg");
				 menu = new Menu(menuId, name, price, description, imagePath, isAvailable, rating, restaurantId,veg_nonVeg);
				
				 menuList.add(menu);
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
		return menuList;
	}


	@Override
	public List<Menu> getOnlyNonVeg(int restaurantId) {
		PreparedStatement prepareStatement = null;
		ResultSet res = null;
		Menu menu = null;
		
		ArrayList<Menu> menuList = new ArrayList<Menu>();

		try {
			prepareStatement = connection.prepareStatement(SELECT_ONLY_NONVEG_QUERY);

			prepareStatement.setInt(1,restaurantId);
			
			

			res = prepareStatement.executeQuery();

			while(res.next()) {
				int menuId=res.getInt("menuId");
				String name = res.getString("name");
				double price = res.getDouble("price");
				String description = res.getString("description");
				String imagePath = res.getString("imagePath");
				String isAvailable = res.getString("isAvailable");
				double rating = res.getDouble("rating");
				String veg_nonVeg = res.getString("veg_nonVeg");
				
				 menu = new Menu(menuId, name, price, description, imagePath, isAvailable, rating, restaurantId,veg_nonVeg);
				
				 menuList.add(menu);
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
		return menuList;
	}
	

}
