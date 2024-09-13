package com.kodbook.services;

import com.kodbook.entities.User;

public interface UserService {

	public void addUser(User usr);
	public boolean userExist(String username,String email);
	public boolean loginAuth(String username,String password);
}
