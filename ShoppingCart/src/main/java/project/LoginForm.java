package project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import project.beans.Customer;
import project.repository.CustomerRepository;
import project.services.CustomerService;
import project.services.impl.CustomerServiceImpl;

@Service
public class LoginForm {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private ApplicationContext context;
	
	
	public LoginInterface login (String customerName, String password) throws Exception {
		Customer customer = customerRepository.findByFirstNameAndPassword(customerName, password);
		if (customer != null) {
			CustomerServiceImpl cust = context.getBean(CustomerService.class);
			cust.setCustomer(customer);
			return (LoginInterface) cust;
		}
		throw new Exception("Try to insert correct name/password again");
	}
}
