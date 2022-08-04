package br.com.carv.manager.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "tb_user")
public class User implements Serializable {
	
	private final static long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	@Column(nullable = false, length = 100)
	private String username;
	
	@Column(nullable = false, length = 255)
	private String password;
	
	@Column(nullable = false, length = 50)
	private String email;
	
	@JsonInclude(Include.NON_NULL)
	private String token;
	
	public User() {
		
	}
	
	public User(String username, String email) {
		this.username = username;
		this.email = email;
	}
	
	
	
	public User(Long id, String username, String password, String email, String token) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.token = token;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "[User]\nUsername: " + getUsername() + " Email: " + getEmail();
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
