package com.abc.springdemo.studentservice;

import java.util.List;

import com.abc.springdemo.entity.Student;


public interface StudentService {
	public List<Student> getStudents();
	
	public void saveStudent(Student student);

	public Student getStudents(int id);
	
	public void deleteStudent(int id);
	

}
