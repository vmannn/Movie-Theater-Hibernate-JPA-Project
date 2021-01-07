package com.victor.services;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victor.entities.Cinema;
import com.victor.repos.CinemaRepo;

@Service
public class CinemaService {
	
	
	
	@Autowired
	CinemaRepo cinemaRepo;
	
	@Transactional
	public boolean checkUsernamePassword(String username, String pasword) {
		
		ArrayList <Cinema> cinema = new ArrayList<Cinema> (cinemaRepo.checkUsernameAndPassword(username, pasword));
		
		if(cinema.isEmpty())
			return false;
		
		return true;
		
		
		
		
	}
	
	

}
