package com.springrestapi.springrestapi.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;




@Repository
public interface UserTokenRepo extends JpaRepository<com.springrestapi.springrestapi.entities.UserLoginToken, Integer>{

	
//	@Query(value = "select * from user_login_token where auth_token = ?1	",nativeQuery = true)
	public com.springrestapi.springrestapi.entities.UserLoginToken findByAuthToken(String token);

	public Optional<com.springrestapi.springrestapi.entities.UserLoginToken> findByUserId(long l);
	
}
