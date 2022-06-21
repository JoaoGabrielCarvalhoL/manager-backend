package br.com.carv.manager.service.impl;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.carv.manager.entity.Category;
import br.com.carv.manager.exception.NotFoundException;
import br.com.carv.manager.repository.CategoryRepository;
import br.com.carv.manager.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	private final CategoryRepository categoryRepository;
	
	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
	@Override
	public Page<Category> findAll() {
		int page = 0; 
		int size = 10; 
		PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "description");
		return new PageImpl<>(categoryRepository.findAll(), pageRequest, size);
	}

	@Override
	public void save(Category category) {
		categoryRepository.save(category);
	}

	@Override
	public void delete(Long id) {
		Optional<Category> category = categoryRepository.findById(id);
		if (category.isEmpty()) {
			throw new NotFoundException("Category not found!");
		}
		categoryRepository.delete(category.get());
	}

	@Override
	public void update(Category category) {
		save(category);
	}

	@Override
	public Category findById(Long id) {
		Optional<Category> category = categoryRepository.findById(id);
		return category.orElseThrow(() -> new NotFoundException("Category not found! Id: " + id));
	}

	@Override
	public Page<Category> findByDescription(String description) {
		int page = 0; 
		int size = 10; 
		PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "description"); 
		return categoryRepository.findByDescription(description, pageRequest);
	}

}
