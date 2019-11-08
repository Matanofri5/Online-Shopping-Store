package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.beans.Customer;
import project.services.CustomerService;
import project.services.impl.CustomerServiceImpl;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerServiceImpl customerService;
	
	
	
	@PostMapping("/createCustomer")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
		customer = customerService.CreateCustomer(customer);
		ResponseEntity<Customer> result = new ResponseEntity<Customer>(customer,HttpStatus.OK);
		return result;
	}
}
