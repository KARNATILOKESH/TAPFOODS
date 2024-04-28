package com.tapfoods.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tapfoods.model.CartItem;
import com.tapfoods.model.CartMap;

@WebServlet("/remove")
public class RemoveServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");

		int itemId = Integer.parseInt(req.getParameter("itemId"));

		CartMap.removeCartItem(itemId);

		Map<Integer, CartItem> allItems = CartMap.getAllItems();

		req.setAttribute("cartList", allItems);
		
		
		if(req.getParameter("userId")!=null)
		{
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("Cart.jsp");
		requestDispatcher.forward(req, resp);
		}
		else
		{
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("IndexCart.jsp");
			requestDispatcher.forward(req, resp);
			
		}

	}

}
