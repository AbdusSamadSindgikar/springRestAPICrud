package com.abc.springdemo.controller;

import java.util.List; 



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.springdemo.entity.Student;
import com.abc.springdemo.studentservice.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/students")
	public List<Student> getStudents(Model model) {
		List<Student> theStudent=studentService.getStudents();
		return theStudent;
	}
	
	@GetMapping("/students/{theStudentId}")
	public Student getStudent(@PathVariable int theStudentId) {
		Student student = studentService.getStudents(theStudentId);
		return student;
		
	}
	@PostMapping("/students")
	public Student addStudent(@RequestBody Student student) {
		student.setId(0);
		studentService.saveStudent(student);
		return student;
	}
	@PutMapping("/students")
	public Student updateStudent(@RequestBody Student student) {
		studentService.saveStudent(student);
		return student;
	}
	
	@DeleteMapping("/students/{id}")
	public void delete(@PathVariable int id) {
		studentService.deleteStudent(id);
	}
	
	
		
}

