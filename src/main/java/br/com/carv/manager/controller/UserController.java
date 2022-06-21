package br.com.carv.manager.controller;

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

import br.com.carv.manager.entity.User;
import br.com.carv.manager.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void save(@RequestBody User user ) {
		userService.save(user);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		userService.delete(id);
	}
	
	@PutMapping()
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@RequestBody User user) {
		userService.update(user);
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public Page<User> findAll() {
		return userService.findAll();
	}
	
	@GetMapping("/findByDescription")
	@ResponseStatus(HttpStatus.OK)
	public Page<User> findByUsername(@RequestParam("username") String username) {
		return userService.findByUsername(username);
	}
	
	@GetMapping("/findByEmail")
	@ResponseStatus(HttpStatus.OK)
	public Page<User> findByEmail(@RequestParam("email") String email) {
		return userService.findByUsername(email);
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public User findById(@PathVariable("id") Long id) {
		return userService.findById(id);
	}
}
