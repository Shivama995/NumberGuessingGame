package com.game.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class GameNames {
	@Id
	private String name;
	//private int score;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
//	public int getScore() {
//		return score;
//	}
//	public void setScore(int score) {
//		this.score = score;
//	}
}
