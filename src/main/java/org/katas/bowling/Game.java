package org.katas.bowling;

public class Game
{
	private int score;

	public int getScore()
	{
		return score;
	}

	public void roll(int pins)
	{
		score += pins;
	}
}

