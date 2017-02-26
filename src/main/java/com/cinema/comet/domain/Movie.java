package com.cinema.comet.domain;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="MOVIES")
public class Movie {
	
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="TYPE")
	private String  type;
	
	@Column(name="LENGHT")
	private int lenght;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@ElementCollection
	@CollectionTable(name="MOVIE_HOURS", joinColumns = @JoinColumn(name = "ID"))
	@Column(name="HOUR")
	private List<String> hours = new ArrayList<String>();
	
	
	public List<String> getHours() {
		return hours;
	}


	public void setHours(List<String> hours) {
		this.hours = hours;
	}

	

	public Movie(){
		
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getLenght() {
		return lenght;
	}

	public void setLenght(int lenght) {
		this.lenght = lenght;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
