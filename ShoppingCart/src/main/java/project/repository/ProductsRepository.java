package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import project.beans.Products;

public interface ProductsRepository extends JpaRepository<Products, Long>{

	Products findByproductPriceLessThan (double productPrice);
	
}
