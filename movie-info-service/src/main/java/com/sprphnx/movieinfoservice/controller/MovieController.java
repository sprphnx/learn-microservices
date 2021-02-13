package com.sprphnx.movieinfoservice.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprphnx.movieinfoservice.model.Movie;

@RestController
@RequestMapping("/movies")
public class MovieController {

	@RequestMapping("/{movieId}")
	public Movie getMovieInfo(@PathVariable("movieId") String movieId) {
		
		List<Movie> movies = Arrays.asList(
				new Movie(movieId, "Transformers", "A movie where cars transform."),
				new Movie(movieId, "Top Gun", "A movie about navy pilots."),
				new Movie(movieId, "Titanic", "A movie about ship- Titanic."),
				new Movie(movieId, "Rambo", "An action movie.")
				);
		
		return movies.get(new Random().nextInt(3-0)+0);
	}

}
