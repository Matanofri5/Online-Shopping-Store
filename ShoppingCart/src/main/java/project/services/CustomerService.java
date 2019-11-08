package project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.beans.Customer;
import project.repository.CustomerRepository;
import project.services.impl.CustomerServiceImpl;

@Service
public class CustomerService implements CustomerServiceImpl{

	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public Customer CreateCustomer (Customer customer) {
		return customerRepository.save(customer);
	}
	
	
}
