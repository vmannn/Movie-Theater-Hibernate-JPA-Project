package com.victor.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cinema {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	String cinemaName;
	String cinemaLocation;
	String username;
	String password;
	
	
	@OneToMany(mappedBy = "cinema", cascade = CascadeType.ALL)
	List <Film> availableFilms;
	
	public Cinema() {}
	
	public Cinema(String cinemaName, String cinemaLocation) {
		
		this.cinemaName = cinemaName;
		this.cinemaLocation = cinemaLocation;
		this.username = "root";
		this.password = "root";
		
	}

	public List<Film> getAvailableFilms() {
		return availableFilms;
	}

	public void setAvailableFilms(List<Film> availableFilms) {
		this.availableFilms = availableFilms;
	}

	
}
