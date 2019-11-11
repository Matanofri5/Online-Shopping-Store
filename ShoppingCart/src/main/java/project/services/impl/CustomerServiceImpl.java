package project.services.impl;

import project.beans.Customer;
import project.beans.Products;

public interface CustomerServiceImpl {

	void setCustomer(Customer customer);

	Customer purchaseProduct(Products product) throws Exception;

	
}
