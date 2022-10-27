package com.springrestapi.springrestapi.entities;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class JwtRequest {

	@NotNull
//	@Pattern(regexp="[a-z]{6,12}", message = "Username must be between 6 to 12 characters. Must only contain lowercase characters.")
	String username;

//	@Pattern(regexp="[a-zA-Z0-9]{6,12}",message="Password must contain between 6 to 12 characters. Must be alphanumeric with both Upper and lowercase characters.")
	String password;

	public JwtRequest() {
	}

	public JwtRequest(String username, String password) {

		this.username = username;
		this.password = password;
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

	@Override
	public String toString() {
		return "JwtRequest{" + "username='" + username + '\'' + ", password='" + password + '\'' + '}';
	}
}
