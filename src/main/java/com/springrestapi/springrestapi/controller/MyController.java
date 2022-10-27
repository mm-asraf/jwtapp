package com.springrestapi.springrestapi.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.springrestapi.springrestapi.entities.Users;
import com.springrestapi.springrestapi.exception.UserNotFoundException;
//import com.springrestapi.springrestapi.exceptions.UserNotFoundException;
import com.springrestapi.springrestapi.services.UserService;

@RestController
public class MyController {
	
	@Autowired
	private UserService userService;
	
	
	
	//get the users
	@GetMapping("/users")
	public List<Users> getUsers() {
		return this.userService.getUsers();
	}
	
//	@GetMapping("/users/{userId}")
//	public Users getUsers( @PathVariable String userId) {
//		
//		
//		
//		Users u = this.userService.getUser(Long.parseLong(userId));
//		System.out.println(u);
//		return u;
//	}
	
	
	@GetMapping("/users/{userId}")
	public  ResponseEntity<Users>  getUsers( @PathVariable String userId) {
		
		try {
			Users u = this.userService.getUser(Long.parseLong(userId));
			System.out.println(u);
			return new ResponseEntity<Users>(u,HttpStatus.ACCEPTED);
			
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		

	}
	

	
	@PostMapping("/users")
	public  ResponseEntity<Users> addUser(@Valid @RequestBody Users user) throws Exception,UserNotFoundException{
		    
		try {
			Users savedUser = userService.addUser(user);
			return new ResponseEntity<Users>(savedUser,HttpStatus.CREATED);
		} catch (UserNotFoundException e) {
		
			throw new UserNotFoundException("user already exists with these fields");
		}
	    
	    
	}
	
	@PostMapping("/authenticateUser")
	public Users authenticateUser(@RequestBody Users user) throws UserNotFoundException {
		
		try {
			return userService.authenticateUser(user);
			
		} catch (UserNotFoundException e) {
			throw new UserNotFoundException("username or password is not matched");
		}
		
	}
	
	
	
	@PutMapping("/users")
	public Users updateUser(@Valid @RequestBody Users user) {
		return this.userService.updateUser(user);
	}
	
	
	@DeleteMapping("/users/{userId}")
	public  ResponseEntity<HttpStatus> deleteUser(@PathVariable String userId) {
		try {
			this.userService.deleteUser(Long.parseLong(userId));
			return new ResponseEntity<>(HttpStatus.OK);
			
		}catch(UserNotFoundException e) {
			throw new UserNotFoundException(e.getMessage());
		}
	}

}
