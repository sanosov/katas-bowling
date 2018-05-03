package org.katas.bowling;

import java.util.ArrayList;
import java.util.List;

public class Game
{
	private List<Integer> rolledPins = new ArrayList<>();

	public int getScore()
	{
		int totalScore = 0;
		for (int i = 1; i < rolledPins.size(); i+=2)
		{
			if (isSpare(i))
			{
				totalScore += rolledPins.get(i + 1);
			}
			totalScore += rolledPins.get(i) + rolledPins.get(i-1);
		}
		return totalScore;
	}

	private boolean isSpare(final int i)
	{
		return rolledPins.get(i) + rolledPins.get(i - 1) == 10;
	}

	public void roll(int pins)
	{
		rolledPins.add(pins);
	}
}

