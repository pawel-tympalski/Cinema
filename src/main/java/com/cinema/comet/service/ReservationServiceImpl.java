package com.cinema.comet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema.comet.domain.Reservation;
import com.cinema.comet.repository.ReservationDao;

@Service
public class ReservationServiceImpl implements ReservationService{
	
	
	ReservationDao reservationDao;
	
	@Autowired
	public ReservationServiceImpl(ReservationDao reservationDao){
		this.reservationDao = reservationDao;
	}

	public void addReservation(Reservation reservation) {
		
		reservationDao.addReservation(reservation);
	}

	public List<Reservation> getAllReservations() {
	
		return reservationDao.getAllReservations();
	}

	public void deleteReservation(int reservationId) {
	
		reservationDao.deleteReservation(reservationId);
		
	}

	
}
