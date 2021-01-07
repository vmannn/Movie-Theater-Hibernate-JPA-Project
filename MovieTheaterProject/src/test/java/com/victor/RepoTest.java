package com.victor;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.victor.entities.Cinema;
import com.victor.entities.Film;
import com.victor.repos.CinemaRepo;
import com.victor.repos.FilmRepo;

@SpringBootTest
public class RepoTest {
	
	@Test
	public void contextLoads() {
		
	}
	
	@Autowired
	CinemaRepo cinemaRepo;
	
	@Autowired
	FilmRepo filmRepo;
	
	@Test
	public void testGetFilmByAge() {
		
		ArrayList <Film> films = new ArrayList<Film>((ArrayList<Film>) filmRepo.findAvailableFilmsByAge(18));
		
		System.out.println(films);
		
	}
	
	
	
	@Test
    public void testCinemaAndFilm() {
		
		
        List <Film> films = new ArrayList<Film>();
        
		
		//public Film(String filmName, String actor, String locationBased, int ageLimit, double filmCost)
		
        
        //create film objects
		Film film1 = new Film("The Dark Knight", "Patrick Davis", "Austin Texas", 18, 12.35);
		Film film2 = new Film("Venom", "George O'Brien", "Sacramento California", 18, 13.43);
		Film film3 = new Film("Dora the Explorer", "Shauna Robertson", "Denver Colorado", 1, 9.45);
		Film film4 = new Film("Rugrats the Movie", "Kayla Bull", "Portland Oregon", 1, 4.56);
		Film film5 = new Film("Jigsaw", "Randy Piper", "Seattle Washington", 14, 12.23);
		
		
		//add film objects to film arraylist
		films.add(film1);
		films.add(film2);
		films.add(film3);
		films.add(film4);
		films.add(film5);
			
		Cinema theCinema = new Cinema("Universal Cinema of California", "Los Angeles California");
		
		//add cinema object to every film
		film1.setCinema(theCinema);
		film2.setCinema(theCinema);
		film3.setCinema(theCinema);
		film4.setCinema(theCinema);
		film5.setCinema(theCinema);
		
		
		
		//add array of films to cinema
		theCinema.setAvailableFilms(films);
		
		cinemaRepo.save(theCinema);
		
		
	}
	
	

}
