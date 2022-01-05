package com.GrimoireGuide;

import java.io.IOException;

import com.GimoireGuide.service.AdminServices;
import com.GimoireGuide.service.UserServices;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AdminLoginServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException 
	{
//		String listPage = "login_form.jsp";
//		RequestDispatcher rd = req.getRequestDispatcher(listPage);
//		rd.forward(req, res);
		AdminServices adminServices = new AdminServices(req, res);
		adminServices.loginAdmin();
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException 
	{
		AdminServices adminServices = new AdminServices(req, res);
		adminServices.loginAdmin();              
	}
}
