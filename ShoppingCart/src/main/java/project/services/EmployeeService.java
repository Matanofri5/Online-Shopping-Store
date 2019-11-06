package project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.beans.Customer;
import project.repository.CustomerRepository;
import project.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	
	
	public Customer CreateCustomer (Customer customer) {
		return customerRepository.save(customer);
	}
	
	
}
