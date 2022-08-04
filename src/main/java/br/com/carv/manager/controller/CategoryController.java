package br.com.carv.manager.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
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

import br.com.carv.manager.entity.Category;
import br.com.carv.manager.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
	
	private final CategoryService categoryService;
	
	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void save(@RequestBody Category category ) {
		categoryService.save(category);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		categoryService.delete(id);
	}
	
	@PutMapping()
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@RequestBody Category category) {
		categoryService.update(category);
	}
	
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public Page<Category> findAll() {
		return categoryService.findAll();
	}
	
	@GetMapping("/findByDescription")
	@ResponseStatus(HttpStatus.OK)
	public Page<Category> findByDescription(@RequestParam("description") String description) {
		return categoryService.findByDescription(description);
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Category findById(@PathVariable("id") Long id) {
		return categoryService.findById(id);
	}
	
	@GetMapping("/findAll")
	@ResponseStatus(HttpStatus.OK)
	public List<Category> findAllNoPageable() {
		return categoryService.findAllNoPageable();
	}

}
