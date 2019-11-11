package project.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(name = "CUSTOMER")
@Data
@NoArgsConstructor
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String firstName;
	
	private String lastName;
	
	private String password;
	
	private String phoneNumber;
		
	private double balance;
	
	@OneToMany(cascade= CascadeType.ALL)
	private List<Products> products;

	public Customer(long id, String firstName, String lastName, String phoneNumber, double balance,
			List<Products> products) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.balance = balance;
		this.products = products;
	}
	
	
	

}
