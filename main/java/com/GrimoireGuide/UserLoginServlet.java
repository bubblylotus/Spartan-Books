package com.GrimoireGuide;

import java.io.IOException;

import com.GimoireGuide.service.UserServices;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UserLoginServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException 
	{
		String listPage = "login_form.jsp";
		RequestDispatcher rd = req.getRequestDispatcher(listPage);
		rd.forward(req, res);
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException 
	{
		UserServices userServices = new UserServices(req, res);
		userServices.loginUser();
	}
}
