package br.com.carv.manager.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.carv.manager.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
	
	@Query(value = "SELECT c FROM Category c WHERE c.description LIKE %:description%")
	Page<Category> findByDescription(String description, Pageable pageable);

}
