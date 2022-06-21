package br.com.carv.manager.service;

import org.springframework.data.domain.Page;

import br.com.carv.manager.entity.Category;

public interface CategoryService {

	Page<Category> findAll();
	
	void save(Category category); 
	
	void delete(Long id); 
	
	void update(Category category); 
	
	Category findById(Long id);
	
	Page<Category> findByDescription(String description);
}
