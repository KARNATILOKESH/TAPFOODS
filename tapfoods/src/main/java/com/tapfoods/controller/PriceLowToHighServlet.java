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

import com.tapfoods.daoimpl.MenuDaoImpl;
import com.tapfoods.daoimpl.RestaurantDaoImpl;
import com.tapfoods.model.Menu;
import com.tapfoods.model.Restaurant;

@WebServlet("/pricelowtohigh")
public class PriceLowToHighServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		int restaurantId = (int) session.getAttribute("restaurantId");

		MenuDaoImpl menuDaoImpl = new MenuDaoImpl();
		List<Menu> allBySearch = menuDaoImpl.getPriceLowToHigh(restaurantId);
		session.setAttribute("menu", allBySearch);

		RestaurantDaoImpl restaurantDaoImpl = new RestaurantDaoImpl();
		List<Restaurant> allRestaurants = restaurantDaoImpl.getAllRestaurants();
		session.setAttribute("restaurants", allRestaurants);

		if(req.getParameter("userId")!=null)
    	{
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("Menu.jsp");
		requestDispatcher.forward(req, resp);
     	}
        else
		{
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("IndexMenu.jsp");
			requestDispatcher.forward(req, resp);
		}

	}

}
