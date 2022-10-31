package com.springrestapi.springrestapi.entities;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.UniqueElements;



@Entity
public class Users {
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@NotNull
	@Size(min = 3,message = "min character should be 3")
	@Pattern(regexp="[a-z]{3,12}", message = "First Name must not contains numbers or special characters")
	private String firstname;
	
	
	@NotNull
	@Size(min = 3,message = "min character should be 3")
	@Pattern(regexp="[a-z]{3,12}", message = "Last Name must not contains numbers or special characters")
	private String lastname;
	
	
	@NotNull
	@Size(min = 6,message = "min character should be 3")
	@Column(unique=true)
	@Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$",message = "email should not contain special character but valid email style will be fine")
	private String email;
	
	@NotNull
	@Column(unique=true)
	@Size(min=10,max=10,message="mobile number should be 10 charecter")
	@Pattern(regexp ="(0/91)?[7-9][0-9]{9}",message="Enter valid Mobile Number")
	private String mobile;
	
	
	@NotNull
	@Pattern(regexp = "^[a-zA-Z0-9]{6,12}$",message = "username must be of 6 to 12 length with no special characters") 
	private String username;
	
	@NotNull
	@Size(min=6,message="password must contain atlest 6 charecters")
	private String password;
//	@Pattern(regexp="[a-zA-Z0-9]{6,12}",message="Password must contain between 6 to 12 characters. Must be alphanumeric with both Upper and lowercase characters.")
	

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Users(long id,
			@NotNull @Size(min = 3, message = "min character should be 3") @Pattern(regexp = "[a-z]{3,12}", message = "First Name must not contains numbers or special characters") String firstname,
			@NotNull @Size(min = 3, message = "min character should be 3") @Pattern(regexp = "[a-z]{3,12}", message = "Last Name must not contains numbers or special characters") String lastname,
			@NotNull @Size(min = 6, message = "min character should be 3") @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "email should not contain special character but valid email style will be fine") String email,
			@NotNull @Pattern(regexp = "[0-9]{10}", message = "Mobile number must have 10 digits") String mobile,
			@NotNull @Pattern(regexp = "^[a-zA-Z0-9]{6,12}$", message = "username must be of 6 to 12 length with no special characters") String username,
			@NotNull @Size(min=6,max=15,message="password must contain atlest 6 charecters") String password) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.mobile = mobile;
		this.username = username;
		this.password = password;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
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
		return "Users [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", mobile=" + mobile + ", username=" + username + ", password=" + password + "]";
	}

	
	
	
	
	
	



}