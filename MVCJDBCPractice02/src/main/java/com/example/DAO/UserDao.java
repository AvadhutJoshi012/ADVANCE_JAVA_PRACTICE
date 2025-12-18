package com.example.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.POJO.User;

@Repository
public class UserDao {

	private final JdbcTemplate jdbcTemplate;

	public UserDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void insertUser(User user) {
		String sql = "Insert into user(name,email) values(?,?)";
		jdbcTemplate.update(sql, user.getName(), user.getEmail());
	}

	public List<User> displayUsers() {
		String sql = "Select * from user";

		return jdbcTemplate.query(sql, new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User u = new User();
				u.setId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				u.setEmail(rs.getString("email"));
				return u;
			}

		});
	}

}
