package com.cinema.comet.repository;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cinema.comet.domain.Reservation;

@Repository
public class HbnReservationDao implements ReservationDao {
	
	
	private SessionFactory sessionFactory;

	@Autowired
	public HbnReservationDao(SessionFactory sessionFactory){
		
		this.sessionFactory = sessionFactory;
	}
	

	public void addReservation(Reservation reserve) {
		
		Session session = sessionFactory.openSession();
		session.save(reserve);
		session.close();
	}

	@SuppressWarnings("unchecked")
	public List<Reservation> getAllReservations() {
		
		Session session = sessionFactory.openSession();
		Query query =  session.createQuery("select r from Reservation r");
		List<Reservation> reserves = query.list();
		return reserves;
	}

	public void deleteReservation(int reserveId) {
		
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Reservation reserve =(Reservation) session.get(Reservation.class, reserveId);
		session.delete(reserve);
		transaction.commit();
		session.close();
	}

}
