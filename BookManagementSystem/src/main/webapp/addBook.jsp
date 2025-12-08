<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Book</title>

<link rel="stylesheet" href="style.css">

</head>
<body>

	<h2>Add New Book</h2>

	<form action="AddBookServlet" method="post">
		<label>Book Title:</label> <input type="text" name="title" required><br>
		<br> <label>Author:</label> <input type="text" name="author"
			required><br> <br> <label>Price:</label> <input
			type="number" step="0.01" name="price" required><br> <br>

		<button type="submit">Add Book</button>
	</form>

	<br>
	<a href="ViewBookServlet">View All Books</a>

</body>
</html>