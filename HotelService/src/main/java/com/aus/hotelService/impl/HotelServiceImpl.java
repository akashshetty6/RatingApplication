package com.aus.hotelService.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aus.hotelService.Repository.HotelRepo;
import com.aus.hotelService.entity.Hotel;
import com.aus.hotelService.exception.HotelNotFoundException;
import com.aus.hotelService.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService
{
	@Autowired
	private HotelRepo hotelRepo;

	@Override
	public Hotel saveHotel(Hotel hotel) {
		String id=UUID.randomUUID().toString();
		hotel.setId(id);
		
		return hotelRepo.save(hotel);
	}

	@Override
	public List<Hotel> getAllHotels() {
		
		return hotelRepo.findAll();
	}

	@Override
	public Hotel getHotel(String id) {
		return hotelRepo.findById(id).orElseThrow(()->new HotelNotFoundException("Hotel not found with this id "+id));
		
	}

	
}
