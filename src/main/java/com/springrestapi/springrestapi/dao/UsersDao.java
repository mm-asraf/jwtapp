package com.springrestapi.springrestapi.dao;



import java.util.Optional;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

import com.springrestapi.springrestapi.entities.Users;

public interface UsersDao extends JpaRepository<Users, Long> {

	

	public Optional<Users> findByUsername(String username);

	public Optional<Users> findByEmail(String email);

	public Optional<Users> findByMobile(String mobile);

	


}
