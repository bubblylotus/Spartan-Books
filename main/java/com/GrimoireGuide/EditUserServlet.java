package com.GrimoireGuide;

import java.io.IOException;

import com.GimoireGuide.service.UserServices;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EditUserServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException 
	{
		UserServices userServices = new UserServices(req, res);
		userServices.editUser();

	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException 
	{
		UserServices userServices = new UserServices(req, res);
		userServices.updateUser();

	}

}
