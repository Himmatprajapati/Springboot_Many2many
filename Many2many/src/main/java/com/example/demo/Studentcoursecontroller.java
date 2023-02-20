package com.example.demo;


import java.util.List;

import javax.print.attribute.standard.MediaSize.Other;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students/course")
public class Studentcoursecontroller {
	
	@Autowired
	private Studentrepository studentrepository;
	
	@Autowired
	private Courserepository courserepository;
	
	public Studentcoursecontroller(Studentrepository studentrepository,
			Courserepository courserepository) {
		this.studentrepository = studentrepository;
		this.courserepository = courserepository;
	}
@PostMapping
public Student saveStudentWithCourse(@RequestBody Student student) {
	return  studentrepository.save(student);
	}

@GetMapping
public List<Student> findAllStudents(){
	return studentrepository.findAll();
}
@GetMapping("/{studentId}")
public Student findStudent(@PathVariable Long studentId) {
	
	return studentrepository.findById(studentId).orElse(null);
}
@GetMapping("/find/{name}")
public List<Student> findStudentsContainByName(@PathVariable String name){
	
	return studentrepository.findByNameContaining(name);
	}
@GetMapping("/search/{price}")
	public List<Course> findCourseLessThanPrice(@PathVariable double price)
	{
		return courserepository.findByFeeLessThan(price);
	}
}
