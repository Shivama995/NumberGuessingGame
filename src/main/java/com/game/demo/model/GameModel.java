package com.game.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class GameModel {
	
	
	@Id
	private int guess;
	
	public void setGuess(int guess) {
		this.guess = guess;
	}
	public int getGuess() {
		return guess;
	}
	@Override
	public String toString() {
		return "gameModel [guess=" + guess + "]";
	}
	

	
}
