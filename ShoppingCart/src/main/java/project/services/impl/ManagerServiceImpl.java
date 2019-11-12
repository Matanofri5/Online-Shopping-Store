package project.services.impl;

import java.util.List;

import project.beans.Customer;
import project.beans.Products;
import project.exceptions.CustomerDoesntExist;

public interface ManagerServiceImpl {

	Customer CreateCustomer(Customer customer) throws Exception;

	void updateCustomer(Customer customer, String phoneNumber);

	Customer customerById(long id);
	
	List<Customer> getAllCustomers();

	Products createProduct(Products products);

	List<Products> getAllProducts();

	void updateProduct(Products product, double productPrice);

	void deleteCustomer(long customerId) throws CustomerDoesntExist;

	void deleteProduct(long productId) throws Exception;

	Products productById(long id);

	

}
