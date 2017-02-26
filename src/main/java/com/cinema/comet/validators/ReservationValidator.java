package com.cinema.comet.validators;

import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.cinema.comet.domain.Reservation;

public class ReservationValidator implements Validator  {

	public boolean supports(Class<?> clazz) {
		
		return Reservation.class.equals(clazz);
	}

	public void validate(Object obj, Errors errors) {
		
		Reservation reserve = (Reservation) obj;
		
		if (reserve.getName().length() < 2){
			errors.rejectValue("name", "reserve.toLow","Za ma³a liczba znakow");
		}
	}

}
