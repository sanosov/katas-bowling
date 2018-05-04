package org.katas.bowling;

import java.util.ArrayList;
import java.util.List;

public class Game
{
	private static final int FRAMES_IN_GAME = 10;
	private static final int ALL_PINS = 10;

	private List<Integer> rolledPins = new ArrayList<>();

	public void roll(final int pins)
	{
		rolledPins.add(pins);
	}

	public int getScore()
	{
		if (gameStarted())
		{
			int totalScore = 0;
			int firstRollInFrame = 0;
			for (int frame = 0; frame < FRAMES_IN_GAME; frame++)
			{
				if (isStrike(firstRollInFrame))
				{
					totalScore += ALL_PINS + nextTwoRollsScore(firstRollInFrame);
					firstRollInFrame++;
				}
				else
				{
					totalScore += frameScore(firstRollInFrame);
					if (isSpare(firstRollInFrame))
					{
						totalScore += firstRollInNextFrame(firstRollInFrame);
					}
					firstRollInFrame += 2;
				}
			}
			return totalScore;
		}
		return 0;
	}

	private boolean isStrike(final int firstRollInFrame)
	{
		return rolledPins.get(firstRollInFrame) == ALL_PINS;
	}

	private boolean gameStarted()
	{
		return ! rolledPins.isEmpty();
	}

	private boolean isSpare(final int i)
	{
		return frameScore(i) == ALL_PINS;
	}

	private int frameScore(final int firstRollInFrame)
	{
		return rolledPins.get(firstRollInFrame) + rolledPins.get(firstRollInFrame + 1);
	}

	private int nextTwoRollsScore(final int currRoll)
	{
		return rolledPins.get(currRoll + 1) + rolledPins.get(currRoll + 2);
	}

	private Integer firstRollInNextFrame(final int firstRollInFrame)
	{
		return rolledPins.get(firstRollInFrame + 2);
	}
}

