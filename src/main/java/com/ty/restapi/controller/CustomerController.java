package com.ty.restapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.restapi.dto.Customer;
import com.ty.restapi.response.ResponseStructure;
import com.ty.restapi.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping(path = "/persist")
	public ResponseEntity<?> insertCustomer(@RequestBody Customer customer) {
		ResponseStructure<?> responseStructure = customerService.insertCustomer(customer);
		return new ResponseEntity<>(responseStructure,responseStructure.getHttpStatus());
	}
	
	@GetMapping(path = "/fetchAll")
	public ResponseEntity<?> findAllCustomers(){
		ResponseStructure<?> responseStructure = customerService.findAllCustomers();
		return new ResponseEntity<>(responseStructure,responseStructure.getHttpStatus());
	}
	
	@GetMapping(path = "fetch/{custId}")
	public ResponseEntity<?> findCustById(@PathVariable int custId){
		ResponseStructure<?> responseStructure = customerService.findCustById(custId);
		return new ResponseEntity<>(responseStructure,responseStructure.getHttpStatus()); 
	}
	
	@DeleteMapping(path="/delete/{custId}")
	public ResponseEntity<?> deleteCustomer(@PathVariable int custId){
		ResponseStructure<?> responseStructure = customerService.deleteCustomer(custId);
		return new ResponseEntity<>(responseStructure,responseStructure.getHttpStatus());
	}
	
	@PutMapping(path="/update")
	public ResponseEntity<?> updateCustomer(@RequestBody Customer customer){		
		ResponseStructure<?> responseStructure = customerService.updateCustomer(customer);
		return new ResponseEntity<>(responseStructure,responseStructure.getHttpStatus());
	}
	
	@PatchMapping(path="/partupdate/{phone}")
	public ResponseEntity<?> partialUpdate(@RequestParam int custId,@PathVariable long phone){		
		ResponseStructure<?> responseStructure = customerService.partialUpdate(custId,phone);
		return new ResponseEntity<>(responseStructure,responseStructure.getHttpStatus());   
	}
	

	/*
	 * Any http request of type POST from the client then below mentioned will
	 * execute
	 * 
	 * @PostMapping(path = "/persist") 
	 * public ResponseEntity<?> insertCustomer (@RequestBody Customer customer){ 
	 * return new ResponseEntity<>(customer,HttpStatus.OK); 
	 * }
	 * 
	 * @GetMapping(path="/fetch") public ResponseEntity<?> getCustomer(@RequestParam
	 * int custid){ if(custid>=1) { return new ResponseEntity<>
	 * ("Valid customer id",HttpStatus.OK); } return new ResponseEntity<>
	 * ("Invalid customer id",HttpStatus.NOT_FOUND); }
	 * 
	 * @DeleteMapping(path="/delete/{custid}") public ResponseEntity<?>
	 * deleteCustomer(@PathVariable int custid){ return new ResponseEntity<>
	 * ("Customer data deleted",HttpStatus.OK); }
	 */

}
