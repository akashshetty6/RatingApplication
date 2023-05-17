package com.aus.userService.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.aus.userService.entity.Hotel;
import com.aus.userService.entity.Ratings;
import com.aus.userService.entity.User;
import com.aus.userService.exception.UserDoesNotExist;
import com.aus.userService.externalService.HotelService;
import com.aus.userService.repository.UserRepo;
import com.aus.userService.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	HotelService hotelService;
	
	@Autowired
	RestTemplate restTemplate;

	private String ratingURL="http://RATING-SERVICE/rating/";
	private String hotelURL="http://HOTEL-SERVICE/hotel/";

	@Override
	public User saveUser(User user) {
		String uId=UUID.randomUUID().toString();
		user.setUserId(uId);
		
		return userRepo.save(user);
		
	}

	@Override
	public User getUser(String userId) throws UserDoesNotExist {
		Optional<User> op= userRepo.findById(userId);
		if(op.isPresent()) {
			return op.get();
		}
		else {
			throw new UserDoesNotExist("user doesn't exist by this Id"+userId);
		}
				
	}

	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public User getRatingsByUserId(String userId) {
		User user=userRepo.findById(userId).orElseThrow(()->new UserDoesNotExist("User doesn't exist by this Id"+userId));
		
		
		Ratings[] r = restTemplate.getForObject(ratingURL+"user/"+userId, Ratings[].class);
		
		List<Ratings> ratings=Arrays.stream(r).toList();
		
		List<Ratings> collect = ratings.stream().map(rating -> {
			
			/*
				ResponseEntity<Hotel> entity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotel/"+rating.getHotelId(),Hotel.class);
				
				Hotel hotel=entity.getBody();
			*/
			
			Hotel hotel=hotelService.getHotel(rating.getHotelId());// Using feign client
			
				rating.setHotel(hotel);
				
				return rating;
			}).collect(Collectors.toList());
		
		
		user.setRating(collect);
		return user;
	}

}
