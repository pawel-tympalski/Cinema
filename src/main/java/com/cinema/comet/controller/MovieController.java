package com.cinema.comet.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cinema.comet.domain.Movie;
import com.cinema.comet.domain.Path;
import com.cinema.comet.service.MovieService;

@Controller
public class MovieController {

	@Autowired
	private MovieService movieService;

	@RequestMapping(value = "/form123", method = RequestMethod.GET)
	public String getFormMovie(Model model) {

		/*
		 * if (1==1){
		 * 
		 * throw new RuntimeException("There was an error"); }
		 */

		model.addAttribute("movie", new Movie());
		Set<String> setHours = new HashSet<String>();
		String hour1 = "16:00";
		String hour2 = "17:00";
		String hour3 = "18:00";
		String hour4 = "19:00";

		setHours.add(hour1);
		setHours.add(hour2);
		setHours.add(hour3);
		setHours.add(hour4);

		model.addAttribute("MOVIEHOURS", setHours);

		return "movieform";
	}

	@RequestMapping(value = "/form123/save", method = RequestMethod.POST)
	public String addMovie(@ModelAttribute Movie movie) {

		movieService.addMovie(movie);
		System.out.println(movie.getHours());

		return "redirect:/";

	}

	// to zadzia³a na poziomie kontorlera jesli bede mia³ zmienna czesc url -
	// reserve/{id} i to wyjdzie poza zakres
	/*
	 * @ExceptionHandler(Exception.class) public ModelAndView
	 * errorHandler(HttpServletRequest req, Exception exception ){
	 * 
	 * ModelAndView mav = new ModelAndView(); mav.addObject("exception",
	 * exception); mav.addObject("url", req.getRequestURI());
	 * mav.setViewName("product/error");
	 * 
	 * return mav; }
	 */

	/*
	 * @ExceptionHandler(NullPointerException.class) public String
	 * errorHandler(HttpServletRequest req, Exception exception ){
	 * 
	 * 
	 * 
	 * return "error"; }
	 */

	@RequestMapping(value = "/addimage", method = RequestMethod.POST)
	public String add(@RequestParam("file") MultipartFile file, HttpServletRequest request) {

		System.out.println(file.getSize());

		String rootDirectory = request.getSession().getServletContext().getRealPath("/");

		File f12 = new File(rootDirectory + "resources\\images\\" + file.getOriginalFilename());

		try {
			file.transferTo(f12);
			String path = "/resources/images/" + file.getOriginalFilename();

			Path path1 = new Path();
			path1.setPartPath(path);

			movieService.addImage(path1);

		} catch (IllegalStateException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}

		System.out.println(file.getOriginalFilename());
		System.out.println(rootDirectory);
		System.out.println("File is saved");

		return "redirect:/form123";
	}

}
