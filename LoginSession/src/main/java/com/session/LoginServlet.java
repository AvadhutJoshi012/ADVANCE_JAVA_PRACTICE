package com.session;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String username = req.getParameter("username");
		String password = req.getParameter("password");

		if (username.equals("admin") && password.equals("1234")) {
			HttpSession session = req.getSession();
			session.setAttribute("username", username);
			session.setMaxInactiveInterval(10 * 60);
			resp.sendRedirect("DashboardServlet");
		} else {
			resp.sendRedirect("login.jsp?error=1");
		}

	}

}
