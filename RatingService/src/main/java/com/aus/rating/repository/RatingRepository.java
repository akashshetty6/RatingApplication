package com.aus.rating.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.aus.rating.entity.Rating;
@Repository
public interface RatingRepository extends MongoRepository<Rating, String> {

	List<Rating> findAllByUserId(String userId);

	List<Rating> findAllByHotelId(String hotelId);

}
