package com.victor.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.victor.entities.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {
	
	
	@Query("select sum(totalCost) from Customer")
	public double getTotalCost();
	
	/*@Query("from Customer where bookingId = :bookingId")
	public <Customer> getCustomerFromBookingId(@Param())
	*/

}
