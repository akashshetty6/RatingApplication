package com.aus.hotelService.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aus.hotelService.entity.Hotel;

public interface HotelService {

	//create
	Hotel saveHotel(Hotel hotel); 
	
	//get all
	List<Hotel> getAllHotels();
	//get one
	Hotel getHotel(String id);
}
