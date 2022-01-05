package com.GrimoireGuide.controller;

import java.io.IOException;

import javax.servlet.http.HttpServlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ListBookServlet extends HttpServlet{
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException 
	{
		String listPage = "book_list.jsp";
		RequestDispatcher rd = req.getRequestDispatcher(listPage);
		rd.forward(req, res);
		System.out.println("hello");
	}
}
