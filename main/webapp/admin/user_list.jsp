<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.GrimoireGuide.entity.User" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:directive.include file="header.jsp"/>
<div align = "center">
	<h1>User Management</h1>
	<a href = "create_user">Create User</a>
</div>
<div align = "center">
	<table>
		<th>ID</th>
		<th>Name</th>
		<th>Email</th>
		<th>Actions</th>
		<%
		List<User> users = (List<User>)request.getAttribute("listUsers");
		for(User user:users){%>
		<tr>
			<td><%= user.getUserId() %></td>
			<td><%=user.getName()%></td>
			<td><%= user.getEmail() %></td>
			<td><a href = "edit_user?id=<%=user.getUserId() %>">Edit</a>/
			<a href = "delete_user?id=<%=user.getUserId() %>">Delete</a></td>
		</tr>
		
		<%}%>
	</table>
</div>
</body>
</html>