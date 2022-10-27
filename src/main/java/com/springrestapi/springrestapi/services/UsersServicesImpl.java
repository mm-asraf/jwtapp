package com.springrestapi.springrestapi.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.springrestapi.springrestapi.dao.UsersDao;
import com.springrestapi.springrestapi.entities.Users;
import com.springrestapi.springrestapi.exception.UserNotFoundException;


@Service
@Transactional
public class UsersServicesImpl implements UserService {

//	List<Users> list;

	@Autowired
	private UsersDao usersDao;

	
	
	public UsersServicesImpl() {

	}
	
	

	@Override
	public List<Users> getUsers() {

		return usersDao.findAll();

	}

	
	@Override
	public Users getUser(long userId) {

		return usersDao.findById(userId).get();

	}

	public Users authenticateUser(Users user) throws com.springrestapi.springrestapi.exception.UserNotFoundException {

//	    Optional<Users> opUser = usersDao.findByUsername(user.getUsername());
		Optional<Users> opUser = usersDao.findByUsername(user.getUsername());

		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
		if (opUser.isPresent()) {

			Users dbUser = opUser.get();
			if (bcrypt.matches(user.getPassword(), dbUser.getPassword())) {

				return dbUser;
			} 

		}
		throw new UserNotFoundException("No user is  found for this username!!!");

	}

	@Override
	public Users addUser(Users user) throws com.springrestapi.springrestapi.exception.UserNotFoundException {

		  Optional<Users> userName = usersDao.findByUsername(user.getUsername());
		  Optional<Users> userEmail = usersDao.findByEmail(user.getEmail());
		  Optional<Users> userMob = usersDao.findByMobile(user.getMobile());
		  
		  
		  if(userName.isPresent() || userEmail.isPresent() || userMob.isPresent()) {
			 throw new UserNotFoundException("user already exist");
			 
		  }

		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
		String encryptedPw = bcrypt.encode(user.getPassword());
		user.setPassword(encryptedPw);
		Users saveUser = usersDao.save(user);
		System.out.println(saveUser);
		return saveUser;

	}

//	@Override
	public Users updateUser(Users user) {

//		list.forEach(e -> {
//			if(e.getId() == user.getId()) {
//				e.setName(user.getName());
//				e.setDesignation(user.getDesignation());
//			}
//		});
//		
//		return user;

		usersDao.save(user);
		return user;
	}

	@Override
	public void deleteUser(long parseLong) {

//		list = this.list.stream().filter(e-> e.getId() != parseLong).collect(Collectors.toList());

		@SuppressWarnings("deprecation")
		Users entity = usersDao.getOne(parseLong);
		usersDao.delete(entity);
	}

}
