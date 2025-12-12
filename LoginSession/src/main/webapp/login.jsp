<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Login Page</h2>
	<form action="LoginServlet" method="post">
		<input type="text" name="username" placeholder="Enter User Name">
		<input type="password" name="password" placeholder="Enter Password">
		<button type="submit">Login</button>
	</form>

	<%
	if (request.getParameter("error") != null) {
	%>
	<p style="color: red">Invalid Username Or Password</p>
	<%
	}
	%>
</body>
</html>