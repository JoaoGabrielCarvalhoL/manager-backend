package br.com.carv.manager.service;

import java.util.List;

import org.springframework.data.domain.Page;

import br.com.carv.manager.entity.Product;

public interface ProductService {

	Page<Product> findAll();

	void save(Product product);

	void delete(Long id);

	void update(Product product);

	Product findById(Long id);

	Page<Product> findByProductName(String productName);
	
	List<Product> findAllNoPageable();
}
