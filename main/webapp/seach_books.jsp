<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <link rel="stylesheet" href="styles.css">
<title>Insert title here</title>
</head>
<body>
		<div>
		<h2>Search Result</h2>
	</div>
	<div>
		<table>
			<tr>
				<td> Title </td>
				<td> Author </td>
				<td> Description </td>
			</tr>	
		<% List<Book> listBook = (List<Book>)request.getAttribute("result");
		Book book = new Book(); %>
		
			<%if(listBook.size() < 1){%>
				<h3>no result found</h3>
			<%}else{%>
	<% for(int i = 0; i < listBook.size(); i++){ %>
	<tr>
		<% book = listBook.get(i); %>
		<td>
			<%if(book.getBase64Image() != null){ %>
				<img alt="" src="data:image/jpg;base64, <%= book.getBase64Image() %>">	
			<%} %>	
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
	</tr>
	<tr>
		<% List<Source> sources = book.getSources(); 
			for(Source source:sources){%>
				<td><%= source.getName() %> </td>
				<td>
					<a href = "<%= source.getLink()%>"><%=source.getPrice()%></a>
				</td>
				
			<%}%>
	</tr>
	<%}}%>
	</table>
	</div>
	
	<table>
		<tr>
			<td>
				<div class="bookview-img">
					<%
					if (book.getBase64Image() != null) {
					%>
					<img alt=""
						src="data:image/jpg;base64, <%=book.getBase64Image()%>">
					<%
					} else {
					%>
					<img alt=""
						src="C:\Users\GFRD\Documents\340 project\book images\placeholder-.png">
					<%
					}
					%>
				</div>
			</td>
			<td>
				<p><%=book.getDescription()%></p>
			</td>
		</tr>

	</table>
	<h3>Compare prices</h3>
	<table>
		<%
		List<Source> sources = book.getSources();
		for (Source source : sources) {
		%>
		<tr>
			<td><p><%=source.getName()%></p></td>
			<td><p><%=source.getPrice()%></p></td>
			<td>
				<form action="<%= source.getLink() %>">
					<input type="submit" value="view" />
				</form>
			</td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>