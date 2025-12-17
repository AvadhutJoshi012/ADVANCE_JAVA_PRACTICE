package com.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shop.model.Product;

public class ProductDao {

	public List<Product> getAllProducts() throws ClassNotFoundException, SQLException {
		List<Product> list = new ArrayList<>();

		try (Connection con = DBUtil.getConnection()) {
			PreparedStatement ps = con.prepareStatement("Select * from product");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product p = new Product();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setPrice(rs.getDouble("price"));
				list.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

}
