package com.adriano.dsmovie.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.adriano.dsmovie.dto.MovieDTO;
import com.adriano.dsmovie.dto.ScoreDTO;
import com.adriano.dsmovie.entities.Movie;
import com.adriano.dsmovie.entities.Score;
import com.adriano.dsmovie.entities.User;
import com.adriano.dsmovie.repository.MovieRepository;
import com.adriano.dsmovie.repository.ScoreRepository;
import com.adriano.dsmovie.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ScoreService {
	
	private ScoreRepository scoreRepository;
	
	private UserRepository userRepository;
	
	private MovieRepository movieRepository;

	
	@Transactional
	public MovieDTO saveScore(ScoreDTO scoreDTO) {
		
		User user = userRepository.findByEmail(scoreDTO.getEmail());
		if (user == null) {
			user = new User();
			user.setEmail(scoreDTO.getEmail());
			user= userRepository.saveAndFlush(user);
			
		}
		
		Movie movie = movieRepository.findById(scoreDTO.getMovieId()).get();
		
		Score score = new Score();
		score.setMovie(movie);
		score.setUser(user);
		score.setValue(scoreDTO.getScore());
		
		score = scoreRepository.saveAndFlush(score);
		
		double sum = 0.0;
		for (Score s :movie.getScores()) {
			sum = sum +s.getValue();
		}
		
		double avg = sum / movie.getScores().size();
		
		movie.setScore(avg);
		movie.setCount(movie.getScores().size());
		
		movie = movieRepository.save(movie);
		
	
		
		return new MovieDTO(movie);
		
	}

	
}
