package com.victor.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;


@Entity
public class Film {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int filmId;
		
	String filmName;
	String actor;
	String locationBased;
	int ageLimit;
	double filmCost;
	
	@OneToMany(mappedBy = "film", fetch = FetchType.LAZY)
	List <Seat> seats;
	
    @ManyToMany(fetch= FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "customer_films", joinColumns = @JoinColumn(name = "film_id", referencedColumnName = "filmId"), 
    inverseJoinColumns = @JoinColumn(name = "customer_id", referencedColumnName = "id"))
	List <Customer> customers;
	
	@ManyToOne
	@JoinColumn(name = "cinemaId")
	Cinema cinema;
	
	public Film() {}
	
	public Film(String filmName, String actor, String locationBased, int ageLimit, double filmCost) {
		
		this.filmName = filmName;
		this.actor = actor;
		this.locationBased = locationBased;
		this.ageLimit = ageLimit;
		this.filmCost = filmCost;
		this.customers = new ArrayList<Customer>();
		
	    
	
    }

	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}
	
	
	@Override
	public String toString() {
		
		return "Film Name: " + filmName + '\n' +
			   "Actor: " + actor + '\n' +
			   "Filmed In: " + locationBased + '\n' +
			   "Admittance Age: " + ageLimit + '\n' + 
			   "Admittance Cost " + filmCost + '\n';
		
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
	
	public void addCustomer(Customer customer) {
		
		customers.add(customer);
		
	}

	public double getFilmCost() {
		
		return this.filmCost;
	}
	
}
