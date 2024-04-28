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
import com.tapfoods.model.Menu;

@WebServlet("/serchmenuitemsservlet")
public class SearchMenuItemServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String searchinput = req.getParameter("search");
		int restaurantId = (int) session.getAttribute("restaurantId");

		MenuDaoImpl menuDaoImpl = new MenuDaoImpl();
		List<Menu> allBySearch = menuDaoImpl.getAllBySearch(searchinput, restaurantId);

		session.setAttribute("menu", allBySearch);

		RequestDispatcher requestDispatcher = req.getRequestDispatcher("Menu.jsp");
		requestDispatcher.forward(req, resp);

	}

}
