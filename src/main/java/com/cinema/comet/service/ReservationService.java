package com.cinema.comet.service;

import java.util.List;

import com.cinema.comet.domain.Reservation;

public interface ReservationService {
	
	public void addReservation(Reservation reservation);
	
	public List<Reservation> getAllReservations();
	
	public void deleteReservation(int reservationId);	
	
}
