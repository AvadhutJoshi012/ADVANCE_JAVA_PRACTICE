<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,com.shop.entity.Product"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Products</title>

<!-- Bootstrap CDN -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>

<div class="container mt-4">

    <div class="d-flex justify-content-between mb-3">
        <h3>Products</h3>
        <a href="LogoutServlet" class="btn btn-danger">Logout</a>
    </div>

    <div class="row">
        <%
        List<Product> list = (List<Product>) request.getAttribute("products");
        for (Product p : list) {
        %>

        <div class="col-md-4">
            <div class="card mb-3 shadow-sm">
                <div class="card-body text-center">
                    <h5 class="card-title"><%=p.getName()%></h5>
                    <p class="card-text">₹ <%=p.getPrice()%></p>
                    <a href="AddToCartServlet?id=<%=p.getId()%>" class="btn btn-success">
                        Add to Cart
                    </a>
                </div>
            </div>
        </div>

        <%
        }
        %>
    </div>

    <a href="ViewCartServlet" class="btn btn-primary mt-3">View Cart</a>

</div>

</body>
</html>
