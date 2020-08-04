package com.abc.springdemo.studentdao;

import java.util.Currency;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.abc.springdemo.entity.Student;

@Repository
public class StudentDaoImp implements StudentDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Student> getStudents() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Student> query = currentSession.createQuery("from Student",Student.class);		
		List<Student> resultList = query.getResultList();
		
		return resultList;
	}

	@Override
	public void saveStudent(@ModelAttribute("student") Student student) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(student);
		
	}

	@Override
	public Student getStudent(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Student student = currentSession.get(Student.class, id);
		return student;
	}

	@Override
	public void deleteStudent(int id) {

		Session currentSession = sessionFactory.getCurrentSession();

		Query query = currentSession.createQuery("delete from Student where id=:id");
		query.setParameter("id", id);
		query.executeUpdate();
		System.out.println(id);

	}
	
}
