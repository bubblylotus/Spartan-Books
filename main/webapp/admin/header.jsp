<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.GrimoireGuide.entity.Admin" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align = "center">
	<h2>GRIMOIRE GUIDE</h2>
	<%
	Admin admin = new Admin();
	admin = (Admin)request.getSession().getAttribute("loggedAdmin");
	if(admin != null){%>
		<h2>Hello <%= admin.getName() %></h2>
		<div>
		<a href="users">Users</a> | 
		<a href="subjects">Subjects</a> | 
		<a href="books">Books</a> | 
		<a href="courses">Courses</a>
		<a href="logout">Logout</a>
	</div>
	<%}else{%>
		<div>
		<a href="login_form.jsp">login</a>
		
	</div>
	<%} %>
</div>

</body>
</html>