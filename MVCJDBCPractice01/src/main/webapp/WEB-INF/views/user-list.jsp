<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.*, com.example.POJO.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User List</title>
</head>
<body>
	<h2>User List</h2>
	<table border="1">
		<tr>
			<td>Id</td>
			<td>Name</td>
			<td>Email</td>
		</tr>

		<%
		List<User> list = (List<User>) request.getAttribute("users");
		for (User u : list) {
		%>
		<tr>
			<td><%=u.getId()%></td>
			<td><%=u.getName()%></td>
			<td><%=u.getEmail()%></td>
		</tr>
		<%
		}
		%>
	</table>
	<br>
	<a href="form">Add New User</a>
</body>
</html>