package com.victor.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	String name;
	int age;
	boolean student;
	String bookingId;
	double totalCost;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	List <Feedback> feedback;
	
	@ManyToMany(mappedBy = "customers", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	List <Film> films;
	
	@OneToOne
	@JoinColumn(name = "seat_id")
	Seat seat;
	
	boolean isStudent;
	
	public Customer(String name, int age, String bookingId, boolean isStudent) {
		
		this.name = name;
		this.age = age;
		this.bookingId = bookingId;
		this.isStudent = isStudent;
		this.films = new ArrayList<Film>();
		this.totalCost = 0;
		
	}
	
	public Customer() {}

	public List<Film> getFilms() {
		return films;
	}

	public void setFilms(List<Film> films) {
		this.films = films;
	}
	
	public void addFilm(Film film) {
		
		films.add(film);
		
	}
	
	public void addToTotal(double total) {
		
		this.totalCost += total;
	}

	public boolean isStudent() {
		
		return isStudent;
	}
	
	
}
