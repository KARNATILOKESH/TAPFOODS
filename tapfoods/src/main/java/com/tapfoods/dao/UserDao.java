package com.tapfoods.dao;

import java.util.List;

import com.tapfoods.model.User;

public interface UserDao 
{
	void addUser(User user);

	User getUser(int userId);

	List<User> getAllUsers();

	void updateUser(User user);

	void updateAddress(int userId,String address);

	void deleteUser(int userId);
	
	User getLoginDetails(String userName);
	
    void updatePassword(String username,String password);
     

}
