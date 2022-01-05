package com.GrimoireGuide;

import java.io.IOException;
import java.util.List;

import com.GimoireGuide.service.BookServices;
import com.GrimoireGuide.entity.Book;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AddBookServlet extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws IOException, ServletException{	
//		String title = req.getParameter("title");
//		String author = req.getParameter("author");
//		String desc = req.getParameter("desc");
//		
//		BookServices bookServices = new BookServices();
//		bookServices.addBook(title, author, desc);
	}
}
