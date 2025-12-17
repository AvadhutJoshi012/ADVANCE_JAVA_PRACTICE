package com.shop.servlet;

import com.shop.entity.User;
import com.shop.util.HibernateUtil;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import org.hibernate.*;
import org.hibernate.query.Query;

import java.io.IOException;

public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String uname = req.getParameter("username");
		String pass = req.getParameter("password");

		Session hibSession = HibernateUtil.getFactory().openSession();

		Query<User> q = hibSession.createQuery("from User where username=:u and password=:p", User.class);

		q.setParameter("u", uname);
		q.setParameter("p", pass);

		User user = q.uniqueResult();

		if (user != null) {
			HttpSession session = req.getSession();
			session.setAttribute("username", uname);
			res.sendRedirect("ProductServlet");
		} else {
			res.sendRedirect("login.jsp?error=1");
		}

		hibSession.close();
	}
}