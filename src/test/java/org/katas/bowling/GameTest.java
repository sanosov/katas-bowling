package org.katas.bowling;

import static org.junit.Assert.assertEquals;

import java.util.stream.IntStream;

import org.junit.Before;
import org.junit.Test;

public class GameTest
{

	private Game game;

	@Before
	public void before()
	{
		game = new Game();
	}


	@Test
	public void testGameStart()
	{
		assertExpectedScore(0);
	}

	@Test
	public void testGutterGame()
	{
		rollMany(0, 20);

		assertExpectedScore(0);
	}

	@Test
	public void testRollWithScore()
	{
		rollMany(1, 20);

		assertExpectedScore(20);
	}

	@Test
	public void testRollWithSpare()
	{
		spare();
		rollMany(1,18);

		assertExpectedScore(29);
	}

	@Test
	public void testRollWithStrike()
	{
		game.roll(10);
		rollMany(1,18);

		assertExpectedScore(30);
	}

	private void spare()
	{
		rollMany(5,2);
	}

	private void assertExpectedScore(final int expectedScore)
	{
		assertEquals(expectedScore, game.getScore());
	}

	private void rollMany(final int pins, final int numberOfRolls)
	{
		IntStream.range(0, numberOfRolls).forEach(i -> game.roll(pins));
	}
}
