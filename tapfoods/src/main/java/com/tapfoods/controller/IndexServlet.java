package com.tapfoods.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tapfoods.daoimpl.RestaurantDaoImpl;
import com.tapfoods.model.Restaurant;

@WebServlet("")
public class IndexServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RestaurantDaoImpl restaurantDaoImpl = new RestaurantDaoImpl();

		// getting all restaurant details
		List<Restaurant> allRestaurants = restaurantDaoImpl.getAllRestaurants();

		// storing or setting into request object (" it is useful to get details in
		// restaurant jsp file")
		HttpSession session = req.getSession();
		session.setAttribute("restaurants", allRestaurants);

		// redirecting to resturant jsp file
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("Index.jsp");
		requestDispatcher.forward(req, resp);

	}

}
