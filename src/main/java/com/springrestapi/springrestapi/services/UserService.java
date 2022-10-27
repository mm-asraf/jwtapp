package com.springrestapi.springrestapi.services;

import java.util.List;



import com.springrestapi.springrestapi.entities.Users;

public interface UserService {

	public List<Users> getUsers();
	
	public Users getUser(long userId);
	
	public Users addUser(Users user) throws Exception ;
	
	public Users updateUser(Users user);
	
	public void deleteUser(long parseLong);

	public Users authenticateUser(Users user);

	

	

	

	
}
