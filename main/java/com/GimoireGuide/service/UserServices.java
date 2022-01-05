package com.GimoireGuide.service;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.GrimoireGuide.dao.UserDAO;
import com.GrimoireGuide.entity.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UserServices {
	private EntityManagerFactory emf;
	private EntityManager em;
	private UserDAO userDAO;
	private HttpServletRequest req;
	private HttpServletResponse res;
	
//	private UserDAO userDAO;
//	private HttpServletRequest req;
//	private HttpServletResponse response;
//	public UserServices(HttpServletRequest req, HttpServletResponse response) {
//		super();
//		this.req = req;
//		this.response = response;
//		this.userDAO = new UserDAO();
//	}
	
	public UserServices(HttpServletRequest req, HttpServletResponse res) {
		super();
		this.req = req;
		this.res = res;
		emf = Persistence.createEntityManagerFactory("GrimoireGuide");
		em = emf.createEntityManager();
		userDAO = new UserDAO(em);
	}
	
	
	public void listUsers() throws IOException, ServletException{
		List<User> listUser = userDAO.listAll();
		req.setAttribute("listUsers", listUser);
		String listPage = "user_list.jsp";
		RequestDispatcher rd = req.getRequestDispatcher(listPage);
		rd.forward(req, res);
	}
	public void RegisterUser() throws IOException {
		String email = req.getParameter("email");
		User existingUser = userDAO.findByEmail(email);
		String message  = "";
		if(existingUser != null) {
			message = "Could not register account. Email " + email + " is already associated with an existing account.";
		}
		else {
			String name = req.getParameter("name");
			String password = req.getParameter("password");


			User user = new User();
			user.setEmail(email);
			user.setName(name);
			user.setPassword(password);
			userDAO.create(user);
			
			message = "Account registered successfully.";
		}
		res.getWriter().println(message);
	}
	public void CreateUser() throws IOException {
		String email = req.getParameter("email");
		User existingUser = userDAO.findByEmail(email);
		String message  = "";
		if(existingUser != null) {
			message = "Could not create account. Email " + email + " is already associated with an existing account.";
		}
		else {
			String name = req.getParameter("name");
			String password = req.getParameter("password");


			User user = new User();
			user.setEmail(email);
			user.setName(name);
			user.setPassword(password);
			userDAO.create(user);
			
			message = "New user account created successfully.";
		}
		res.getWriter().println(message);
	}


	public void loginUser() throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		User existingUser = userDAO.checkLogin(email, password);
		String message  = "";
		if(existingUser == null) {
			message = "Login unsuccessful. Please recheck email and password.";
			res.getWriter().println(message);
		}
		else {
			req.getSession().setAttribute("loggedUser", existingUser);
			String profilePage = "user_profile.jsp";
			RequestDispatcher rd = req.getRequestDispatcher(profilePage); 
			rd.forward(req, res);
		}
		
	}
	public void editUser() throws ServletException, IOException {
		int userId = Integer.parseInt(req.getParameter("id"));
		User user = userDAO.get(userId);
		String editPage = "user_form.jsp";
		req.setAttribute("user", user);
		RequestDispatcher rd = req.getRequestDispatcher(editPage); 
		rd.forward(req, res);
		
	}
	public void updateUser() {
		String message = "";
		int userId = Integer.parseInt(req.getParameter("userId"));
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		User fromId = userDAO.get(userId);
		User fromEmail = userDAO.findByEmail(email);
		//check they don't update email to another existing email
		if(fromEmail != null && fromEmail.getUserId() != fromId.getUserId()) {
			message = "Could not update user. Email already is already taken. ";
			System.out.println(message);
		}
		else {
			User user = new User();
			user.setUserId(userId);
			user.setEmail(email);
			user.setName(name);
			user.setPassword(password);

			userDAO.update(user);

			message = "User updated.";

			System.out.println(message);
		}
	}


	public void deleteUser() {
		int userId = Integer.parseInt(req.getParameter("id"));
		userDAO.delete(userId);
		String message = "User deleted.";
		System.out.println(message);
	}
	

}
