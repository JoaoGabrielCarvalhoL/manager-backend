package br.com.carv.manager.entity.dto;

import br.com.carv.manager.entity.User;

public class UserDto {

	private Long id; 
	private String email; 
	private String username;
	
	public UserDto() {
		
	}
	
	public UserDto(String email, String username) {
		this.email = email; 
		this.username = username;
	}
	
	public UserDto(User user) {
		this.id = user.getId(); 
		this.email = user.getEmail();
		this.username = user.getUsername();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
