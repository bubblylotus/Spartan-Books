package com.GrimoireGuide;

import java.io.IOException;
import java.util.List;

import com.GimoireGuide.service.BookServices;
import com.GrimoireGuide.entity.Book;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

public class SearchBookServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws IOException, ServletException{
//		String keyword = req.getParameter("keyword");
		BookServices bookServices = new BookServices(req, res);
//		List<Book> result = bookServices.search(keyword);
//		req.setAttribute("result", result);
//		String listPage = "search_result.jsp";
//		RequestDispatcher rd = req.getRequestDispatcher(listPage);
//		rd.forward(req, res);
		bookServices.search();
		
	}
}
