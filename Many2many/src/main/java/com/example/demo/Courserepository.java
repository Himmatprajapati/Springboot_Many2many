package com.example.demo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface Courserepository extends JpaRepository<Course, Long> {

	
	List<Course> findByFeeLessThan(double fee);
}
