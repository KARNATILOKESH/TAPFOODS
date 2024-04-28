package com.tapfoods.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tapfoods.daoimpl.MenuDaoImpl;
import com.tapfoods.daoimpl.RestaurantDaoImpl;
import com.tapfoods.model.CartItem;
import com.tapfoods.model.CartMap;
import com.tapfoods.model.Menu;
import com.tapfoods.model.Restaurant;
@WebServlet("/callindexcart")
public class IndexCartServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		int itemId = Integer.parseInt(req.getParameter("itemId"));
		
		
		MenuDaoImpl menuDaoImpl = new MenuDaoImpl();
		Menu menu = menuDaoImpl.getMenu(itemId);
		String itemName = menu.getName();
		Double price = menu.getPrice();
		String imagePath = menu.getImagePath();
		int restaurantid = Integer.parseInt(req.getParameter("restaurantid"));
		int quantity = 1;
		HttpSession session = req.getSession();

		CartItem cartitem = new CartItem(itemId, itemName, price, restaurantid, quantity,imagePath);
		session.setAttribute("cartitem", cartitem);

		CartMap cartMap = (CartMap) session.getAttribute("cart");
		if (cartMap == null) {
			cartMap = new CartMap();
			session.setAttribute("cart", cartMap);
		}
		cartMap.addCartItem(cartitem, restaurantid);

		Map<Integer, CartItem> allItems = cartMap.getAllItems();

		session.setAttribute("cartList", allItems);

		RestaurantDaoImpl restaurantDaoImpl = new RestaurantDaoImpl();
		Restaurant restaurant = restaurantDaoImpl.getRestaurant(restaurantid);
		session.setAttribute("restaurant", restaurant);

		RequestDispatcher requestDispatcher = req.getRequestDispatcher("IndexCart.jsp");
		requestDispatcher.forward(req, resp);

	}

}
