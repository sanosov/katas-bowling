package org.katas.bowling;

import java.util.ArrayList;
import java.util.List;

public class Game
{
	private static final int FRAMES_IN_GAME = 10;

	private List<Integer> rolledPins = new ArrayList<>();

	public int getScore()
	{
		if (gameStarted())
		{
			int totalScore = 0;
			int firstRollInFrame = 0;
			for (int frame = 0; frame < FRAMES_IN_GAME; frame++)
			{
				if (rolledPins.get(firstRollInFrame) == 10)
				{
					totalScore += rolledPins.get(firstRollInFrame) + rolledPins.get(firstRollInFrame + 1) + rolledPins.get(firstRollInFrame + 2);
					firstRollInFrame++;
				}
				else if (isSpare(firstRollInFrame))
				{
					totalScore += rolledPins.get(firstRollInFrame) + rolledPins.get(firstRollInFrame + 1) + rolledPins.get(firstRollInFrame + 2);
					firstRollInFrame += 2;
				}
				else
				{
					totalScore += rolledPins.get(firstRollInFrame) + rolledPins.get(firstRollInFrame + 1);
					firstRollInFrame += 2;
				}
			}
			return totalScore;
		}
		return 0;
	}

	private boolean gameStarted()
	{
		return ! rolledPins.isEmpty();
	}

	private boolean isSpare(final int i)
	{
		return rolledPins.get(i) + rolledPins.get(i + 1) == 10;
	}

	public void roll(int pins)
	{
		rolledPins.add(pins);
	}
}

