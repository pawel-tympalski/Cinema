package com.cinema.comet.service;

import java.util.List;

import com.cinema.comet.domain.Movie;
import com.cinema.comet.domain.Path;

public interface MovieService {

	public List<Movie> getAll();
	
	public void addMovie(Movie movie);
	
	public List<String> getMoviesNames();
		
	public void addImage(Path path);
	
	public List<String> getMovieImages();
	
}
