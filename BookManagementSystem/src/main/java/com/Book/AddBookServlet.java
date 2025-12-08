package com.Book;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AddBookServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String author = req.getParameter("author");
        String price = req.getParameter("price");

        Connection con = null;
        PreparedStatement ps = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlets", "root", "MySQL#012AJ");

            ps = con.prepareStatement("INSERT INTO books(title, author, price) VALUES (?, ?, ?)");
            ps.setString(1, title);
            ps.setString(2, author);
            ps.setDouble(3, Double.parseDouble(price));

            ps.executeUpdate();

            // FIXED: redirect to servlet, NOT JSP
            resp.sendRedirect("ViewBookServlet");

        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().println("Error: " + e.getMessage());
        }
    }
}
