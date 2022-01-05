package com.GrimoireGuide;

import java.io.IOException;

import com.GimoireGuide.service.BookServices;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CreateBookServlet extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException 
	{
		BookServices bookServices = new BookServices(req, res);
		bookServices.CreateBook();

	}
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException 
	{
		BookServices bookServices = new BookServices(req, res);
		RequestDispatcher rd = req.getRequestDispatcher("book_form.jsp");
		rd.forward(req, res);
	}
}
