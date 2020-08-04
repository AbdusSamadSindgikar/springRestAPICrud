package com.abc.springdemo.studentdao;

import java.util.List;

import com.abc.springdemo.entity.Student;

public interface StudentDao {
	
	public List<Student> getStudents();
	
	public void saveStudent(Student student);

	public Student getStudent(int id);
	
	public void deleteStudent(int id);
}
