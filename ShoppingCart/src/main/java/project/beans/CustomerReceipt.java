package project.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class CustomerReceipt {

//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private long receiptNumber;
	
	private String customerName;

	private String product;

	private String purchaseDate;

	private double price;

}
