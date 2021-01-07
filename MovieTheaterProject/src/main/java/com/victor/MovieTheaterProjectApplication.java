package com.victor;

import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import com.victor.entities.Customer;
import com.victor.entities.Film;
import com.victor.repos.CinemaRepo;
import com.victor.services.CinemaService;
import com.victor.services.CustomerService;
import com.victor.services.FilmServices;

@SpringBootApplication
public class MovieTheaterProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieTheaterProjectApplication.class, args);
	}

}


@Component
class CommandLineAppStartupRunner implements CommandLineRunner{

	@Autowired
	FilmServices filmService;
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	CinemaService cinemaService;
	
	
	
	
	@Override
	public void run(String... args) throws Exception {
		
	
		filmService.addFilmsToCinema();
		
		System.out.println("Welcome to the movie scheduler. Please select from the following menu\n(Enter corresponding number)\n\n");
		System.out.println("1. Admin Login                 2. Book a movie" + '\n' +
				           "3. View available movies       4. Cancel a movie reservation\n\n\n"
				
				);
		
		Scanner sc = new Scanner(System.in);
		
		int menu = sc.nextInt();
		
		switch(menu) {
		 
		case 1: adminLogin();
		case 2: bookMovie(); break;
		case 3: viewAvailableMovies(); break;
		case 4: cancelMovieReservation(); break;
		
		
		}
		
		
		sc.close();
		
		
	}
	
	private void cancelMovieReservation() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("What is the booking id for the movie you wish to cancel: ");
		
		String bookingId = sc.nextLine();
		
		
		
		
	}

	public void bookMovie() {
		
		System.out.println("Please enter your full name: \n");
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		System.out.println("Please enter your age: \n");
		int age = sc.nextInt();
		System.out.println("Are you a student?(type y/n)");
		String student = sc.nextLine();
		
		boolean isStudent = false;
		
		if(student.equals("y") || student.equals("Y"))
			isStudent =true;
		
		System.out.println("Thank you. Please choose from the following menu: \n(Enter corresponding number)" + '\n' +
				           "1. View All available movies           2. View the movies you may watch based on your age" + '\n' +
				           "3. Make movie reservation");
				 
				int menu = sc.nextInt();
				
				switch(menu) {
				
				case 1: viewAvailableMovies(); break;
				
				case 2: viewMoviesBasedOnAge(age); break;
				
				case 3: makeMovieReservation(name, age, isStudent); break;
				
				}
				
				
				
			sc.close();	
			
				
	}
	
	
	public void viewAvailableMovies() {
		
		filmService.displayFilms();
		
	}
	
	public void viewMoviesBasedOnAge(int age) {
		
		
		filmService.displayFilmsByAge(age);
		
		
	}
	
	public void makeMovieReservation(String name, int age, boolean isStudent) {
		
		System.out.println("Please enter the name of the movie you would like to watch: ");
		Scanner sc = new Scanner(System.in);
		
		String movie = sc.nextLine();
		
	
		filmService.addCustomer(name, age, isStudent, movie);
		
		
		
		
		sc.close();
		
		
		
	}
	
	public void adminLogin() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter username: ");
		String username = sc.nextLine();
		System.out.print("Please enter password: ");
		String password = sc.nextLine();
		
		if(cinemaService.checkUsernamePassword(username, password))
			System.out.println("\nLogin successful Admin!");
		
	
		System.out.println("The total made from all customers is " + customerService.totalMade());
		
		
		
		
	}
	
	
	
	
}
