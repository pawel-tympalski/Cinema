package com.cinema.comet.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cinema.comet.domain.Reservation;
import com.cinema.comet.repository.MovieDao;
import com.cinema.comet.service.ReservationService;
import com.cinema.comet.validators.ReservationValidator;

@Controller
public class ReservationController {
	
	@Autowired
	private ReservationService reservationService;
	
/*	@RequestMapping(value="/reserve", method=RequestMethod.POST)
	public String reserve(@ModelAttribute Reserve reserve){
		
		moviedao.addReserve(reserve);
		
		return "redirect:/";
		
	}
*/
	
	
	
	
	@RequestMapping(value="/reserve", method=RequestMethod.POST)
	public String addReservation(@Valid @ModelAttribute Reservation reservation, BindingResult binding,
			RedirectAttributes redirectAttribute) {

		if (binding.hasErrors()) {

			redirectAttribute.addFlashAttribute("org.springframework.validation.BindingResult.reserve", binding);
			redirectAttribute.addFlashAttribute("reserve", reservation);
			return "redirect:/";

		}

		reservationService.addReservation(reservation);
		redirectAttribute.addFlashAttribute("reserved", reservation);
		return "redirect:/potwierdzenierezerwacji";

	}
	
	@RequestMapping(value="/potwierdzenierezerwacji", method=RequestMethod.GET)
	public String submitReservation(){
		return "potwierdzenierezerwacji";
	}
	
	@RequestMapping(value="/getreserves", method=RequestMethod.GET)
	public String getReserves(Model model){
		List<Reservation> reservations = reservationService.getAllReservations();
		model.addAttribute("reserves", reservations);
		return "showreserves";
	}
	
	@RequestMapping(value="/deletereserve/{id}")
	public String deleteReserve(@PathVariable("id")int reservationId ){
		reservationService.deleteReservation(reservationId);
		return "redirect:/getreserves";
	}
	/*
	@InitBinder
	public void initBinder(WebDataBinder binder){
		
		binder.addValidators(new ReserveValidator());
		
		
	}
	*/
}
