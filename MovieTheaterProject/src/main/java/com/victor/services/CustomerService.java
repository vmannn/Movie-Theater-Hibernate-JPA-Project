package com.victor.services;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victor.entities.Customer;
import com.victor.entities.Film;
import com.victor.repos.CustomerRepo;

@Service
public class CustomerService {
	
	
	@Autowired
	CustomerRepo customerRepo;
	
	@Transactional
	public double totalMade() {
		
		return customerRepo.getTotalCost();	
	}
	
	
	
	

}
