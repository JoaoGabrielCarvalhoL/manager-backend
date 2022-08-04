package br.com.carv.manager.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.carv.manager.entity.User;
import br.com.carv.manager.entity.dto.UserDto;
import br.com.carv.manager.exception.NotFoundException;
import br.com.carv.manager.repository.UserRepository;
import br.com.carv.manager.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	private PasswordEncoder encoder;

	public UserServiceImpl(UserRepository userRepository, PasswordEncoder encoder) {
		this.userRepository = userRepository;
		this.encoder = encoder;
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
		user.setPassword(encoder.encode(user.getPassword()));
		userRepository.save(user);
	}

	@Override
	public void delete(Long id) {
		Optional<User> user = userRepository.findById(id);
		if (user.isEmpty()) {
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

	@Override
	public List<User> findAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public PasswordEncoder getEncoder() {
		return encoder;
	}
	
	public List<UserDto> findAllUserDto() {
		return userRepository.findAll().stream().map(user -> new UserDto(user)).collect(Collectors.toList());
	}

	@Override
	public UserDto findByIdDto(Long id) {
		UserDto dto = new UserDto(findById(id));
		return dto;
	}


	
	

}
