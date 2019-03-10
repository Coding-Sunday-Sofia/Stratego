package com.gmail.boianaradkova.stratego.model;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Test class for the piece.
 *
 * @author Boyana Kantarska
 */
public final class PieceUnitTest {
	/** Test valid construction of a piece object. */
	@Test
	public void testLegalConstruction() {
		Piece.Color color = Piece.Color.values()[(int) (Math.random()*Piece.Color.values().length)];
		Piece.Rank rank = Piece.Rank.values()[(int) (Math.random()*Piece.Rank.values().length)];

		Piece piece = new Piece(color, rank);

		assertEquals("wrong color", color, piece.color());
		assertEquals("wrong rank", rank, piece.rank());
	}

	/** Test invalid construction of a piece object. */
	@Test
	public void testIllegalConstruction() {
		Piece.Color color = Piece.Color.values()[(int) (Math.random()*Piece.Color.values().length)];
		Piece.Rank rank = Piece.Rank.values()[(int) (Math.random()*Piece.Rank.values().length)];

		try {
			new Piece(null, rank);
			fail("Invalid piece exception was not thrown!");
		} catch(RuntimeException e) {}

		try {
			new Piece(color, null);
			fail("Invalid piece exception was not thrown!");
		} catch(RuntimeException e) {}
	}

	/**
	 * Test all getters for the piece object.
	 */
	@Test
	public void testGetters() {
		Piece.Color color = Piece.Color.values()[(int) (Math.random()*Piece.Color.values().length)];
		Piece.Rank rank = Piece.Rank.values()[(int) (Math.random()*Piece.Rank.values().length)];

		Piece piece = new Piece(color, rank);

		assertEquals("wrong color", color, piece.color());
		assertEquals("wrong rank", rank, piece.rank());
	}
}
