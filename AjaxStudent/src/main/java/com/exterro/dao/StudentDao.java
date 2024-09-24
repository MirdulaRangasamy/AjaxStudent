package com.exterro.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.exterro.entity.Student;

public class StudentDao {
	private SessionFactory sessionFactory;
	
	public StudentDao() {
		super();
		this.sessionFactory = SessionFactoryProvider.getSessionFactory();
	}

	public Student addStudent(Student student) {
		Session session = this.sessionFactory.openSession();
		session.getTransaction().begin();
		session.save(student);
		session.getTransaction().commit();
		return student;	
	}
	
	public Student updateStudent(Student student) {
		Session session = this.sessionFactory.openSession();
		session.getTransaction().begin();
		session.saveOrUpdate(student);
		session.getTransaction().commit();
		return student;	
	}
	
	public Student getStudent(int rollNo) {
		Session session = this.sessionFactory.openSession();
		session.getTransaction().begin();
		Student student = (Student)session.get(Student.class, rollNo);
		session.getTransaction().commit();
		return student;	
	}
	
	public List<Student> getAllStudents(){
		Session session = this.sessionFactory.openSession();
		session.getTransaction().begin();
		Query query = session.createQuery("from Student stud");
		List<Student> studentList = query.list();
		session.getTransaction().commit();
		return studentList;
	}
	
	public String deleteStudent(int rollNo) {
		Session session = this.sessionFactory.openSession();
		session.getTransaction().begin();
		Student student = (Student)session.get(Student.class, rollNo);
		String result = "";
		if(student!=null) {
			session.delete(student);
			result = "Student Deleted";	
		}
		else {
			result = "Student Deleted";
		}
		session.getTransaction().commit();
		return result;
	}
}
