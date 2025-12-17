package com.shop.servlet;

import com.shop.entity.Product;
import com.shop.util.HibernateUtil;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import org.hibernate.Session;
import java.io.IOException;
import java.util.*;

public class AddToCartServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		HttpSession session = req.getSession();
		List<Product> cart = (List<Product>) session.getAttribute("cart");

		if (cart == null) {
			cart = new ArrayList<>();
		}

		int id = Integer.parseInt(req.getParameter("id"));
		Session hibSession = HibernateUtil.getFactory().openSession();
		Product p = hibSession.get(Product.class, id);
		hibSession.close();

		cart.add(p);
		session.setAttribute("cart", cart);

		res.sendRedirect("ProductServlet");
	}
}
