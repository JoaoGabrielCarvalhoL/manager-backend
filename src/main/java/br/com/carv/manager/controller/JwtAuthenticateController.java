package br.com.carv.manager.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.carv.manager.entity.User;
import br.com.carv.manager.security.JwtUserDetailsService;
import br.com.carv.manager.security.JwtWebTokenUtil;
import br.com.carv.manager.security.request.JwtRequest;
import br.com.carv.manager.service.UserService;

@RestController
public class JwtAuthenticateController {

	private List<User> users;

	private final UserService userService;

	private JwtUserDetailsService detailsService;

	private JwtWebTokenUtil webTokenUtil;
	
	private AuthenticationManager authenticationManager;

	private String token;
	private Long id;

	public JwtAuthenticateController(UserService userService,
			JwtUserDetailsService detailsService, JwtWebTokenUtil webTokenUtil, AuthenticationManager authenticationManager) {
		this.userService = userService;
		users = new ArrayList<User>();
		this.detailsService = detailsService;
		this.webTokenUtil = webTokenUtil;
		this.authenticationManager = authenticationManager;	
	}

	@CrossOrigin
	@PostMapping("/login")
	public Optional<User> createAuthenticateToken(@RequestBody JwtRequest authenticateRequest) throws Exception{

		users = userService.findAllUsers();
		
		for (User u : users) {
			if (u.getUsername().equals(authenticateRequest.getUsername())) {
				
				authenticate(authenticateRequest.getUsername(), authenticateRequest.getPassword());
				
				final UserDetails userDetails = detailsService.loadUserByUsername(authenticateRequest.getUsername());
				
				this.token = webTokenUtil.generateToken(userDetails);
				this.id = u.getId();
			}
		}
		
		Optional<User> user = Optional.ofNullable(userService.findById(this.id));
		user.orElseThrow().setToken(token); 
		user.orElseThrow().setPassword("");
		return user;
		
	}
	
	private void authenticate(String username, String password) throws Exception {
		
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}

}
