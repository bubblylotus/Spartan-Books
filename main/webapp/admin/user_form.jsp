<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.GrimoireGuide.entity.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:directive.include file="header.jsp" />

	<div align="center">
		<%
		User user = (User) request.getAttribute("user");
		%>
		<div>
			<%
			if (user != null) {
			%>
			<h1>Edit User</h1>
		</div>
		<form action="edit_user" method="post">
			<input type = "hidden" name = "userId" value = <%= user.getUserId() %>>
			<p>Name</p>
			<input type="text" name="name" value="<%=user.getName()%>">
			<p>Email</p>
			<input type="text" name="email" value="<%=user.getEmail()%>">
			<p>Password</p>
			<input type="password" name="password"
				value="<%=user.getPassword()%>">
			<button type="submit">Save</button>
			<button type="cancel">Cancel</button>
		</form>
		<%}else{%>
			<h1>Create New User</h1>
		</div>
		<form action="create_user" method="post">
			<p>Name</p>
			<input type="text" name="name" value = "">
			<p>Email</p>
			<input type="text" name="email" value = "">
			<p>Password</p>
			<input type="password" name="password" value = "">
			<button type="submit">Save</button>
			<button type="cancel">Cancel</button>
		</form>
				
			<%} %>

	</div>

</body>
</html>