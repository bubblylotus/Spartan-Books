<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div>
		<h1>Sign In</h1>
		<h4><% request.getAttribute("message"); %></h4>
		<form action="login" method="post">
			<p>Email</p>
			<input type="text" name="email">
			<p>Password</p>
			<input type="password" name="password">
			<button type="submit">Sign In</button>
		</form>
	</div>
</body>
</html>