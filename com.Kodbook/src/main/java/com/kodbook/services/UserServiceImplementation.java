package com.kodbook.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodbook.entities.User;
import com.kodbook.repositories.UserRepository;

@Service
public class UserServiceImplementation implements UserService {

	@Autowired
	UserRepository repo;

	public UserServiceImplementation(UserRepository repo) {
		super();
		this.repo = repo;
	}

	@Override
	public void addUser(User usr) {
		repo.save(usr);
	}

	@Override
	public boolean userExist(String username,String email) {
		User usr1 = repo.findByusername(username);
		User usr2 = repo.findByEmail(email);
		if(usr1 != null || usr2 != null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean loginAuth(String username, String password) {
		User usr1 = repo.findByusername(username);
		if(usr1 != null) {
			String db_password = usr1.getPassword();
			if(db_password.equals(password)) {
				return true;
			}
		}
		return false;
	}
	
	
}
