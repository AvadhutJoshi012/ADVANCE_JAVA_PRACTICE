package com.example.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.POJO.User;

public class UserDao {

	private final String url = "jdbc:mysql://localhost:3306/jdbc";
	private final String user = "root";
	private final String password = "MySQL#012AJ";

	public Connection getConnection() {
		Connection con = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;

	}

	public void insertUser(User user) {

		String sql = "Insert into user(name,email) values(?,?)";

		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<User> displayUser() {

		List<User> list = new ArrayList<>();
		String sql = "Select * from user";

		try (Connection con = getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				User u = new User();
				u.setId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				u.setEmail(rs.getString("email"));

				list.add(u);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;

	}

}
