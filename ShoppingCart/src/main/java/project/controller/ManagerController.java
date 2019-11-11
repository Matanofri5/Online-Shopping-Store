package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.bytebuddy.asm.Advice.Return;
import project.beans.Customer;
import project.beans.Products;
import project.repository.CustomerRepository;
import project.services.ManagerService;
import project.services.impl.ManagerServiceImpl;

@RestController
@RequestMapping("/manager")
public class ManagerController {

	@Autowired
	private ManagerServiceImpl managerService;
	
	@Autowired
	private CustomerRepository customerRepo;
	
	
	@PostMapping("/createCustomer")
	public ResponseEntity<String> createCustomer(@RequestBody Customer customer) throws Exception{
		try {
			customer = managerService.CreateCustomer(customer);
			return new ResponseEntity<>("Customer " + customer.getFirstName() +" has been created   " + customer,  HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>("This customer already exist, please try another name", HttpStatus.UNAUTHORIZED);
		}
		
	}

	
	
	@PostMapping("/updateCustomer")
	public ResponseEntity<String> updateCustomer(@RequestParam long id, @RequestParam String phoneNumber){
		Customer customer = null;
		customer = customerRepo.findById(id).get();
		if (customer!=null) {
			managerService.updateCustomer(customer, phoneNumber);
			return new ResponseEntity<>("update successfully customer " +customer.getFirstName() + "'s phone number = " +  customer.getPhoneNumber(),  HttpStatus.OK);
		}else {
			return new ResponseEntity<>("Failed to update customer phone number", HttpStatus.UNAUTHORIZED);
		}
	}
	
	
	
	@PostMapping("/createProduct")
	public ResponseEntity<Products> createProduct(@RequestBody Products products) throws Exception{
		products = managerService.createProduct(products);
		ResponseEntity<Products> result = new ResponseEntity<Products>(products, HttpStatus.OK);
		return result;
	}	
}
