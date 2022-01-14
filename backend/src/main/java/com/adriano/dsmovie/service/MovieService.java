package com.adriano.dsmovie.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adriano.dsmovie.dto.MovieDTO;
import com.adriano.dsmovie.entities.Movie;
import com.adriano.dsmovie.repository.MovieRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MovieService {

	
	private MovieRepository movieRepository;
	
	@Transactional(readOnly = true)
	public Page<MovieDTO> findAll(Pageable pageable){
		Page<Movie> movie = movieRepository.findAll(pageable);
		Page<MovieDTO> page = movie.map(m -> new MovieDTO(m));
		return page;
	}
	
	public MovieDTO findById(Long movieId) {
		Movie movie = this.movieRepository.findById(movieId).get();
		MovieDTO movieDTO = new MovieDTO(movie);
		return movieDTO;
	}
}
