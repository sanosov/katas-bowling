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
	public void testGameStart() {
		final int score = game.getScore();
		assertEquals(score, 0);
	}

	@Test
	public void testGutterGame()
	{
		IntStream.range(1, 20).forEach(i -> game.roll(0));

		final int score = game.getScore();
		assertEquals(0, score);
	}
}
