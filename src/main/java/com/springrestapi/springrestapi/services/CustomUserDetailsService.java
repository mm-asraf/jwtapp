package com.springrestapi.springrestapi.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import com.springrestapi.springrestapi.dao.UsersDao;
import com.springrestapi.springrestapi.entities.CustomUserDetails;

import com.springrestapi.springrestapi.entities.Users;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UsersDao userRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

//		 User user = this.userRepository.findByUsername(userName);
		 Optional<Users> user = userRepository.findByUsername(userName);

		if (user == null) {
			throw new UsernameNotFoundException("User not found !!");
		} else {
			Users a = user.get();
			return new CustomUserDetails(a);
		}

		// user database `

//        if (userName.equals("Durgesh")) {
//            return new User("Durgesh", "Durgesh123", new ArrayList<>());
//        } else {
//            throw new UsernameNotFoundException("User not found !!");
//        }

	}
}
