package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Student;
import com.example.demo.Service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@GetMapping("/")
	public List<Student> getData() {
		return studentService.getAllData();
	}
}
