package com.tapfoods.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tapfoods.daoimpl.UserDaoImpl;
import com.tapfoods.model.User;

@WebServlet("/sign-up")
public class SignupServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		// to convert text to html without this .html file print in text format
		resp.setContentType("text/html");

		// getting data from Signup page (request parameter store data in the form of
		// string so convert into long)
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		long phoneNo = Long.parseLong(req.getParameter("phoneNo"));
		String userName = req.getParameter("userName");
		String password = req.getParameter("password");

		// to encrypt the username and password
		String encryptedUserName = callEncryption(userName);
		String encryptedPassword = callEncryption(password);

		UserDaoImpl userDaoImpl = new UserDaoImpl();

		// checking if the User is already present or not
		User user = userDaoImpl.getLoginDetails(encryptedUserName);

		callEncryption(userName);
		// if username is not present in database then we add
		if (user == null) {

			User user1 = new User(0, name, email, phoneNo, null, encryptedUserName, encryptedPassword, null, null,
					null);

			// inserting data into database
			userDaoImpl.addUser(user1);

			// redirecting to login page
			out.println("<div  class='successmes'>&nbsp;&#9989;signup successful</div>");
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("Login.jsp");
			requestDispatcher.include(req, resp);

		}
		// if user is alredy there then printing message as Username is already taken
		// try differen
		else {

			out.println("<div  class='em'><b>*Username is already taken try different</b></div>");

			RequestDispatcher requestDispatcher = req.getRequestDispatcher("Signup.jsp");
			requestDispatcher.include(req, resp);
		}

	}

	private static String callEncryption(String text) {
		String encriptedValue = "";

		for (int i = 0; i < text.length(); i++) {
			char charvalue = text.charAt(i);

			int asciiValue = charvalue;

			int encryptingVaLue = asciiValue - 12878;

			char encrname = (char) encryptingVaLue;

			encriptedValue = encriptedValue + encrname;

		}
		return encriptedValue;

	}
  
	// to decrypt data
	static private String callDecryption(String text) {
		String decryptioncode = "";

		for (int i = 0; i < text.length(); i++) {
			char charValue = text.charAt(i);

			int decryptionvalue = charValue;

			int decryptedcode = decryptionvalue + 12878;

			char recharavalue = (char) decryptedcode;

			decryptioncode = decryptioncode + recharavalue;

		}
		return decryptioncode;
	}

}
