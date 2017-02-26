package com.cinema.comet.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PATH")
public class Path {
	
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	
	@Column(name="PART")
	private String partPath;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPartPath() {
		return partPath;
	}

	public void setPartPath(String partPath) {
		this.partPath = partPath;
	}
	
}
