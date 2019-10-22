package com.ori.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ori.model.Student;
import com.ori.service.StudentService;

@RestController
@RequestMapping("students")
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	@GetMapping
	public Iterable<Student> getStudents() {
	    return service.getAllStudents();
	} 
	
	@GetMapping("{id}")
	public Student getStudent(@PathVariable Long id) {
	    return service.getStudentByID(id);
	} 
	@PostMapping
	public Student addStudent(@RequestBody Student student) {
	    return service.addStudent(student);
	} 
	@PutMapping("{id}")
	public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
	    Student studentToUpdate = service.getStudentByID(id);
	 
	        studentToUpdate.setFirstName(student.getFirstName());
	        studentToUpdate.setLastName(student.getLastName());
	        studentToUpdate.setYear(student.getYear());
	 
	    return service.addStudent(studentToUpdate);
	}   
	@DeleteMapping("/{id}")
	public void deleteStudent(@PathVariable Long id) {
		service.getStudentByID(id);
	    service.deleteStudent(id);
	}
}
