package project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.LoginInterface;
import project.TwilioConfiguration;
import project.beans.Customer;
import project.beans.Products;
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
	private TwilioConfiguration twilio;
	
	private Customer customer;
	
	@Override
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	@Override
	public Customer purchaseProduct(long productId) throws Exception {
		if (customer.getBalance()<=0) {
			twilio.sendSMS();
		}
		if (customer.getBalance()<=-15.0) {
			throw new Exception("cannot buy anymore");
		}

		Products product = productsRepository.findById(productId).get();
		productsRepository.save(product);
		Customer customer = customerRepository.findById(this.customer.getId()).get();
		
		if (customer.getProducts().add(product)) {
			customer.setBalance(customer.getBalance()-product.getProductPrice());
		}
		customerRepository.save(customer);
		return customer;
	}

	
	
	
	
	
	
	
	
	
	
	@Override
	public LoginInterface login(String customerName, String password) {
		// TODO Auto-generated method stub
		return null;
	}
}
