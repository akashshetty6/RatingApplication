package com.aus.rating.impl;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.aus.rating.entity.Rating;
import com.aus.rating.repository.RatingRepository;
import com.aus.rating.service.RatingService;
@Service
public class RatingServiceImpl implements RatingService {
	
	@Autowired
	private RatingRepository ratingRepo;
	

	@Override
	public Rating createRating(Rating rating) {
		return ratingRepo.save(rating);
	}

	@Override
	public List<Rating> getAllRatigs() {
		
		return ratingRepo.findAll();
	}

	@Override
	public List<Rating> getAllRatingsByUserId(String userId) {
		
		return ratingRepo.findAllByUserId(userId);
	}

	@Override
	public List<Rating> getAllRatingsByHotelId(String hotelId) {
		
		return ratingRepo.findAllByHotelId(hotelId);
	}

	

}
