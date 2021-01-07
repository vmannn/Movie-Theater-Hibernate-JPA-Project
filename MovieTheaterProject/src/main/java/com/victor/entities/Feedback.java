package com.victor.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Feedback {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int feedbackId;
	
	String feedback;
	Date date;
	String customerName;
	String movieName;
	
	@ManyToOne
	@JoinColumn(name = "customerId")
	Customer customer;

}
