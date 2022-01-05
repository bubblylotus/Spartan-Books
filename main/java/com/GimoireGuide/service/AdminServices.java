package com.GimoireGuide.service;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.GrimoireGuide.dao.AdminDAO;
import com.GrimoireGuide.entity.Admin;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AdminServices {
	private EntityManagerFactory emf;
	private EntityManager em;
	private AdminDAO adminDAO;
	private HttpServletRequest req;
	private HttpServletResponse res;

	public AdminServices(HttpServletRequest req, HttpServletResponse res) {
		super();
		this.req = req;
		this.res = res;
		emf = Persistence.createEntityManagerFactory("GrimoireGuide");
		em = emf.createEntityManager();
		adminDAO = new AdminDAO(em);
	}
	public void loginAdmin() throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		Admin existingAdmin = adminDAO.checkLogin(email, password);
		String message  = "";
		if(existingAdmin == null) {
			message = "Login unsuccessful. Please recheck email and password.";
			System.out.println(message);
			req.setAttribute("message", message);
			String login = "login_form.jsp";
			RequestDispatcher rd = req.getRequestDispatcher(login); 
			rd.forward(req, res);
		}
		else {
			req.getSession().setAttribute("loggedAdmin", existingAdmin);
			String homePage = "/admin/";
			RequestDispatcher rd = req.getRequestDispatcher(homePage); 
			rd.forward(req, res);
		}
		
	}
	
}
