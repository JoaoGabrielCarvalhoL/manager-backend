package br.com.carv.manager.service.impl;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.carv.manager.entity.User;
import br.com.carv.manager.exception.NotFoundException;
import br.com.carv.manager.repository.UserRepository;
import br.com.carv.manager.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	private final UserRepository userRepository; 
	
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public Page<User> findAll() {
		int page = 0; 
		int size = 20; 
		PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "username");
		return new PageImpl<>(userRepository.findAll(), pageRequest, size);
	}

	@Override
	public void save(User user) {
		userRepository.save(user);
	}

	@Override
	public void delete(Long id) {
		Optional<User> user = userRepository.findById(id);
		if(user.isEmpty()) {
			throw new NotFoundException("User not found! Id: " + id);
		}
		userRepository.delete(user.get());
	}

	@Override
	public void update(User user) {
		save(user);		
	}

	@Override
	public User findById(Long id) {
		return userRepository.findById(id).orElseThrow(() -> new NotFoundException("User not found!" + id));
	}

	@Override
	public Page<User> findByUsername(String username) {
		int page = 0; 
		int size = 20; 
		PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "username");
		return userRepository.findByUsername(username, pageRequest);
	}

	@Override
	public Page<User> findByEmail(String email) {
		int page = 0; 
		int size = 20; 
		PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "email");
		return userRepository.findByEmail(email, pageRequest);
	}

}
