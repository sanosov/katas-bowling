package org.katas.bowling;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Game
{
	private List<Integer> rolledPins = new ArrayList<>();

	public int getScore()
	{
		return rolledPins.stream().collect(Collectors.summingInt(Integer::intValue));
	}

	public void roll(int pins)
	{
		rolledPins.add(pins);
	}
}

