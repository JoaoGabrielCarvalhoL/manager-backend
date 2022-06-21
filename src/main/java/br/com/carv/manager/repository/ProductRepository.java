package br.com.carv.manager.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.carv.manager.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
	@Query(value = "SELECT p FROM Product p WHERE p.productName LIKE %:productName%")
	Page<Product>findByProductName(String productName, Pageable pageable);

}
