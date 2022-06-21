package br.com.carv.manager.service;

import org.springframework.data.domain.Page;

import br.com.carv.manager.entity.User;

public interface UserService {
	
	Page<User> findAll();

	void save(User user);

	void delete(Long id);

	void update(User user);

	User findById(Long id);

	Page<User> findByUsername(String username);
	
	Page<User> findByEmail(String email);

}
