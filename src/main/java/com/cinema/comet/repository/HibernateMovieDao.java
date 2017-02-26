package com.cinema.comet.repository;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cinema.comet.domain.Movie;
import com.cinema.comet.domain.Path;
import com.cinema.comet.domain.Reservation;

@Repository
public class HibernateMovieDao implements MovieDao {
	
	
	private SessionFactory sessionFactory;

	@Autowired
	public HibernateMovieDao(SessionFactory sessionFactory){
		
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	public List<Movie> getAll() {
		
		Session session = sessionFactory.openSession();
		
		Query query =  session.createQuery("select m from Movie m");
		List<Movie> movies = query.list();
		
		return movies;
	}
	
	public void addMovie(Movie movie){
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(movie);
		
		session.getTransaction().commit();
		session.close();
		
	}
	
	@SuppressWarnings("unchecked")
	public List<String> getMoviesNames() {
		
		Session session = sessionFactory.openSession();
		
		Query query = session.createQuery("select m.name from Movie m");
		List<String> rows = query.list();
		
		
		return rows;
	}
	
	
	public void addImage(Path path){
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(path);
		session.getTransaction().commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	public List<String> getMovieImages() {
		
		Session session = sessionFactory.openSession();
		
		Query query =  session.createQuery("select p.partPath from Path p ");
		List<String> pat = query.list();
		session.close();
		
		return pat;
	}

}
