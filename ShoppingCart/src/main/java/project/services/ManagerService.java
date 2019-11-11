package project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.beans.Customer;
import project.beans.Products;
import project.exceptions.CustomerDoesntExist;
import project.repository.CustomerRepository;
import project.repository.ProductsRepository;
import project.services.impl.ManagerServiceImpl;

@Service
public class ManagerService implements ManagerServiceImpl{

	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private ProductsRepository productsRepository;
	
	
	public boolean checkIfCustomerAlreadyExist(String customerName) {
		if (customerRepository.findByFirstName(customerName)!=null) {
			return true;
		}
		return false;
	}
	
	@Override
	public Customer CreateCustomer (Customer customer) throws Exception {
		if (checkIfCustomerAlreadyExist(customer.getFirstName())==false) {
			customerRepository.save(customer);
		}else {
			throw new Exception("This customer already exist, please try another name");
		}
		return customer;
	}
	
	
	@Override
	public void updateCustomer(Customer customer, String phoneNumber) {
		customer.setPhoneNumber(phoneNumber);
		customerRepository.save(customer);
	}
	
	@Override
	public void deleteCustomerName(String customerName) throws CustomerDoesntExist {
		customerRepository.findByFirstName(customerName);
		if (customerName==null) {
			throw new CustomerDoesntExist("This customer doesn't exist");
		}
	}
	
	
	public Customer customerById(long id) {
		return customerRepository.findById(id).get();
	}
	
	@Override
	public List<Customer> getAllCustomers(){
		return customerRepository.findAll();
	}
	
	@Override
	public Products createProduct(Products products) {
		return productsRepository.save(products);
	}
	
}
