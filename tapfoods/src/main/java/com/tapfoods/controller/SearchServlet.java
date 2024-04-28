package com.tapfoods.controller;

import java.io.IOException;
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
@WebServlet("/serchservlet")
public class SearchServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String searchinput = req.getParameter("search");
		
		RestaurantDaoImpl restaurantDaoImpl = new RestaurantDaoImpl();
		List<Restaurant> allRestaurantsBySearch = restaurantDaoImpl.getAllRestaurantsBySearch(searchinput);
		
		HttpSession session = req.getSession();
		session.setAttribute("restaurants", allRestaurantsBySearch);
		
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("Index.jsp");
		requestDispatcher.forward(req, resp);
		
	}

}
