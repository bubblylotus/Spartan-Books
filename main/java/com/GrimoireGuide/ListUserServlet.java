package com.GrimoireGuide;

import java.io.IOException;
import java.util.List;

import com.GimoireGuide.service.UserServices;
import com.GrimoireGuide.entity.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ListUserServlet extends HttpServlet{
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException 
	{
		UserServices userServices = new UserServices(req, res);
		userServices.listUsers();
		
//		String name = "kidest";
//		req.setAttribute("label", name);
//		RequestDispatcher rd = req.getRequestDispatcher("user_list.jsp");
//		rd.forward(req, res);
	}
}
