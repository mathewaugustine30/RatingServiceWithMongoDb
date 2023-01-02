package com.mathew.rating.service;

import com.mathew.rating.entity.Rating;

import java.util.List;

public interface RatingsService {

    public Rating save(Rating rating);
    public Rating get(String id);
    public void delete(String id);
    public List<Rating> getAllRating();
    public List<Rating> getAllRatingByUserId(String userId);
    public List<Rating> getAllRatingByHotelId(String hotelId);




}
