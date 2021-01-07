package com.victor;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.victor.repos.CinemaRepo;
import com.victor.services.FilmServices;

@SpringBootTest
public class ServiceTest {

	@Test
	void contextLoads() {
	}	
	
	@Mock
	CinemaRepo cinemaRepo;
	
    @InjectMocks
    FilmServices filmServices;
    
    
    @Test
    public void testAddFilmsToCinema() {
    	
    	filmServices.addFilmsToCinema();
    	
    }
    
	
	
}
