package com.victor.services;

import java.util.ArrayList;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.victor.entities.Cinema;
import com.victor.entities.Customer;
import com.victor.entities.Film;
import com.victor.repos.CinemaRepo;
import com.victor.repos.FilmRepo;

@Service
public class FilmServices {
	
	
	private Object object;

	@Autowired
	CinemaRepo cinemaRepo;
	
	@Autowired
	FilmRepo filmRepo;
	
	
	@Transactional
	public void addFilmsToCinema()
	{
		
		List <Film> films = new ArrayList<Film>();
		
		//public Film(String filmName, String actor, String locationBased, int ageLimit, double filmCost)
		
		Film film1 = new Film("The Dark Knight", "Patrick Davis", "Austin Texas", 18, 12.35);
		Film film2 = new Film("Venom", "George O'Brien", "Sacramento California", 18, 13.43);
		Film film3 = new Film("Dora the Explorer", "Shauna Robertson", "Denver Colorado", 1, 9.45);
		Film film4 = new Film("Rugrats the Movie", "Kayla Bull", "Portland Oregon", 1, 4.56);
		Film film5 = new Film("Jigsaw", "Randy Piper", "Seattle Washington", 14, 12.23);
		films.add(film1);
		films.add(film2);
		films.add(film3);
		films.add(film4);
		films.add(film5);
		
		Cinema theCinema = new Cinema("Universal Cinema of California", "Los Angeles California");
		film1.setCinema(theCinema);
		film2.setCinema(theCinema);
		film3.setCinema(theCinema);
		film4.setCinema(theCinema);
		film5.setCinema(theCinema);
		theCinema.setAvailableFilms(films);
		
		cinemaRepo.save(theCinema);
		
		
	}
	
	@Transactional
	public void displayFilms() {
		
		
		ArrayList <Film> films = new ArrayList<Film>(filmRepo.printAllFilms());
	    
		for(Film a: films) {
			
			System.out.println(a + "\n");
			
		}
	
		
		
	}
	
	@Transactional
	public void displayFilmsByAge(int age) {
		
        ArrayList <Film> films = new ArrayList<Film>((ArrayList<Film>) filmRepo.findAvailableFilmsByAge(18));
		
        for(Film a: films) {
			
			System.out.println(a + "\n");
			
		}		
		
	}
	
	@Transactional
	public List<Film> canWatch(String filmName, int customerAge) {
		
		ArrayList<Film> films = new ArrayList<Film>(filmRepo.verifyWatch(filmName, customerAge));
		
		return films;
	}
	
	
	
	@Transactional
	public void addCustomer(String name, int age, boolean student, String movieName) {
		
       ArrayList <Film> customerFilm = new ArrayList<Film>(canWatch(movieName, age));
		
	    if(customerFilm.isEmpty())
	    	return;
	    
	    
			
		Customer customer = new Customer(name, age, "M1232134", student);
		  
		
		//calculate film cost
		double total = customerFilm.get(0).getFilmCost();
		
		//Students get half off movie price
		if(customer.isStudent())
			total /= 2;
		
		customer.addToTotal(total);
					
		customer.addFilm(customerFilm.get(0));
		
		customerFilm.get(0).addCustomer(customer);
		
		filmRepo.save(customerFilm.get(0));
		
		
	}
	
	
	
	

}
