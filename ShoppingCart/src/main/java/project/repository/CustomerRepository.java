package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import project.beans.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

	Customer findByFirstName(String firstName);
	
	Customer findByFirstNameAndPassword(String customerName, String password);
}
