package com.GrimoireGuide;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ShowRegistrationFormServlet extends HttpServlet{
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException 
	{
		String listPage = "registration_form.jsp";
		RequestDispatcher rd = req.getRequestDispatcher(listPage);
		rd.forward(req, res);
	}
}
