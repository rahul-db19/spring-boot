package com.ty.restapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.restapi.dto.Customer;
import com.ty.restapi.repository.CustomerDao;
import com.ty.restapi.response.ResponseStructure;

@Service
public class CustomerService {
	@Autowired
	private CustomerDao customerDao;

	public ResponseStructure<?> insertCustomer(Customer customer) {
		Customer cust = customerDao.insertCustomer(customer);
		ResponseStructure<Customer> responseStructure = new ResponseStructure<>();
		responseStructure.setData(cust);
		responseStructure.setHttpStatus(HttpStatus.CREATED);//201
		
		return responseStructure;
	}

	public ResponseStructure<?> findAllCustomers() {
		List<Customer> customerList = customerDao.findAllCustomers();
		ResponseStructure<List<Customer>> responseStructure = new ResponseStructure<>();
		
		responseStructure.setData(customerList);
		responseStructure.setHttpStatus(HttpStatus.OK);
		return responseStructure;
	}
	
}
