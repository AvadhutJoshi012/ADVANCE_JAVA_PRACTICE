<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>
		Name:
		<%=request.getAttribute("name")%></h3>
	<h3>
		Email:
		<%=request.getAttribute("email")%></h3>
	<h3>
		Age:
		<%=request.getAttribute("age")%></h3>
</body>
</html>