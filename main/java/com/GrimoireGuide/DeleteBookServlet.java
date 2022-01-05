package com.GrimoireGuide;

import java.io.IOException;

import com.GimoireGuide.service.BookServices;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteBookServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException 
	{
		BookServices bookServices = new BookServices(req, res);
		bookServices.deleteBook();

	}
}
