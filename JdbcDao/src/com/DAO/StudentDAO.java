package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.Connection.CreateConnection;
import com.POJO.Student;

public class StudentDAO {

	public void insertStudent(Student student) {

		String sql = "Insert into student(name,email) values(?,?)";

		try (Connection con = CreateConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql);) {

			ps.setString(1, student.getName());
			ps.setString(2, student.getEmail());

			ps.executeUpdate();
			System.out.println("Inserted Successfully");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Student> displayStudent() {

		List<Student> list = new ArrayList<>();

		String sql = "Select * from student";

		try (Connection con = CreateConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();) {

			while (rs.next()) {
				Student s = new Student();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setEmail(rs.getString("email"));

				list.add(s);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
