package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/student")
public class StudentServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String city = request.getParameter("city");

		out.println("<html><body>");
		out.println("<h2>Student Information</h2>");
		out.println("<p><b>Name:</b> " + name + "</p>");
		out.println("<p><b>Age:</b> " + age + "</p>");
		out.println("<p><b>City:</b> " + city + "</p>");
		out.println("</body></html>");
	}
}
