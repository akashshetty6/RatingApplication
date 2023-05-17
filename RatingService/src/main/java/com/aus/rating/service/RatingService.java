package com.aus.rating.service;

import java.util.List;

import com.aus.rating.entity.Rating;

public interface RatingService {

	//create
	Rating createRating(Rating rating);
	
	//get all ratings
	List<Rating> getAllRatigs();
	
	//get all ratings by userid
	List<Rating> getAllRatingsByUserId(String userId);
	
	//get all ratings hotelid
	List<Rating> getAllRatingsByHotelId(String hotelId);
}

