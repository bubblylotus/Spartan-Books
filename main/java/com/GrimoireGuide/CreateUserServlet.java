package com.GrimoireGuide;

import java.io.IOException;

import com.GimoireGuide.service.UserServices;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CreateUserServlet extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException 
	{
		UserServices userServices = new UserServices(req, res);
		userServices.CreateUser();
		
//		String name = "kidest";
//		req.setAttribute("label", name);
//		RequestDispatcher rd = req.getRequestDispatcher("user_list.jsp");
//		rd.forward(req, res);
	}
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException 
	{
		UserServices userServices = new UserServices(req, res);
		RequestDispatcher rd = req.getRequestDispatcher("user_form.jsp");
		rd.forward(req, res);
	}

}
