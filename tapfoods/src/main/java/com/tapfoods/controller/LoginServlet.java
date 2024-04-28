package com.tapfoods.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tapfoods.daoimpl.UserDaoImpl;
import com.tapfoods.model.User;

@WebServlet("/loginservlet")
public class LoginServlet extends HttpServlet {

	static int count = 3;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();// geting session object

		PrintWriter out = resp.getWriter();

		resp.setContentType("text/html");// it converts test to html without this .html file print as text

		// getting data from login page
		String userName = req.getParameter("userName");
		String password = req.getParameter("password");

		// encripting the userdetails
		String encryptedUserName = callEncryption(userName);
		String encryptedPassword = callEncryption(password);

		UserDaoImpl userDaoImpl = new UserDaoImpl();
		// checking the user is present or not in database
		// if username is there then it store all data about that row into user
		User user = userDaoImpl.getLoginDetails(encryptedUserName);

		// if there is a user eith this username then "user" must not be null
		if (user != null) {
			// getting password through username using getLoginDetails method
			String databasepassword = user.getPassword();
			if (encryptedPassword.equals(databasepassword)) {
				// to print user name and details in restaurant page ewe store data in session
				session.setAttribute("user", user);

				// redirecting to restaurant servlet
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("Restaurantservlet");
				requestDispatcher.forward(req, resp);
			}
			// giving only 3 chances to user if user enters wrong password
			else if (count > 0) {
				// printing wrong password this many attemts you have
				out.print("<div class='errormessage2'><b>*Wrong  password " + count-- + " Attempts left</b></div>");
				// and redirecting to same login page through servlet
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("Login.jsp");
				// to print data that wrote above we use "include"
				requestDispatcher.include(req, resp);

			} else {
				// if user uses all 3 attmepts then no more chance for him just printing this
				// statement
				out.println(
						"<div class='errormessage'><b> *Wrong password, attempts over if you forgot your password <br> reset your password</b></div> ");
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("ResetPassword.jsp");
				requestDispatcher.include(req, resp);
			}
		}
		// if username is not there in database thent giving user another 3 chances to
		// give correct username
		else if (count > 0) {
			out.print("<div class='errormessage1'><b>*username is not found " + count-- + " Attempts left</b></div>");
			// and redirecting to same login page through servlet
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("Login.jsp");
			requestDispatcher.include(req, resp);
		} else {
			// if user uses all 3 attmepts then no more chance for him just printing this
			// statement

			out.println(
					"<div class='errormessage'>*username not found,<span class='over'>attempts over</span> may be you are a new User<br>If you are a New User please Signup or else retry After some time?</div>");
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("Signup.jsp");
			requestDispatcher.include(req, resp);
		}

		// cookies
//		Cookie cookie1 = new Cookie("userName", userName);
//		Cookie cookie2 = new Cookie("password", password);
//		
//		resp.addCookie(cookie1);
//		resp.addCookie(cookie2);

	}

	// to encrypt data
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
