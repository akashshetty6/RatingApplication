package com.aus.hotelService.controller;

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

import com.aus.hotelService.entity.Hotel;
import com.aus.hotelService.service.HotelService;

@RestController
@RequestMapping("/hotel")
public class HotelController {

	@Autowired
	private HotelService hotelService;
	
	@PostMapping
	public ResponseEntity<Hotel> saveHotel(@RequestBody Hotel hotel){
		Hotel h=hotelService.saveHotel(hotel);
		return ResponseEntity.status(HttpStatus.CREATED).body(h);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Hotel> getHotel(@PathVariable String id){
		Hotel hotel=hotelService.getHotel(id);
		return ResponseEntity.ok().body(hotel);
	}
	
	@GetMapping
	public ResponseEntity<List<Hotel>> getHotel(){
		List<Hotel> hotel=hotelService.getAllHotels();
		return ResponseEntity.ok().body(hotel);
	}
	
}
