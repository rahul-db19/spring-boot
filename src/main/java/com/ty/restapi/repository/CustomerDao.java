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

}
