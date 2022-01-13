package com.adriano.dsmovie.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "tb_score")
@Data
public class Score {
	
	@EmbeddedId
	private ScorePK scorePkId = new ScorePK();
	private Double value;
	
	
	
	public void setMovie(Movie movie) {
		scorePkId.setMovie(movie);
	}

	public void setUser(User user) {
		scorePkId.setUser(user);
	}
}
