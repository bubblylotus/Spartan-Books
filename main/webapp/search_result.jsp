<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="com.GrimoireGuide.entity.Book" %>
<%@ page import="com.GrimoireGuide.entity.Source" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <link rel="stylesheet" href="style.css">

<title>Insert title here</title>
</head>
<body>
<jsp:directive.include file = "header.jsp"/>

	<div class = "container">
	
		<% List<Book> listBook = (List<Book>)request.getAttribute("result");
		if(listBook.size() < 1){%>
				<h3>no result found</h3>
			<%}else{%>
	<% for(Book book : listBook){ %>
		<div class = "card">
			<div class = "imageBox">
				<a href = "book_details?id=<%= book.getBookId() %>">
				<%if(book.getImg_link()!=null) {%>
				<img alt="" src="<%=book.getImg_link() %>">
				</a>
				<%}else{ %>	
					<%if(book.getBase64Image() != null){ %>
				<a href = "book_details?id=<%= book.getBookId() %>">
				<img alt="" src="data:image/jpg;base64, <%= book.getBase64Image() %>">	
				</a>
					<%}else{ %>
				<img alt="" src="C:\Users\GFRD\Documents\340 project\book images\placeholder-.png">
				<%}} %>
			</div>
			<div class = "content">
				<div class = "bookName">
					<h3><%= book.getTitle() %></h3>
				</div>

			</div>
		</div>
		<%}}%>
	</div>
</body>
</html>