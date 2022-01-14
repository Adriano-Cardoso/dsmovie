package com.adriano.dsmovie.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adriano.dsmovie.dto.MovieDTO;
import com.adriano.dsmovie.dto.ScoreDTO;
import com.adriano.dsmovie.service.ScoreService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/scores")
public class ScoreController {

	private ScoreService scoreService;
	
	@PutMapping
	public ResponseEntity<MovieDTO>saveScore(@RequestBody ScoreDTO scoreDTO){
		return ResponseEntity.status(HttpStatus.OK).body(this.scoreService.saveScore(scoreDTO));
	}
	
}
