package com.Book;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ViewBookServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 List<Book> books = new ArrayList<>();

	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection con = DriverManager.getConnection(
	                    "jdbc:mysql://localhost:3306/servlets",
	                    "root",
	                    "MySQL#012AJ"
	            );

	            Statement st = con.createStatement();
	            ResultSet rs = st.executeQuery("SELECT * FROM books");

	            while (rs.next()) {
	                books.add(new Book(
	                    rs.getInt("id"),
	                    rs.getString("title"),
	                    rs.getString("author"),
	                    rs.getDouble("price")
	                ));
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        req.setAttribute("bookList", books);
	        RequestDispatcher rd = req.getRequestDispatcher("viewBook.jsp");
	        rd.forward(req, resp);
	}
	
}
