package com.tapfoods.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tapfoods.daoimpl.MenuDaoImpl;
import com.tapfoods.daoimpl.OrderItemDaoImpl;
import com.tapfoods.daoimpl.RestaurantDaoImpl;
import com.tapfoods.daoimpl.UserDaoImpl;
import com.tapfoods.model.CartItem;
import com.tapfoods.model.CartMap;
import com.tapfoods.model.Menu;
import com.tapfoods.model.OrderItem;
import com.tapfoods.model.Restaurant;
import com.tapfoods.model.User;

@WebServlet("/udateuserdetails")
public class UpdateUserDetails extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		HttpSession session = req.getSession();
		// to convert text to html without this .html file print in text format
		resp.setContentType("text/html");

		// getting data from Signup page (request parameter store data in the form of
		// string so convert into long)
		String name = req.getParameter("name");
		String userName = req.getParameter("userName");
		String email = req.getParameter("email");
		long phoneNo = Long.parseLong(req.getParameter("phoneNo"));
		String address = req.getParameter("address");

		// to encrypt the username and password
		String encryptedUserName = callEncryption(userName);
		

		UserDaoImpl userDaoImpl = new UserDaoImpl();

		// checking if the User is already present or not
		User user1 = userDaoImpl.getLoginDetails(encryptedUserName);

		callEncryption(userName);
		// if username is not present in database then we add
		if (user1 != null) {

			User user2 = new User(user1.getUserId(), name, email, phoneNo, address, encryptedUserName, user1.getPassword(), null, null,
					null);

			// inserting data into database
			userDaoImpl.updateUser(user2);

			
			User user = userDaoImpl.getLoginDetails(encryptedUserName);
			session.setAttribute("user", user);
			// redirecting to login page
			String isthismenu = (String)session.getAttribute("isthismenu");
			
			String isthiscart = (String)session.getAttribute("isthiscart");
			
			String isthischeckout = (String)session.getAttribute("isthischeckout");
			
			String isthisconfirm = (String)session.getAttribute("isthisconfirm");
			
			String isthishistory = (String)session.getAttribute("isthishistory");
			
			String isthisviewcart = (String)session.getAttribute("isthisviewcart");
			
			if(isthismenu !=null && isthismenu.equalsIgnoreCase("menu"))
			{
				int restaurantId = (int) session.getAttribute("restaurantId"); 
				MenuDaoImpl menuDaoImpl = new MenuDaoImpl();
				List<Menu> allMenus = menuDaoImpl.getByRestaurantId(restaurantId);
				session.setAttribute("menu", allMenus);
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("Menu.jsp");
				requestDispatcher.forward(req, resp);
			}
			else if(isthiscart !=null &&isthiscart.equalsIgnoreCase("cart"))
			{
				int restaurantId = (int) session.getAttribute("restaurantId"); 
				CartMap cartMap = (CartMap) session.getAttribute("cart");
				if (cartMap == null) {
					cartMap = new CartMap();
					session.setAttribute("cart", cartMap);
				}
              
				Map<Integer, CartItem> allItems = cartMap.getAllItems();

				session.setAttribute("cartList", allItems);

				RestaurantDaoImpl restaurantDaoImpl = new RestaurantDaoImpl();
				Restaurant restaurant = restaurantDaoImpl.getRestaurant(restaurantId);
				session.setAttribute("restaurant", restaurant);
				
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("Cart.jsp");
				requestDispatcher.forward(req, resp);

			}
			else if(isthischeckout !=null && isthischeckout.equalsIgnoreCase("checkout"))
			{
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("CheckOut.jsp");
				requestDispatcher.forward(req, resp);
				
			}
			else if(isthisconfirm != null && isthisconfirm.equalsIgnoreCase("confirm"))
			{
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("OrderConfirm.jsp");
				requestDispatcher.forward(req, resp);
				
			}
			else if(isthishistory !=null && isthishistory.equalsIgnoreCase("history"))
			{
				
				
				int userId = user.getUserId();
				OrderItemDaoImpl orderItemDaoImpl = new OrderItemDaoImpl();

				List<OrderItem> allOrderItems = orderItemDaoImpl.getAllOrderItemsByUserId(userId);

				session.setAttribute("allOrderItems", allOrderItems);

				RequestDispatcher requestDispatcher = req.getRequestDispatcher("OrderHistory.jsp");
				requestDispatcher.forward(req, resp);
			}
			else if(isthisviewcart !=null && isthisviewcart.equalsIgnoreCase("viewcart"))
			{
				CartMap cartMap = (CartMap) session.getAttribute("cart");
				if (cartMap == null) {
					cartMap = new CartMap();
					session.setAttribute("cart", cartMap);
				}
              
				Map<Integer, CartItem> allItems = cartMap.getAllItems();

				session.setAttribute("cartList", allItems);

				RestaurantDaoImpl restaurantDaoImpl = new RestaurantDaoImpl();
				
				
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("ViewCart.jsp");
				requestDispatcher.forward(req, resp);
				
			}
			else
			{
				RestaurantDaoImpl restaurantDaoImpl = new RestaurantDaoImpl();
				List<Restaurant> allRestaurants = restaurantDaoImpl.getAllRestaurants();
				session.setAttribute("restaurants", allRestaurants);
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("Restaurant.jsp");
				requestDispatcher.forward(req, resp);
				
			}

		}
		// if user is alredy there then printing message as Username is already taken
		// try differen
		else {


			RequestDispatcher requestDispatcher = req.getRequestDispatcher("EditUserDetails.jsp");
			requestDispatcher.include(req, resp);
		}

	}

	private static String callEncryption(String text) {
		String encriptedValue = "";

		for (int i = 0; i < text.length(); i++) {
			char charvalue = text.charAt(i);

			int asciiValue = charvalue;

			int encryptingVaLue = asciiValue - 12878;

			char encrname = (char) encryptingVaLue;

			encriptedValue = encriptedValue + encrname;

		}
		return encriptedValue;

	}
  
	

}
