package com.example.demo.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Address;
import com.example.demo.Repository.AddressRepository;
import com.example.demo.Request.CreateAddressRequest;
import com.example.demo.Response.AddressResponse;

@Service
public class AddressService {
	
	Logger logger =  LoggerFactory.getLogger(AddressService.class);
	
	@Autowired
	AddressRepository addressRepository;

	public AddressResponse createAddress(CreateAddressRequest createAddressRequest) {
		// TODO Auto-generated method stub
		Address address = new Address();
		address.setStreet(createAddressRequest.getStreet());
		address.setCity(createAddressRequest.getCity());
		addressRepository.save(address);
		return new AddressResponse(address);
	}

	public AddressResponse getById(long id) {
		// TODO Auto-generated method stub
		logger.info("Inside getById" + id );
		Address address = addressRepository.findById(id).get();
		return new AddressResponse(address);
	}

	

	
	

}
