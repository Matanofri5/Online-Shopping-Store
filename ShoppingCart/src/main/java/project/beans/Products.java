package project.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Products {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long productId;
	
	private String productName;
	
	private double productPrice;
	
	@Enumerated(EnumType.STRING)
	private Category category;
	
	 
}
