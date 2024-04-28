package com.tapfoods.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tapfoods.daoimpl.UserDaoImpl;
import com.tapfoods.model.User;

@WebServlet("/reset")
public class ResetPasswordServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		HttpSession session = req.getSession();
		String userName = req.getParameter("username");
		long phoneNo = Long.parseLong(req.getParameter("phoneno"));
		String password = req.getParameter("password");
		String Cpassword = req.getParameter("cpassword");

		String encryptedUserName = callEncryption(userName);

		UserDaoImpl userDaoimpl = new UserDaoImpl();

		User user = userDaoimpl.getLoginDetails(encryptedUserName);

		if (user != null) {

			long phoneNo2 = user.getPhoneNo();
			if (phoneNo == phoneNo2) {
				if (password.equals(Cpassword)) {
					String encryptedPassword = callEncryption(Cpassword);
					userDaoimpl.updatePassword(encryptedUserName, encryptedPassword);
					out.println("<div  class='successmes1'>&nbsp;&#9989;Your password has been successfully reseted &nbsp;</div>");
					RequestDispatcher requestDispatcher = req.getRequestDispatcher("Login.jsp");
					requestDispatcher.include(req, resp);
				} else {
					session.setAttribute("errormessage", " *Password and ConfirmPassword are not matching");
					RequestDispatcher requestDispatcher = req.getRequestDispatcher("ResetPassword.jsp");
					requestDispatcher.forward(req, resp);
				}

			} else {
				session.setAttribute("errormessage", " *Please provide the accurate phone number that is <br> listed in the database ");
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("ResetPassword.jsp");
				requestDispatcher.forward(req, resp);
			}

		} else {
			session.setAttribute("errormessage", " *username is not found");
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("ResetPassword.jsp");
			requestDispatcher.forward(req, resp);
		}

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
}
