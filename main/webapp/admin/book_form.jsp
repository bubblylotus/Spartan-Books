<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.GrimoireGuide.entity.Book"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Add New Book</h2>
	<div>
	<%Book book = (Book)request.getAttribute("book"); %>
	<div>
		<% if(book != null) {%>
		<h1>Edit Book</h1>
	</div>
	<form action = "edit_book" method = "post">
		<input type = "hidden" name = "bookId" value = <%= book.getBookId() %>>
		<table>
			<tr>
				<td>Title: </td>
				<td><input type = "text" name = "title" value = "<%= book.getTitle() %>" size = 80/></td>
			</tr>
			<tr>
				<td>Author: </td>
				<td><input type = "text" name = "author" value = "<%= book.getAuthor() %>" size = 80/></td>
			</tr>
			<tr>
				<td>Description: </td>
				<td><input type = "text" name = "desc" value = "<%= book.getDescription() %>" size = 80/></td>
			</tr>
			<tr>
				<td><input type = "submit" value = "Save"/></td>
			</tr>
		</table>
		</form>
		<%}else{%>
	<form action = "create_book" method = "post">
		<table>
			<tr>
				<td>Title: </td>
				<td><input type = "text" name = "title" size = 80/></td>
			</tr>
			<tr>
				<td>Author: </td>
				<td><input type = "text" name = "author" size = 80/></td>
			</tr>
			<tr>
				<td>Description: </td>
				<td><input type = "text" name = "desc" size = 80/></td>
			</tr>
			<tr>
				<td><input type = "submit" value = "Save"/></td>
			</tr>
		</table>
		</form>
		<%}%>
	</div>
</body>
</html>