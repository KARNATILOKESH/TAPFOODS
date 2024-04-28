package com.tapfoods.controller;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tapfoods.daoimpl.RestaurantDaoImpl;
import com.tapfoods.model.Restaurant;
import com.tapfoods.model.User;

@WebServlet("/Restaurantservlet")
public class RestaurantServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		RestaurantDaoImpl restaurantDaoImpl = new RestaurantDaoImpl();

		// getting all restaurant details
		List<Restaurant> allRestaurants = restaurantDaoImpl.getAllRestaurants();

		// storing or setting into request object (" it is useful to get details in
		// restaurant jsp file")
		session.setAttribute("restaurants", allRestaurants);

		// getting userdetails from loginservlet and storing in session object again

		User user = (User) session.getAttribute("user");

		session.setAttribute("user", user);

		// redirecting to resturant jsp file
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("Restaurant.jsp");
		requestDispatcher.include(req, resp);

	}
}
