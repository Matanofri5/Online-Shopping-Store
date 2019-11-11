package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import project.beans.Customer;
import project.beans.Products;
import project.services.impl.CustomerServiceImpl;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerServiceImpl customerServiceImpl;
	
	@PostMapping("/purchaseProduct")
	public ResponseEntity<String> purchaseProduct(@RequestBody Products p){
		try {
			customerServiceImpl.purchaseProduct(p);
			return new ResponseEntity<>("This customer buy " + p, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>("This customer cannot buy anymore, please settle your debt !!!!" , HttpStatus.UNAUTHORIZED);
		}
	}
}
