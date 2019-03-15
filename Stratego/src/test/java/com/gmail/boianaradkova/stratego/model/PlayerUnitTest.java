package com.gmail.boianaradkova.stratego.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Test class for the player.
 *
 * @author Boyana Kantarska
 */
public final class PlayerUnitTest {
	/**
	 * Test valid construction of a piece object.
	 */
	@Test
	public void testLegalConstruction() {
		String name = "Name" + (int) (10 + Math.random() * 90);
		Piece.Color color = Piece.Color.values()[(int) (Math.random() * Piece.Color.values().length)];

		Player player = new Player(name, color);

		assertEquals("Wrong name!", name, player.name());
		assertEquals("Wrong color!", color, player.color());
	}

	/**
	 * Test invalid construction of a piece object.
	 */
	@Test
	public void testIllegalConstruction() {
		String name = "Name" + (int) (10 + Math.random() * 90);
		Piece.Color color = Piece.Color.values()[(int) (Math.random() * Piece.Color.values().length)];

		try {
			new Player(name, null);
			fail("Invalid player exception was not thrown!");
		} catch (RuntimeException e) {
		}

		try {
			new Player(null, color);
			fail("Invalid player exception was not thrown!");
		} catch (RuntimeException e) {
		}
	}

	/**
	 * Test all getters for the piece object.
	 */
	@Test
	public void testAccessors() {
		String name1 = "Name" + (int) (10 + Math.random() * 90);
		Piece.Color color1 = Piece.Color.values()[(int) (Math.random() * Piece.Color.values().length)];

		/* Create player with particular name and color. */
		Player player = new Player(name1, color1);

		/* Generate second name, which is different than the first one. */
		String name2 = name1;
		while (name1.equals(name2) == true) {
			name2 = "Name" + (int) (10 + Math.random() * 90);
		}

		player.name(name2);
		assertEquals("Wrong name!", name2, player.name());

		/* Generate second color, which is different than the first one. */
		Piece.Color color2 = color1;
		while (color1.equals(color2) == true) {
			color2 = Piece.Color.values()[(int) (Math.random() * Piece.Color.values().length)];
		}

		player.color(color2);
		assertEquals("Wrong color!", color2, player.color());
	}
}
