package com.tapfoods.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tapfoods.daoimpl.OrderDaoImpl;
import com.tapfoods.daoimpl.OrderItemDaoImpl;
import com.tapfoods.daoimpl.UserDaoImpl;
import com.tapfoods.model.CartItem;
import com.tapfoods.model.CartMap;
import com.tapfoods.model.Order;
import com.tapfoods.model.OrderItem;
import com.tapfoods.model.User;

@WebServlet("/paymentservlet")
public class OrderConfirm extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();

		Date date = new Date();

		SimpleDateFormat monthFormat = new SimpleDateFormat("MMMM");
		SimpleDateFormat dateYearFormat = new SimpleDateFormat("ddyy");
		SimpleDateFormat timeFormat = new SimpleDateFormat("HHmmssSSS");

		String month = monthFormat.format(date);
		String dateYear = dateYearFormat.format(date);
		String time = timeFormat.format(date);

		String orderId = month.charAt(0) + dateYear + time;

		CartItem cartitem = (CartItem) session.getAttribute("cartitem");
		int restaurantId = cartitem.getRestaurantId();

		User user = (User) session.getAttribute("user");
		int userId = user.getUserId();

		double totalAmount = (double) session.getAttribute("totalAmount");

		String paymentmode = req.getParameter("paymentmode");

		String status = "confirmed";

		Order order = new Order(orderId, restaurantId, userId, totalAmount, paymentmode, status, null);

		OrderDaoImpl orderDaoImpl = new OrderDaoImpl();

		orderDaoImpl.addOrder(order);

//		int userId = user.getUserId();
		double totalAmoun = 0.0;
		Map<Integer, CartItem> cartList = (Map<Integer, CartItem>) session.getAttribute("cartList");
		if (cartList != null) {
			Set<Integer> keySet = cartList.keySet();
			for (Integer key : keySet) {

				CartItem cart = cartList.get(key);
				int restaurantId2 = cart.getRestaurantId();
				int menuId = cart.getItemId();
				String itemName = cart.getItemName();
				int quantity = cart.getQuantity();
				double price = cart.getPrice();
				String imagePath = cart.getImagePath();

				totalAmount = (quantity * price);
				OrderItem orderItem = new OrderItem(0, userId, restaurantId2, menuId, itemName, 0.0, quantity, price,
						totalAmount,imagePath);

				OrderItemDaoImpl orderItemDaoImpl = new OrderItemDaoImpl();
				orderItemDaoImpl.addOrderItem(orderItem);
			}
		}

		String address = req.getParameter("address");

		CartMap cartMap = (CartMap) session.getAttribute("cart");
		if (cartMap == null) {
			cartMap = new CartMap();
			session.setAttribute("cart", cartMap);
		}
		cartMap.clear();

		UserDaoImpl userDaoImpl = new UserDaoImpl();
		userDaoImpl.updateAddress(userId, address);

		RequestDispatcher requestDispatcher = req.getRequestDispatcher("OrderConfirm.jsp");
		requestDispatcher.forward(req, resp);

	}

}
