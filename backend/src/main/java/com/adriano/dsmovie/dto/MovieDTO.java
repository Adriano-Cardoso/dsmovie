package com.adriano.dsmovie.dto;

import com.adriano.dsmovie.entities.Movie;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MovieDTO {
	
	private Long movieId;
	private String title;
	private Double score;
	private Integer count;
	private String image;
	
	
	
	
	public MovieDTO(Movie movie) {
		this.movieId = movie.getMovieId();
		this.title = movie.getTitle();
		this.score = movie.getScore();
		this.count = movie.getCount();
		this.image = movie.getImage();
	}
	
	
	

}



