package org.katas.bowling;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.stream.IntStream;

import org.junit.Test;

public class GameTest
{
	@Test
	public void testCanCreateGame()
	{
		final Game game = new Game();
	}

	@Test
	public void testCanCreateStarted()
	{
		final Game game = new Game();
		final int score = game.getScore();
		assertThat(score, is(0));
	}

	@Test
	public void testGutterGame()
	{
		final Game game = new Game();
		IntStream.range(1, 10).forEach(i -> game.roll());
	}
}
