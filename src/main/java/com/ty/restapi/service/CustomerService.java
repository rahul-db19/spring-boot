package com.ty.restapi.service;

import java.util.List;
import java.util.Optional;

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
		responseStructure.setHttpStatus(HttpStatus.CREATED);// 201

		return responseStructure;
	}

	public ResponseStructure<?> findAllCustomers() {
		List<Customer> customerList = customerDao.findAllCustomers();
		ResponseStructure<List<Customer>> responseStructure = new ResponseStructure<>();

		responseStructure.setData(customerList);
		responseStructure.setHttpStatus(HttpStatus.OK);
		return responseStructure;
	}

	public ResponseStructure<?> findCustById(int custId) {
		Optional<Customer> findCustById = customerDao.findCustById(custId);
		if (findCustById.isPresent()) {
			ResponseStructure<Customer> responseStructure = new ResponseStructure<>();
			Customer customer = findCustById.get();
			responseStructure.setData(customer);
			responseStructure.setHttpStatus(HttpStatus.OK);
			return responseStructure;
		} else {
			ResponseStructure<String> responseStructure = new ResponseStructure<>();
			responseStructure.setData("CUSTOMER ID NOT FOUND");
			responseStructure.setHttpStatus(HttpStatus.NOT_FOUND);
			return responseStructure;
		}
	}

	public ResponseStructure<?> deleteCustomer(int custId) {
		Customer customer = customerDao.deleteCustomer(custId);
		ResponseStructure<Customer> responseStructure = new ResponseStructure<>();
		responseStructure.setData(customer);
		responseStructure.setHttpStatus(HttpStatus.OK);
		return responseStructure;
	}

	public ResponseStructure<?> updateCustomer(Customer customer) {
		Customer cust = customerDao.updateCustomer(customer);
		ResponseStructure<Customer> responseStructure = new ResponseStructure<>();
		responseStructure.setData(cust);
		responseStructure.setHttpStatus(HttpStatus.OK);
		return responseStructure;
		
	}

	public ResponseStructure<?> partialUpdate(int custId, long phone) {
		Customer customer =  customerDao.partialUpdate(custId,phone);
		ResponseStructure<Customer> responseStructure = new ResponseStructure<>();
		responseStructure.setData(customer);
		responseStructure.setHttpStatus(HttpStatus.OK);
		return responseStructure;
	}
}