package br.com.carv.manager.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.carv.manager.entity.Product;
import br.com.carv.manager.exception.NotFoundException;
import br.com.carv.manager.repository.ProductRepository;
import br.com.carv.manager.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	private final ProductRepository productRepository;
	
	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public Page<Product> findAll() {
		int size = 20; 
		int page = 0; 
		PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "productName");
		return new PageImpl<>(productRepository.findAll(), pageRequest, size);
	}

	@Override
	public void save(Product product) {
		productRepository.save(product);
	}

	@Override
	public void delete(Long id) {
		Optional<Product> product = productRepository.findById(id);
		if(product.isEmpty()) {
			throw new NotFoundException("Product not found! Id: " + id);
		}
		productRepository.delete(product.get());
	}

	@Override
	public void update(Product product) {
		save(product);
	}

	@Override
	public Product findById(Long id) {
		return productRepository.findById(id).orElseThrow(() -> new NotFoundException("Product not found! Id: " + id));
	}

	@Override
	public Page<Product> findByProductName(String productName) {
		int page = 0; 
		int size = 20;
		PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "productName"); 
		return productRepository.findByProductName(productName, pageRequest);
	}

	@Override
	public List<Product> findAllNoPageable() {
		return productRepository.findAll();
	}

}
