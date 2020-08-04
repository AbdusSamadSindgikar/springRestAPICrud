package com.abc.springdemo.studentservice;

import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.springdemo.studentdao.StudentDao;
import com.abc.springdemo.entity.Student;
@Service
public class StudentServiceImp implements StudentService {
	@Autowired
	private StudentDao studentDao;
	
	@Override
	@Transactional
	public List<Student> getStudents() {
		List<Student> students = studentDao.getStudents();
		return students;
	}

	@Override
	@Transactional
	public void saveStudent(Student student) {
		studentDao.saveStudent(student);
		
	}

	@Override
	@Transactional
	public Student getStudents(int id) {
		Student student = studentDao.getStudent(id);
		return student;
	}

	@Override
	@Transactional
	public void deleteStudent(int id) {
		
		studentDao.deleteStudent(id);
		
	}
		

}
