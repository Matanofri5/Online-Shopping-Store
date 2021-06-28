package project.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import project.beans.Customer;
import project.beans.Products;
import project.repository.CustomerRepository;
import project.repository.ProductsRepository;
import project.services.impl.ManagerServiceImpl;

@RestController
@RequestMapping("/manager")
public class ManagerController {
	
	@Autowired
	private ManagerServiceImpl managerService;

	@Autowired
	private CustomerRepository customerRepo;

	@Autowired
	private ProductsRepository productsRepo;

	@PostMapping("/createCustomer")
	public ResponseEntity<String> createCustomer(@RequestBody Customer customer) throws Exception {
		try {
			customer = managerService.CreateCustomer(customer);
			return new ResponseEntity<>("Customer " + customer.getFirstName() + " has been created   " + customer,
					HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>("This customer already exist, please try another name",
					HttpStatus.UNAUTHORIZED);
		}

	}

	@PostMapping("/updateCustomer")
	public ResponseEntity<String> updateCustomer(@RequestParam long id, @RequestParam String phoneNumber) {
		Customer customer = null;
		customer = customerRepo.findById(id).get();
		if (customer != null) {
			managerService.updateCustomer(customer, phoneNumber);
			return new ResponseEntity<>("update successfully customer " + customer.getFirstName() + "'s phone number = "
					+ customer.getPhoneNumber(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Failed to update customer phone number", HttpStatus.UNAUTHORIZED);
		}
	}

	@GetMapping("/getAllCustomers")
	public ResponseEntity<List<Customer>> allCustomers() {
		ResponseEntity<List<Customer>> result = new ResponseEntity<List<Customer>>(managerService.getAllCustomers(),
				HttpStatus.OK);
		return result;
	}

	@PostMapping("/createProduct")
	public ResponseEntity<Products> createProduct(@RequestBody Products products) throws Exception {
		products = managerService.createProduct(products);
		ResponseEntity<Products> result = new ResponseEntity<Products>(products, HttpStatus.OK);
		return result;
	}

	@PostMapping("/updateProduct")
	public ResponseEntity<String> updateProduct(@RequestParam long id, @RequestParam double productPrice) {
		Products products = null;
		products = productsRepo.findById(id).get();
		if (products != null) {
			managerService.updateProduct(products, productPrice);
			return new ResponseEntity<>("update successfully product " + products.getProductName(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Failed to update this product ", HttpStatus.UNAUTHORIZED);
		}
	}

	@GetMapping("/getAllProducts")
	public ResponseEntity<List<Products>> allProducts() {
		ResponseEntity<List<Products>> result = new ResponseEntity<List<Products>>(managerService.getAllProducts(),
				HttpStatus.OK);
		return result;
	}

	@DeleteMapping("/deleteCustomer/{customerId}")
	public ResponseEntity<String> deleteCustomer(@PathVariable long customerId) {
		try {
			Customer customer = null;
			customer = managerService.customerById(customerId);
			if (customer != null) {
				managerService.deleteCustomer(customerId);
				return new ResponseEntity<>("Successfully deleted customer " + customer.getFirstName(), HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>("Failed to delete customer ", HttpStatus.UNAUTHORIZED);
		}
		return null;
	}

	@DeleteMapping("/deleteProduct/{productId}")
	public ResponseEntity<String> deleteProduct(@PathVariable long productId) {
		try {
			Products product = null;
			product = productsRepo.findById(productId).get();
			if (product != null) {
				managerService.deleteProduct(productId);
				return new ResponseEntity<>("Successfully deleted product " + product.getProductName(), HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>("Failed to delete product ", HttpStatus.UNAUTHORIZED);
		}
		return null;
	}

	@GetMapping("/getCustomerById/{customerId}")
	public Customer customerById(@PathVariable long customerId) {
		return managerService.customerById(customerId);
	}
	
	@GetMapping("/getProductById/{productId}")
	public Products productById(@PathVariable long productId) {
		return managerService.productById(productId);
	}
}
