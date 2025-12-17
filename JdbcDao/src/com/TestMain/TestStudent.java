package com.TestMain;

import java.util.List;

import com.DAO.StudentDAO;
import com.POJO.Student;

public class TestStudent {

	public static void main(String[] args) {

		StudentDAO dao = new StudentDAO();

		Student s1 = new Student("Ram", "ram@gmail.com");
		dao.insertStudent(s1);

		List<Student> students = dao.displayStudent();

		for (Student s : students) {
			System.out.println(s.getId() + " | " + s.getName() + " | " + s.getEmail());
		}

	}

}
