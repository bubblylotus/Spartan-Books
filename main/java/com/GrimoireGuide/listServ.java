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

public class listServ extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException 
	{
//		BookServices bookServices = new BookServices();
//		List<Book> listBook = bookServices.listBook();
//		req.setAttribute("listBook", listBook);
//		String listPage = "book_list.jsp";
//		RequestDispatcher rd = req.getRequestDispatcher(listPage);
//		rd.forward(req, res);
//		
//		String name = "kidest";
//		req.setAttribute("label", name);
//		RequestDispatcher rd = req.getRequestDispatcher("book_list.jsp");
//		rd.forward(req, res);
	}
}
