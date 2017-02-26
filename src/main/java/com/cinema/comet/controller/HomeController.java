package com.cinema.comet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cinema.comet.domain.Movie;
import com.cinema.comet.domain.Reservation;
import com.cinema.comet.service.MovieService;

@Controller
public class HomeController {
	
	@Autowired
	private MovieService movieService;
	
	@RequestMapping("/")
	public String welcome (Model model){
		model.addAttribute("przywitanie", "Witaj na stronie internetowej kina Comet");
		List<Movie> filmlist = movieService.getAll();
		model.addAttribute("listafilmow", filmlist);
		
		List<String> list = movieService.getMoviesNames();
		model.addAttribute("typeOptions", list);
		
		model.addAttribute("reserve", new Reservation());
		
		List<String> pat = movieService.getMovieImages();
		model.addAttribute("paths", pat);
		
		return "welcome";
	}

}
