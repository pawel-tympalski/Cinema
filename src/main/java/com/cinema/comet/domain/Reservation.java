package com.cinema.comet.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="RESERVE")
public class Reservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	
	
	@Column(name="NAME")
	private String name;
	
	@Size(min = 3, message="fffff")
	@Column(name="SURNAME")
	private String surname;
	
	
	@Column(name="MOVIETYPE")
	private String movietype;
	
	@Column(name="HOUR")
	private String hour;
	
	public Reservation(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getMovietype() {
		return movietype;
	}

	public void setMovietype(String movietype) {
		this.movietype = movietype;
	}

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

}
