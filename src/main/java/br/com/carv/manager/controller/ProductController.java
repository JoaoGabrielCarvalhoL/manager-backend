package br.com.carv.manager.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.carv.manager.entity.Product;
import br.com.carv.manager.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	private ProductService productService; 
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void save(@RequestBody Product product ) {
		productService.save(product);
	}
	
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		productService.delete(id);
	}
	
	@PutMapping()
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@RequestBody Product product) {
		productService.update(product);
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public Page<Product> findAll() {
		return productService.findAll();
	}
	
	@GetMapping("/findByProductName")
	@ResponseStatus(HttpStatus.OK)
	public Page<Product> findByProductName(@RequestParam("productName") String productName) {
		return productService.findByProductName(productName);
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Product findById(@PathVariable("id") Long id) {
		return productService.findById(id);
	}
	
	@GetMapping("/findAll")
	@ResponseStatus(HttpStatus.OK)
	public List<Product> findAllNoPageable() {
		return productService.findAllNoPageable();
	}


}
