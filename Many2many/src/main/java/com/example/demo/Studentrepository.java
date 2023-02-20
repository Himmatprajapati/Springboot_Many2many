package com.example.demo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface Studentrepository extends JpaRepository<Student,Long>{

	
	List<Student> findByNameContaining(String name);
}
