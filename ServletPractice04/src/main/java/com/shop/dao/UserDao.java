package com.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.shop.model.User;

public class UserDao {

	public User validate(String username, String password) {
		User user = null;

		try (Connection con = DBUtil.getConnection()) {

			PreparedStatement ps = con.prepareStatement("Select * from user Where username=? AND password=?");

			ps.setString(1, username);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return user;
	}

}
