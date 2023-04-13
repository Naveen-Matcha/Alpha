package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.StudentService;
import com.example.demo.request.CreateStudentRequest;
import com.example.demo.response.StudentResponse;

@RestController
@RequestMapping("/api/student")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@PostMapping("/create")
	public StudentResponse createStudent(@RequestBody CreateStudentRequest CreateStudentRequest) {
		return studentService.createStudent(CreateStudentRequest);
	}
	
	@GetMapping("/getById/{id}")
	public StudentResponse getById(@PathVariable long id) {
		return studentService.getById(id);
	}
	
	
	

}
