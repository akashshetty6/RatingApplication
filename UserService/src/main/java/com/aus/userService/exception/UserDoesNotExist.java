package com.aus.userService.exception;

public class UserDoesNotExist extends RuntimeException {

	public UserDoesNotExist(String message) {
		super(message);
	}
}
