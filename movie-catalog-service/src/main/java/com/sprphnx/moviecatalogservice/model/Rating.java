package com.sprphnx.moviecatalogservice.model;

public class Rating {

	String movieId;
	Integer rating;
	
	public Rating() {
		super();
	}

	public Rating(String movieId, Integer rating) {
		super();
		this.movieId = movieId;
		this.rating = rating;
	}

	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	
	
	
}
