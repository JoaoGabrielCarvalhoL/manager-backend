package br.com.carv.manager.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.carv.manager.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query(value = "SELECT u FROM User u WHERE u.username LIKE %:username%")
	Page<User> findByUsername(String username, Pageable pageable);
	
	@Query(value = "SELECT u FROM User u WHERE u.email LIKE %:emaill%")
	Page<User> findByEmail(String email, Pageable pageable);

}
