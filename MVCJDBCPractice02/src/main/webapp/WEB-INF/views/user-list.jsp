<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*,com.example.POJO.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>List of Users</h2>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Email</th>
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
</body>
</html>