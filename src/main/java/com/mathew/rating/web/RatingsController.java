package com.mathew.rating.web;


import com.mathew.rating.entity.Rating;
import com.mathew.rating.service.RatingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ratings")
public class RatingsController {

    @Autowired
    private RatingsService ratingService;

    @PostMapping
    public ResponseEntity<Rating> createStudent(@RequestBody Rating rating) {
        Rating createResponse = ratingService.save(rating);
        return new ResponseEntity<>(createResponse, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rating> getUser(@PathVariable String id) {
        Rating getResponse = ratingService.get(id);
        return new ResponseEntity<>(getResponse, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable String id) {
        ratingService.delete(id);
        return "Record deleted succesfully";
    }

    @GetMapping("/all")
    public ResponseEntity<List<Rating>> getUsers() {
        List<Rating> getAllResponse = ratingService.getAllRating();
        return new ResponseEntity<>(getAllResponse, HttpStatus.ACCEPTED);
    }
    @GetMapping("/all/byHotelId/{hotelId}")
    public ResponseEntity<List<Rating>> getAllRatingByHotelId(@PathVariable String hotelId) {
        List<Rating> getAllResponse = ratingService.getAllRatingByHotelId(hotelId);
        return new ResponseEntity<>(getAllResponse, HttpStatus.ACCEPTED);
    }
    @GetMapping("/all/byUserId/{userId}")
    public ResponseEntity<List<Rating>> getAllRatingByUserId(@PathVariable String userId) {
        List<Rating> getAllResponse = ratingService.getAllRatingByUserId(userId);
        return new ResponseEntity<>(getAllResponse, HttpStatus.ACCEPTED);
    }
}
