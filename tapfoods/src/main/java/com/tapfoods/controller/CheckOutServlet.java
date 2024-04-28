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

import com.tapfoods.model.User;

@WebServlet("/checkout")
public class CheckOutServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");

		if (user != null) {

			RequestDispatcher requestDispatcher = req.getRequestDispatcher("CheckOut.jsp");
			requestDispatcher.forward(req, resp);
		} else {
			PrintWriter out = resp.getWriter();
			out.print("<div class='pleaselogin'>&nbsp;Please Login To Proceed&nbsp;</div>");
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("CheckOutLogin.jsp");
			requestDispatcher.include(req, resp);

		}
	}

}
