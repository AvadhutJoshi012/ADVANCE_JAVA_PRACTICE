<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="jakarta.servlet.http.HttpSession"%>

<%
if (session == null || session.getAttribute("username") == null) {
	response.sendRedirect("login.jsp");
	return;
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>
		Welcome,
		<%=session.getAttribute("username")%>!
	</h2>

	<a href="LogoutServlet">Logout</a>
</body>
</html>