package com.Book;

import java.io.IOException;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class UpdateBookServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlets", "root", "MySQL#012AJ");

			PreparedStatement ps = con.prepareStatement("SELECT * FROM books WHERE id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				req.setAttribute("id", rs.getInt("id"));
				req.setAttribute("title", rs.getString("title"));
				req.setAttribute("author", rs.getString("author"));
				req.setAttribute("price", rs.getDouble("price"));
			}

			RequestDispatcher rd = req.getRequestDispatcher("editBook.jsp");
			rd.forward(req, resp);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));
		String title = req.getParameter("title");
		String author = req.getParameter("author");
		double price = Double.parseDouble(req.getParameter("price"));

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlets", "root", "MySQL#012AJ");

			PreparedStatement ps = con.prepareStatement("UPDATE books SET title=?, author=?, price=? WHERE id=?");

			ps.setString(1, title);
			ps.setString(2, author);
			ps.setDouble(3, price);
			ps.setInt(4, id);

			ps.executeUpdate();

			resp.sendRedirect("ViewBookServlet");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
