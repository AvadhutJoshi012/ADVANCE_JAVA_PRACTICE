<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add User</title>
</head>
<body>

	<h2>Add User</h2>
	
	<form action="save" method="post">
		<input type="text" name="name" placeholder="Enter Name"	required><br><br>
		<input type="email" name="email" placeholder="Enter Email" required><br><br>
		<button type="submit">SAVE</button>
	</form>
	<br>
	<a href="list">View User</a>

</body>
</html>