package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import project.LoginForm;
import project.LoginInterface;

@RestController
@RequestMapping("/Login")
public class LoginController {

	@Autowired
	private LoginForm loginForm;
	
	
	
	@PostMapping("/login")
	public ResponseEntity<String> login (@RequestParam String customerName, @RequestParam String password){
		
		LoginInterface customerLogin = null;
		
		try {
			customerLogin = loginForm.login(customerName, password);
			return new ResponseEntity<>(customerName + " have loggen in to system" , HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
		}
	}
}
