package com.GrimoireGuide;

import java.io.IOException;

import com.GimoireGuide.service.BookServices;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ListBookServlet extends HttpServlet{
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException 
	{
		BookServices bookServices = new BookServices(req, res);
		bookServices.listBook();
//		res.getWriter().println("book list loading");
		
//		String name = "kidest";
//		req.setAttribute("label", name);
//		RequestDispatcher rd = req.getRequestDispatcher("user_list.jsp");
//		rd.forward(req, res);
	}
}
