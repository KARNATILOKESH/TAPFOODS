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
import com.tapfoods.model.CartItem;
import com.tapfoods.model.CartMap;
import com.tapfoods.model.Menu;

@WebServlet("/addincheckout")
public class AddQuantityCheckOutServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");

		int itemId = Integer.parseInt(req.getParameter("itemId"));
		
		int restaurantid = Integer.parseInt(req.getParameter("restaurantId"));
		int quantity = Integer.parseInt(req.getParameter("quantity"));
		
		
		
		MenuDaoImpl menuDaoImpl = new MenuDaoImpl();
		Menu menu = menuDaoImpl.getMenu(itemId);
		String itemName = menu.getName();
		Double price = menu.getPrice();
		String imagePath = menu.getImagePath();

		CartItem cartItem = new CartItem(itemId, itemName, price, restaurantid, quantity,imagePath);
		HttpSession session = req.getSession();
		CartMap cartMap = (CartMap) session.getAttribute("cart");
		if (cartMap == null) {
			cartMap = new CartMap();
			session.setAttribute("cart", cartMap);
		}
		cartMap.addQuantity(cartItem);

		Map<Integer, CartItem> allItems = cartMap.getAllItems();

		req.setAttribute("cartList", allItems);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("CheckOut.jsp");
		requestDispatcher.forward(req, resp);

	}

}