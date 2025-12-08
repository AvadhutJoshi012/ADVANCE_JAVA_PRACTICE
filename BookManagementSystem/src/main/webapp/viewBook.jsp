<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.util.*, com.Book.Book"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="style.css">

</head>
<body>
	<h2>Book List</h2>

	<table border="1" cellpadding="10">
		<tr>
			<th>ID</th>
			<th>Book Title</th>
			<th>Author</th>
			<th>Price</th>
			<th>Actions</th>
		</tr>

		<%
		List<Book> books = (List<Book>) request.getAttribute("bookList");

		if (books != null && !books.isEmpty()) {
			for (Book b : books) {
		%>

		<tr>
			<td><%=b.getId()%></td>
			<td><%=b.getTitle()%></td>
			<td><%=b.getAuthor()%></td>
			<td><%=b.getPrice()%></td>
			<td><a class="edit-btn"
				href="UpdateBookServlet?id=<%=b.getId()%>">Edit</a> <a
				class="delete-btn" href="DeleteBookServlet?id=<%=b.getId()%>">Delete</a>
			</td>
		</tr>

		<%
		}
		} else {
		%>
		<tr>
			<td colspan="5" style="text-align: center;">No books found</td>
		</tr>
		<%
		}
		%>

	</table>

	<br>
	<br>
	<a href="addBook.jsp">Add Another Book</a>
</body>
</html>