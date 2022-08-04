package br.com.carv.manager.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.com.carv.manager.entity.User;
import br.com.carv.manager.entity.dto.UserDto;

public interface UserService {
	
	Page<User> findAll();

	void save(User user);

	void delete(Long id);

	void update(User user);

	User findById(Long id);
	
	UserDto findByIdDto(Long id);

	Page<User> findByUsername(String username);
	
	Page<User> findByEmail(String email);
	
	List<User> findAllUsers();
	
	PasswordEncoder getEncoder();
	
	List<UserDto> findAllUserDto();

}
