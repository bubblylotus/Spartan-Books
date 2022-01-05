<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ page import="com.GrimoireGuide.entity.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="style.css">
<title>Insert title here</title>
</head>
<body>
	<div class = "header">
		<div class = "topnav">
		<!-- <div class="logo">
		<a href = "#">GRIMOIRE GUIDE</a>
		<div> -->
		<form action="search" method="get">
			<input type="text" name="keyword" placeholder="Search.."> <input
				type="submit" value="Search" />
		</form>
<!-- 		<a href="list">Books</a> -->
	<%User user = new User();
	user = (User)request.getSession().getAttribute("loggedUser");%>
	<% if(user == null){%>
		<div class="right-most">
		<a href = "index.jsp">Home</a>
		<a href="register">Register</a>
	    <a href="login">Login</a>
	    </div>
	<%}%>
	<% if(user != null){%>
		<div class = "right-most">
		<a href = "index.jsp">Home</a>
		<a href="register">wishlist</a>
	    <a href="index.jsp"><%=user.getName()%></a>
	    <a href = "logout"> Logout </a>
	    </div>
	<%}%>
	</div>
	</div>
</body>
</html>