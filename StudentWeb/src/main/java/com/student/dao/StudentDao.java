package com.student.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.student.model.Student;

public class StudentDao {

	private SessionFactory factory;

	public StudentDao() {
		factory = new Configuration().configure().buildSessionFactory();
	}

	public void saveStudent(Student st) {
		Session session = factory.openSession();
		session.beginTransaction();
		session.persist(st);
		session.getTransaction().commit();
		session.close();
	}
}
