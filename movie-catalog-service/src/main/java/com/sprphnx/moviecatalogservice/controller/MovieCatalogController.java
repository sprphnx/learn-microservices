package com.sprphnx.moviecatalogservice.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sprphnx.moviecatalogservice.model.CatalogItem;
import com.sprphnx.moviecatalogservice.model.Movie;
import com.sprphnx.moviecatalogservice.model.UserRating;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/catalog")
@RequiredArgsConstructor
public class MovieCatalogController {

	private final RestTemplate restTemplate;
	
	@GetMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
		
		UserRating ratings =  restTemplate.getForObject("http://localhost:8083/ratingdata/users/"+userId, UserRating.class);
		
		return ratings.getUserRatings().stream()
					  .map(rating -> {
						  				Movie movie = restTemplate.getForObject("http://localhost:8082/movies/"+rating.getMovieId(), Movie.class);
						  				return new CatalogItem(movie.getName(), movie.getDesc(), rating.getRating());
					  				 }
						  )
					  .collect(Collectors.toList());
	}
	
}
