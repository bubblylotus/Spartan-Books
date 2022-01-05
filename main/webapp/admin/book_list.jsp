<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

	<%@ page import="java.util.List"%>
	<%@ page import="com.GrimoireGuide.entity.Book"%>
	<%@ page import="com.GrimoireGuide.entity.Source"%>

	<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book List</title>
</head>
<body>
	<div>
		<h2>Books</h2>
		<h3>
			<a href="book_form.jsp"> Add a New Book</a>
		</h3>
	</div>
	<div>
		<table>
			<tr>
				<th>Id</td>
				<th>Title</td>
				<th>Author</td>
				<th>Description</td>
				<th>Actions</th>
			</tr>
			<%
			List<Book> books = (List<Book>)request.getAttribute("bookList");
			for(Book book:books){%>
				<tr>
				<td>
					<%= book.getBookId() %>
				</td>
				<td>
					<%= book.getTitle() %>
				</td>
				<td>
					<%= book.getAuthor() %>
				</td>
				<td>
					<%= book.getDescription() %>
				</td>
				<td><a href = "edit_book?id=<%=book.getBookId() %>">Edit</a>/
			<a href = "delete_book?id=<%=book.getBookId() %>">Delete</a></td>
				</tr>
			<%}%>
		</table>
	</div>



</body>
</html>

</body>
</html>