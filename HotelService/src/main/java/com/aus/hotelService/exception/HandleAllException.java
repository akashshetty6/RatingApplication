package com.aus.hotelService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.aus.hotelService.payload.ApiResponse;

@RestControllerAdvice
public class HandleAllException {

	@ExceptionHandler(HotelNotFoundException.class)
	public ResponseEntity<ApiResponse> handleHotelNotFoundException(HotelNotFoundException ex){
		String message=ex.getMessage();
		ApiResponse res=ApiResponse.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();
		return new ResponseEntity<ApiResponse>(res,HttpStatus.NOT_FOUND);
	}
}
