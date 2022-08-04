package br.com.carv.manager.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.carv.manager.entity.User;
import br.com.carv.manager.service.UserService;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private UserService userService;
	
	private List<User> users = new ArrayList<User>();
	
	private String username; 
	private String password;	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		setUsers(userService.findAllUsers());
		
		for (User user : getUsers()) {
			if (user.getUsername().equals(username)) {
				this.setUsername(user.getUsername());
				this.setPassword(user.getPassword());
			}
		}
		
		return new org.springframework.security.core.userdetails.User(username, username, new ArrayList<>());
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
