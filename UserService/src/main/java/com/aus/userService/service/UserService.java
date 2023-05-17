package com.aus.userService.service;

import java.util.List;

import com.aus.userService.entity.User;
import com.aus.userService.exception.UserDoesNotExist;

public interface UserService {
	
	//save user
	User saveUser(User user);
	//get user
	User getUser(String userId) throws UserDoesNotExist;
	//list all user
	List<User> getAllUsers();
	
	User getRatingsByUserId(String userId);
	

}
