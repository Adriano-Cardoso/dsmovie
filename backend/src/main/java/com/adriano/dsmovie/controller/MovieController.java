package com.adriano.dsmovie.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adriano.dsmovie.dto.MovieDTO;
import com.adriano.dsmovie.service.MovieService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/movies")
public class MovieController {

	private MovieService movieService;
	
	@GetMapping(value = "/findall")
	public ResponseEntity<Page<MovieDTO>> findAll(Pageable pageable){
		return ResponseEntity.status(HttpStatus.OK).body(this.movieService.findAll(pageable));
	}
	
	@GetMapping(value = "/{movieId}")
	public ResponseEntity<MovieDTO>findById(@PathVariable ("movieId") Long movieId){
		return ResponseEntity.status(HttpStatus.OK).body(this.movieService.findById(movieId));
	}
	
}
