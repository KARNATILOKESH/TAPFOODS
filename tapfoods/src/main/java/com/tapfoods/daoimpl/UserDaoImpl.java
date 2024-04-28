package com.tapfoods.daoimpl;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.tapfoods.dao.UserDao;
import com.tapfoods.model.User;

public class UserDaoImpl implements UserDao {

	private static Connection connection = null;

	// SQL queries
	static final String INSERT_QUERY = "INSERT INTO `user`( `name`, `email`,`phoneNo`, `address`, `userName`,`password`,`role`) VALUES (?,?,?,?,?,?,?)";
	static final String SELECT_QUERY = "SELECT * FROM `user` WHERE `userId`=?";
	static final String SELECT_ALL_QUERY = "SELECT * from `user`";
	static final String UPDATE_QUERY = "UPDATE `user` SET  `name`=?,`email`=?,`phoneNo`=?,`address`=?,`userName`=?,`password`=?,`role`=? WHERE `userId`=?";
	static final String DELETE_QUERY = "DELETE FROM `user` WHERE `userId`=?";
	static final String SELECT_LOGINDEDTAILS= "SELECT * FROM `user` WHERE `userName`=?";
	static final String UPDATE_PASSWORD = "UPDATE `user` SET  `password`=? WHERE `userName`=? ";
	static final String UPDATE_ADDRESS = "UPDATE `user` SET  `address`=? WHERE `userId`=? ";
	
	public UserDaoImpl() {
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
	public void addUser(User user) {
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = connection.prepareStatement(INSERT_QUERY);
			prepareStatement.setString(1, user.getName());
			prepareStatement.setString(2, user.getEmail());
			prepareStatement.setLong(3, user.getPhoneNo());
			prepareStatement.setString(4, user.getAddress());
			prepareStatement.setString(5, user.getUserName());
			prepareStatement.setString(6, user.getPassword());
			prepareStatement.setString(7, user.getRole());

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
	public User getUser(int userId) {
		PreparedStatement prepareStatement = null;
		ResultSet res = null;
		User user = null;

		try {
			prepareStatement = connection.prepareStatement(SELECT_QUERY);
			prepareStatement.setInt(1, userId);

			res = prepareStatement.executeQuery();

			if (res.next()) {
				int userid = res.getInt("userId");
				String name = res.getString("name");
				String email = res.getString("email");
				long phoneno = res.getLong("phoneNo");
				String address = res.getString("address");
//				String username = ;
				String password = res.getString("password");
				String role = res.getString("role");
				Date createdDate = res.getDate("createdDate");
				Date lastLogin = res.getDate("lastLogin");
				
				String decryptedUserName = callDecryption(res.getString("userName"));
				
				
				user = new User(userid, name, email, phoneno, address, decryptedUserName, password, role, createdDate,
						lastLogin);
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

		return user;
	}

	@Override
	public List<User> getAllUsers() {
		Statement createStatement = null;
		ResultSet res = null;
		User user = null;
		ArrayList<User> usersList = new ArrayList<User>();
		try {
			createStatement = connection.createStatement();

			res = createStatement.executeQuery(SELECT_ALL_QUERY);

			while (res.next()) {
				int userid = res.getInt("userId");
				String name = res.getString("name");
				String email = res.getString("email");
				long phoneno = res.getLong("phoneNo");
				String address = res.getString("address");
//				String username = ;
				String password = res.getString("password");
				String role = res.getString("role");
				Date createdDate = res.getDate("createdDate");
				Date lastLogin = res.getDate("lastLogin");
				
				String decryptedUserName = callDecryption(res.getString("userName"));
				

				user = new User(userid, name, email, phoneno, address, decryptedUserName, password, role, createdDate,
						lastLogin);

				usersList.add(user);
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

		return usersList;
	}

	@Override
	public void updateUser(User user) {

		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = connection.prepareStatement(UPDATE_QUERY);
			prepareStatement.setString(1, user.getName());
			prepareStatement.setString(2, user.getEmail());
			prepareStatement.setLong(3, user.getPhoneNo());
			prepareStatement.setString(4, user.getAddress());
			prepareStatement.setString(5, user.getUserName());
			prepareStatement.setString(6, user.getPassword());
			prepareStatement.setString(7, user.getRole());
			

			prepareStatement.setInt(8, user.getUserId());

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
	public void deleteUser(int userId) {
		PreparedStatement prepareStatement = null;

		try {
			prepareStatement = connection.prepareStatement(DELETE_QUERY);
			prepareStatement.setInt(1, userId);

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
	public User getLoginDetails(String userName) {
		
		PreparedStatement prepareStatement = null;
		ResultSet res = null;
		User user = null;

		try {
			prepareStatement = connection.prepareStatement(SELECT_LOGINDEDTAILS);
			prepareStatement.setString(1, userName);

			res = prepareStatement.executeQuery();

			if (res.next()) {
				int userid = res.getInt("userId");
				String name = res.getString("name");
				String email = res.getString("email");
				long phoneno = res.getLong("phoneNo");
				String address = res.getString("address");
//				String username = ;
				String password = res.getString("password");
				String role = res.getString("role");
				Date createdDate = res.getDate("createdDate");
				Date lastLogin = res.getDate("lastLogin");
				
				String decryptedUserName = callDecryption(res.getString("userName"));
				user = new User(userid, name, email, phoneno, address, decryptedUserName, password, role, createdDate,
						lastLogin);
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

		return user;
		
	}
	
	@Override
	public void updatePassword(String username,String password) {
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = connection.prepareStatement(UPDATE_PASSWORD);
		
			prepareStatement.setString(1,password);
			prepareStatement.setString(2,username);
		

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
	public void updateAddress(int userId,String address) {
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = connection.prepareStatement(UPDATE_ADDRESS);
		
			prepareStatement.setString(1,address);
			prepareStatement.setInt(2,userId);
		

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
	
	
	
	
	
	static private String callDecryption(String text) {
	     String decryptioncode="";
	     
	     for(int i=0;i<text.length();i++)
	     {
	    	 char charValue = text.charAt(i);
	    	 
	    	 int decryptionvalue=charValue;
	    	 
	    	 int decryptedcode=decryptionvalue+12878;
	    	 
	    	 char recharavalue=(char)decryptedcode;
	    	 
	    	 decryptioncode=decryptioncode+recharavalue;
	    	 
	     }
	     return decryptioncode;
	}

	

}
