package com.Book;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteBookServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlets", "root", "MySQL#012AJ");

			PreparedStatement ps = con.prepareStatement("DELETE FROM books WHERE id=?");
			ps.setInt(1, id);
			ps.executeUpdate();

			resp.sendRedirect("ViewBookServlet");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
