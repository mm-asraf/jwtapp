package com.springrestapi.springrestapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



@Repository
public interface ResponseRepository extends JpaRepository<com.springrestapi.springrestapi.entities.ResponseMessage, Integer>{

	
	@Query(value= "SELECT response_message FROM loginapp.response_message where response_code=?1", nativeQuery= true)
	public String fetchMessage(String responseCode);
	
}
