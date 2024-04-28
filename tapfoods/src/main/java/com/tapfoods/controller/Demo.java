package com.tapfoods.controller;

import com.tapfoods.daoimpl.UserDaoImpl;
import com.tapfoods.model.User;

public class Demo {

	public static void main(String[] args) {
		UserDaoImpl udo = new UserDaoImpl();
		User user = new User(26, "lokey", "lokeykn@gmail.com", 8787878787l, "bangalore", "lokey", "lokey12", null, null, null);
		udo.updateUser(user);
		System.out.println("hi");
	}

}
