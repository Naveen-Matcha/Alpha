package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Student;
import com.example.demo.Repository.StudentRepository;
import com.example.demo.feignClients.AddressFeignClient;
import com.example.demo.request.CreateStudentRequest;
import com.example.demo.response.StudentResponse;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	AddressFeignClient addressFeignClient;

	public StudentResponse createStudent(CreateStudentRequest createStudentRequest) {
		// TODO Auto-generated method stub
		Student student = new Student();
		student.setFirstName(createStudentRequest.getFirstName());
		student.setLastName(createStudentRequest.getLastName());
		student.setEmail(createStudentRequest.getEmail());
		student.setAddressId(createStudentRequest.getAddressId());
		student= studentRepository.save(student);
		
		StudentResponse studentResponse = new StudentResponse(student);
		studentResponse.setAddressResponse(addressFeignClient.getById(student.getAddressId()));
		return studentResponse;
	}

	public StudentResponse getById(long id) {
		// TODO Auto-generated method stub
		
		Student student = studentRepository.findById(id).get();
		StudentResponse studentResponse = new StudentResponse(student);
		studentResponse.setAddressResponse(addressFeignClient.getById(student.getAddressId()));
		return studentResponse;
	}

}
