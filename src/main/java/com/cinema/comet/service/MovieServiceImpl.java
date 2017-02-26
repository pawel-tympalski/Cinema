package com.cinema.comet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema.comet.domain.Movie;
import com.cinema.comet.domain.Path;
import com.cinema.comet.repository.MovieDao;

@Service
public class MovieServiceImpl implements MovieService {
	
	MovieDao movieDao;
	
	@Autowired
	public MovieServiceImpl(MovieDao movieDao) {
		
		this.movieDao = movieDao;
	}

	public List<Movie> getAll() {
		
		return movieDao.getAll();
	}

	public void addMovie(Movie movie) {
		
		movieDao.addMovie(movie);
	}

	public List<String> getMoviesNames() {
	
		return movieDao.getMoviesNames();
	}

	public void addImage(Path path) {
		
		movieDao.addImage(path);
	}

	public List<String> getMovieImages() {
		
		return movieDao.getMovieImages();
	}

}
