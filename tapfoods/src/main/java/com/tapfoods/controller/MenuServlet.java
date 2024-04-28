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

@WebServlet("/callmenu")
public class MenuServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		// getting restaurant details from restaurant.jsp
		int restuarantId = Integer.parseInt(req.getParameter("restaurantId")); 
		
		
		
		
		HttpSession session = req.getSession();
		
		RestaurantDaoImpl restaurantDaoImpl = new RestaurantDaoImpl();
		Restaurant restaurant = restaurantDaoImpl.getRestaurant(restuarantId);
		
		session.setAttribute("restaurant", restaurant);
		
		
		

		MenuDaoImpl menuDaoImpl = new MenuDaoImpl();
		List<Menu> allMenus = menuDaoImpl.getByRestaurantId(restuarantId);
		session.setAttribute("menu", allMenus);

		//redirecting to menu.jsp
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("Menu.jsp");
		requestDispatcher.forward(req, resp);
	}

}
