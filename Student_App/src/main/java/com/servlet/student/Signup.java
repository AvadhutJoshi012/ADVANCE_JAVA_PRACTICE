package com.servlet.student;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/signup")
public class Signup extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
		String name=req.getParameter("uname");
		String email=req.getParameter("mail");
		String phone=req.getParameter("phone");
		String language=req.getParameter("language");
		String location=req.getParameter("location");
		String password=req.getParameter("pass");
		String confirm=req.getParameter("conf");
		
		out.println("<h2>SignUp Details</h2>");
		out.println("<p>Name: "+name+"</p>");
		out.println("<p>Email: "+email+"</p>");
		out.println("<p>Language: "+language+"</p>");
		out.println("<p>Location: "+location+"</p>");
		
		if(password.equals(confirm)) {
			out.print("<p style='color:green'><b>Password Matches Successfully</b></p>");
		}else {
			out.print("<p style='color:red'><b>Fail To Match</b></p>");
		}
	}

}
