package com.ori.repository;

import org.springframework.data.repository.CrudRepository;

import com.ori.model.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {
	 
}
