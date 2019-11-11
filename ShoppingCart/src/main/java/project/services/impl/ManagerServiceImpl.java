package project.services.impl;

import java.util.List;

import project.beans.Customer;
import project.beans.Products;
import project.exceptions.CustomerDoesntExist;

public interface ManagerServiceImpl {

	Customer CreateCustomer(Customer customer) throws Exception;

	void updateCustomer(Customer customer, String phoneNumber);

	void deleteCustomerName(String customerName) throws CustomerDoesntExist;

	List<Customer> getAllCustomers();

	Products createProduct(Products products);

}
