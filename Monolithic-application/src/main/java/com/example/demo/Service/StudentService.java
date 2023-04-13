package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Address;
import com.example.demo.Entity.Student;
import com.example.demo.Repository.AddressRepository;
import com.example.demo.Repository.StudentRepository;
import com.example.demo.request.CreateStudentRequest;
import com.example.demo.response.StudentResponse;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	AddressRepository addressRepository;

	public StudentResponse createStudent(CreateStudentRequest createStudentRequest) {
		// TODO Auto-generated method stub
		Address address = new Address();
		address.setStreet(createStudentRequest.getStreet());
		address.setCity(createStudentRequest.getCity());
		
		address = addressRepository.save(address);
		
		Student student = new Student();
		student.setFirstName(createStudentRequest.getFirstName());
		student.setLastName(createStudentRequest.getLastName());
		student.setEmail(createStudentRequest.getEmail());
		
		student.setAddress(address);
		student = studentRepository.save(student);
		return new StudentResponse(student);
	}

	public StudentResponse getById(long id) {
		// TODO Auto-generated method stub
		return new StudentResponse(studentRepository.findById(id).get());
	}

}
