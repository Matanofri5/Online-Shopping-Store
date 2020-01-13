package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.services.impl.CustomerServiceImpl;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerServiceImpl customerServiceImpl;
	
	
	@PostMapping("/purchaseProduct/{productId}")
	public ResponseEntity<String> purchaseProduct(@PathVariable long productId){
		try {
			customerServiceImpl.purchaseProduct(productId);
			return new ResponseEntity<>("Customer purchase completed", HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>("Hi, you're exceeded from your balance, please settle your debt !!   " +e.getMessage(), HttpStatus.UNAUTHORIZED);
		}
	}
}
