package com.shop.servlet;

import com.shop.entity.Product;
import com.shop.util.HibernateUtil;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import org.hibernate.Session;
import java.io.IOException;
import java.util.List;

public class ProductServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		HttpSession session = req.getSession(false);
		if (session == null) {
			res.sendRedirect("login.jsp");
			return;
		}

		Session hibSession = HibernateUtil.getFactory().openSession();
		List<Product> products = hibSession.createQuery("from Product", Product.class).list();
		hibSession.close();

		req.setAttribute("products", products);
		req.getRequestDispatcher("products.jsp").forward(req, res);
	}
}
