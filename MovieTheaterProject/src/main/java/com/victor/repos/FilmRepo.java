package com.victor.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.victor.entities.Film;

public interface FilmRepo extends JpaRepository <Film, Integer> {
	
	@Query("from Film where ageLimit >= :ageLimit")
	public List <Film> findAvailableFilmsByAge(@Param("ageLimit") int ageLimit);
	
	@Query("from Film")
	public List <Film> printAllFilms();
	
	@Query("from Film where filmName = :filmName and ageLimit >= :ageLimit")
	public List <Film> verifyWatch(@Param("filmName") String filmName, @Param("ageLimit") int ageLimit);
	
	
}
