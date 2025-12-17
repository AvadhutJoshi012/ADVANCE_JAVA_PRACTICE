<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,com.shop.entity.Product"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cart</title>

<!-- Bootstrap CDN -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>

<div class="container mt-4">

    <div class="d-flex justify-content-between mb-3">
        <h3>Your Cart</h3>
        <a href="LogoutServlet" class="btn btn-danger">Logout</a>
    </div>

    <%
    List<Product> cart = (List<Product>) session.getAttribute("cart");
    if (cart == null || cart.isEmpty()) {
    %>
        <div class="alert alert-warning">Cart is empty</div>
    <%
    } else {
    %>
        <ul class="list-group">
            <%
            for (Product p : cart) {
            %>
                <li class="list-group-item d-flex justify-content-between">
                    <span><%=p.getName()%></span>
                    <span>₹ <%=p.getPrice()%></span>
                </li>
            <%
            }
            %>
        </ul>
    <%
    }
    %>

    <div class="mt-3">
        <a href="ProductServlet" class="btn btn-secondary">Back</a>
    </div>

</div>

</body>
</html>
