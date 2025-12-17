<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome Page</title>
</head>
<body>
	<h1>
		Hello,
		<%=request.getAttribute("uname")%></h1>

	<a href="index.jsp">Back</a>
	<a href="next.jsp">Next Page</a>
</body>
</html>