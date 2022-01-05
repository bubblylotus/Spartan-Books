package com.GrimoireGuide;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class UserLogoutServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException 
	{
		HttpSession session = req.getSession();
		session.removeAttribute("loggedUser");
		
		RequestDispatcher rd = req.getRequestDispatcher("login_form.jsp");
		rd.forward(req, res);
	}
}
