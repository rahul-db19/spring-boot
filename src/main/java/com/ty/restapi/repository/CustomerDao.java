package com.ty.restapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.restapi.dto.Customer;
import com.ty.restapi.exception.CustomerIdNotFoundException;


@Repository
public class CustomerDao {
	@Autowired
	private CustomerRepository customerRepository;
	//SimpleJpaRepository object
	//--> CRUD operations method implementation

	public Customer insertCustomer(Customer customer) {
		return customerRepository.save(customer); //persistence logic
	}
	public List<Customer> findAllCustomers() {
		return customerRepository.findAll();
	}
	public Optional<Customer> findCustById(int custId) {
		return customerRepository.findById(custId);
	}
	public Customer deleteCustomer(int custId) {
		Optional<Customer> findById = customerRepository.findById(custId);
		
		if(findById.isPresent()) {
			customerRepository.deleteById(custId);
			return findById.get();
		}
		throw new CustomerIdNotFoundException("Customer ID Not Found");
	}
	
	public Customer updateCustomer(Customer customer) {
		Optional<Customer> findById = customerRepository.findById(customer.getCustid());
		if(findById.isPresent()) {
			return customerRepository.save(customer);
		}
		throw new CustomerIdNotFoundException("Customer ID is not available for updation");
	}
	
	public Customer partialUpdate(int custId, long phone) {
		Optional<Customer> customer = customerRepository.findById(custId);
		if(customer.isPresent()) {
			Customer custom = customer.get();
			custom.setPhone(phone);
			return customerRepository.save(custom);
		}
		throw new CustomerIdNotFoundException("Customer ID is not available for updation");
	}
}
