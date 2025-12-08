<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page language="java"%>
<!DOCTYPE html>
<html>
<head>
<title>Edit Book</title>
<link rel="stylesheet" href="style.css">
</head>
<body>

	<h2>Edit Book</h2>

	<form action="UpdateBookServlet" method="post">

		<input type="hidden" name="id" value="${id}"> <label>Title:</label>
		<input type="text" name="title" value="${title}" required><br>
		<br> <label>Author:</label> <input type="text" name="author"
			value="${author}" required><br>
		<br> <label>Price:</label> <input type="number" name="price"
			step="0.01" value="${price}" required><br>
		<br>

		<button type="submit">Update Book</button>
	</form>

</body>
</html>
