package org.katas.bowling;

import junit.framework.TestCase;
import org.junit.Test;

public class GameTest extends TestCase
{	

	@Test
	public void testGameStart() {
		final Game g  = new Game();
		int score = g.getScore();
		assertEquals(score, 0);
	}
	
}
