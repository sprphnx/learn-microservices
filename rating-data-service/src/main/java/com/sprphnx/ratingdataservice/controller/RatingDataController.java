package com.sprphnx.ratingdataservice.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprphnx.ratingdataservice.model.Rating;
import com.sprphnx.ratingdataservice.model.UserRating;

@RestController
@RequestMapping("/ratingdata")
public class RatingDataController {

	@GetMapping("/{movieId}")	
	public Rating getRating(@PathVariable("movieId") String movieId) {
		return new Rating(movieId,4);
	}
	
	@GetMapping("/users/{userId}")
	public UserRating getUserRating(@PathVariable("userId") String userId) {
		List<Rating> ratings =  Arrays.asList(new Rating("101", new Random().nextInt(5-1)+1), 
				  							  new Rating("102", new Random().nextInt(5-1)+1));
		return new UserRating(ratings);
	}
	
}
