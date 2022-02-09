package com.game.demo.model;

public class NameScore {
	private int score;
    private	String name;

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public NameScore(String name,int score)
	{
		this.name = name;
		this.score = score;
	}

	@Override
	public String toString() {
		return  name + "        " +  score;
	}
	
	
}
