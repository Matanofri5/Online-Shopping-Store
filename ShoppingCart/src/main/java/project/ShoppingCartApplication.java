package project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import project.beans.CustomerReceipt;
import project.repository.CustomerReceiptRepository;

@SpringBootApplication
@SpringBootConfiguration
@ComponentScan({ "project" })
public class ShoppingCartApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ShoppingCartApplication.class, args);
		System.out.println("Starting ShoppingCart Application !!!!!!");

	}

}
