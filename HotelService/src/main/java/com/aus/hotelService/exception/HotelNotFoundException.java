package com.aus.hotelService.exception;

public class HotelNotFoundException extends RuntimeException{

	public HotelNotFoundException(String message){
		super(message);
	}
}
