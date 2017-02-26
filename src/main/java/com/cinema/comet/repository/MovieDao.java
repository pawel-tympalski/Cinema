package com.cinema.comet.repository;

import java.util.List;

import com.cinema.comet.domain.*;

public interface MovieDao {
	
	public List<Movie> getAll();
	
	public void addMovie(Movie movie);
	
	public List<String> getMoviesNames();
		
	public void addImage(Path path);
	
	public List<String> getMovieImages();

}
