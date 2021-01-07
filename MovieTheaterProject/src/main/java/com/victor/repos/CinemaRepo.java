package com.victor.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.victor.entities.Cinema;

public interface CinemaRepo extends JpaRepository <Cinema, Integer> {
	
	@Query("from Cinema where username = :username and password = :password")
	List<Cinema> checkUsernameAndPassword(@Param("username") String username, @Param("password") String password);
	
	
	
}
