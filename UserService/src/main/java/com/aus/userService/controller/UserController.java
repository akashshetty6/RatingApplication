package com.aus.userService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aus.userService.entity.User;
import com.aus.userService.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<User> saveUser(@RequestBody User User){
		User user=userService.saveUser(User);
		return  ResponseEntity.status(HttpStatus.CREATED).body(user);
	}
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> allUsers= userService.getAllUsers();
		return ResponseEntity.ok(allUsers);
	}
	
	@GetMapping ("/{userId}")
	public ResponseEntity<User> getUser(@PathVariable String userId){
		User user =userService.getUser(userId);
		return ResponseEntity.ok(user);
	}
	
	@GetMapping("/rating/{userId}")
	public ResponseEntity<User> getRatings(@PathVariable String userId){
		User user = userService.getRatingsByUserId(userId);
		return ResponseEntity.ok(user);
	}
	
	
	
	
}
