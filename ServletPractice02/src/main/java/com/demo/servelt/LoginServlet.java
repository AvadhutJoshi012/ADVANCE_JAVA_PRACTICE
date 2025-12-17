package com.demo.servelt;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("username");
		String email = req.getParameter("email");
		String age = req.getParameter("age");

		req.setAttribute("name", name);
		req.setAttribute("email", email);
		req.setAttribute("age", age);

		req.getRequestDispatcher("display.jsp").forward(req, resp);
	}

}
