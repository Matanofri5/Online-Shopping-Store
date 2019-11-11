package project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.LoginInterface;
import project.beans.Customer;
import project.beans.Products;
import project.controller.TwilioController;
import project.repository.CustomerRepository;
import project.repository.ProductsRepository;
import project.services.impl.CustomerServiceImpl;

@Service
public class CustomerService implements CustomerServiceImpl, LoginInterface{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private ProductsRepository productsRepository;
	
	@Autowired
	private TwilioController twilioController;
	
	private Customer customer;
	
	@Override
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	@Override
	public Customer purchaseProduct(Products product) throws Exception {
		if (customer.getBalance()<=0) {
			twilioController.sendSMS();
		}
		if (productsRepository.save(product) != null) {
			customer.setBalance(customer.getBalance()-product.getProductPrice());
		}
		
		if (customer.getBalance()<=-15.0) {
			throw new Exception("cannot buy anymore");
		}
		customer.getProducts().add(product);
		return customerRepository.save(customer);
	}

	@Override
	public LoginInterface login(String customerName, String password) {
		// TODO Auto-generated method stub
		return null;
	}
}
