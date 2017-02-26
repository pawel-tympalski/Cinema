package com.cinema.comet.repository;

import java.util.List;

import com.cinema.comet.domain.Reservation;

public interface ReservationDao {

	public void addReservation(Reservation reservation);
	
	public List<Reservation> getAllReservations();
	
	public void deleteReservation(int reservationId);
}
