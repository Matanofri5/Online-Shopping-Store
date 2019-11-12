package project.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.beans.Customer;
import project.beans.Products;
import project.exceptions.CustomerDoesntExist;
import project.exceptions.ProductNotExists;
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
	
	
	@Override
	public void updateProduct(Products product, double productPrice) {
		product.setProductPrice(productPrice);
		productsRepository.save(product);
	}
	
	@Override
	public void deleteCustomer(long customerId) throws CustomerDoesntExist {
	try {
		if (!customerRepository.existsById(customerId)) {
			throw new CustomerDoesntExist("This customer doesn't exist, please try another id");
		}
		long i = 0;
		Customer customer = customerRepository.getOne(customerId);
		List<Products> products = customer.getProducts();
		customerRepository.deleteById(customerId);
		for (i= 0; i < products.size(); i++) {
			productsRepository.delete(products.get((int) i));
		}
	} catch (Exception e) {
		System.out.println("Failed to delete customer " + customerId + e.getMessage());	}
	}
	
	
	@Override
	public Products productById(long id) {
		return productsRepository.findById(id).get();
	}
	
	@Override
	public List<Products> getAllProducts(){
		return productsRepository.findAll();
	}
	
	
	@Override
	public void deleteProduct(long productId) throws Exception {
		Products prodct = productsRepository.getOne(productId);
		if (prodct!=null) {
			productsRepository.delete(prodct);
		}else {
			throw new ProductNotExists("This coupon id doesn't exist in DataBase");

		}
	}
}
