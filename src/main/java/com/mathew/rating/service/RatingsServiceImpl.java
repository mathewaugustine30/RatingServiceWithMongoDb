package com.mathew.rating.service;

import com.mathew.rating.entity.Rating;
import com.mathew.rating.exception.RatingNotFoundException;
import com.mathew.rating.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RatingsServiceImpl implements RatingsService{

    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public Rating save(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public Rating get(String id) {
        Optional<Rating> byId = Optional.ofNullable(ratingRepository.findById(id).orElseThrow(() -> new RatingNotFoundException("No Records Found Invalid RatingId: " + id)));
        return byId.get();
    }

    @Override
    public void delete(String id) {
        Optional<Rating> byId = Optional.ofNullable(ratingRepository.findById(id).orElseThrow(() -> new RatingNotFoundException("No Records Found Invalid RatingId: " + id)));
        ratingRepository.deleteById(id);
    }

    @Override
    public List<Rating> getAllRating() {
        return ratingRepository.findAll();
    }

    @Override
    public List<Rating> getAllRatingByUserId(String userId) {
        return ratingRepository.findByUserId(userId);
    }

    @Override
    public List<Rating> getAllRatingByHotelId(String hotelId) {
        return ratingRepository.findByHotelId(hotelId);
    }
}
