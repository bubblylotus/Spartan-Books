<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.GrimoireGuide.entity.Book"%>
<%@ page import="com.GrimoireGuide.entity.Source"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="bookViewStyle.css">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<%
	Book book = (Book) request.getAttribute("book");
	%>
	<h1><%=book.getTitle()%></h1>
	<section class = "info-block">
	<div class = "bookInfo">
		<div class = "visual">
			<% if(book.getImg_link() !=null){ %>
				<img alt="" src="<%=book.getImg_link() %>">
			<%}else{ %>
			<img alt="" src="data:image/jpg;base64, <%=book.getBase64Image()%>">
			<%} %>
		</div>
		<div class = "info">
			<h2><%= book.getTitle() %></h2>
			<span class = "mark"><%= book.getAuthor() %></span>
			<div class = "list-box">
				<ul class = "list">
					<li>
						<span>Rating: 4.2</span>
					</li>
					<li>
						<span>Usefulness: 8</span>
					</li>
				</ul>
				<ul class = "list">
					<li>
						<span>Readability: 2</span>
					</li>
					<li>
						<span>Available online free</span>
					</li>
				</ul>
			</div>
			<div class = "text-box">
				<div class = "description">
					<h3>Description</h3>
					<p><%= book.getDescription() %></p>
				</div>
			</div>
		</div>
	</div>
	</section>
	<section class = "prices">
		<h1>Compare Prices</h1>
		<%
		List<Source> sources = book.getSources();
		for (Source source:sources) {
		%>
			<ul class = "list">
				<li><%=source.getName() %></li>
				<li>$<%=source.getPrice() %></li>
				<li><a href = "<%=source.getLink() %>">Buy</a></li>
			</ul>
		
		<%} %>
	</section>


</body>
</html>