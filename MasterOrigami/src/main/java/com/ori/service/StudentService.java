package com.ori.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ori.exception.StudentNotFoundException;
import com.ori.model.Student;
import com.ori.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository repository;
	
	@Cacheable(value = "S")
	public Iterable<Student> getAllStudents() {
	    return repository.findAll();
	} 
	
	@Cacheable(value="mycache",condition = "#id > 10",key ="#id" )
	public Student getStudentByID(Long id) {
	    return repository.findById(id).orElseThrow(StudentNotFoundException::new);
	} 
	@CachePut(value = "mycache", key="#student")
	public Student addStudent(Student student) {
	    return repository.save(student);
	} 
	
	public Student updateStudent(Long id, Student student) {
	    Student studentToUpdate = repository.findById(id).orElseThrow(StudentNotFoundException::new);
	 
	        studentToUpdate.setFirstName(student.getFirstName());
	        studentToUpdate.setLastName(student.getLastName());
	        studentToUpdate.setYear(student.getYear());
	 
	    return repository.save(studentToUpdate);
	}   

	public void deleteStudent(Long id) {
	    repository.findById(id).orElseThrow(StudentNotFoundException::new);
	    repository.deleteById(id);
	}

}
