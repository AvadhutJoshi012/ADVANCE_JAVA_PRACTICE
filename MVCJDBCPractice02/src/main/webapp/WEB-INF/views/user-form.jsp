<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Add User</h2>
	<form action="save" method="post">
		Name: <input type="text" name="name"><br>
		<br> Email: <input type="email" name="email"><br>
		<br>
		<button type="submit">Save</button>
	</form>

	<a href="list">View Users</a>

</body>
</html>