package com.JDBC_Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DisplayData {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Connection con = null;
		PreparedStatement ps = null;
		String url = "jdbc:mysql://localhost:3306/servlets";
		String user = "root";
		String password = "MySQL#012AJ";
		ResultSet res = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			System.out.println("Connected Successfully.");

			System.out.println("Enter Name: ");
			String name = sc.next();
			System.out.println("Enter Salary: ");
			float salary = sc.nextFloat();

			String insert = "INSERT INTO EMPLOYEE(NAME,SALARY) VALUES(?,?)";
			ps = con.prepareStatement(insert);
			ps.setString(1, name);
			ps.setFloat(2, salary);
			int row = ps.executeUpdate();
			System.out.println(row + " record affected.");

			String display = "SELECT * FROM EMPLOYEE";
			ps = con.prepareStatement(display);
			res = ps.executeQuery();
			System.out.println("----->Employee Table<-----");
			while (res.next()) {
				int EmpId = res.getInt("id");
				String EmpName = res.getString("name");
				float EmpSalary = res.getFloat("salary");

				System.out.println("ID: " + EmpId + " | NAME: " + EmpName + " | SALARY: " + EmpSalary);
			}

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Not Connected.");
			e.printStackTrace();
		}

	}

}
