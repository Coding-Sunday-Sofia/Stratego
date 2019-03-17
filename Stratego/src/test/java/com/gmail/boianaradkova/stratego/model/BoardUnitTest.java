package com.gmail.boianaradkova.stratego.model;

import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Test class for the board.
 *
 * @author Boyana Kantarska
 */
public final class BoardUnitTest {
	@Test
	public void testLegalConstruction() {
	}

	@Test
	public void testIllegalConstruction() {
	}

	/**
	 * Test cases for unused pieces during setup stage.
	 */
	@Test
	public void checkForUnusedPieces() {
		Board board = new Board();

		//TODO board.state(Board.State.SETUP);

		List<Piece> pieces = board.unused();
		//TODO Check list size.

		//TODO Place all pices on the board.
		pieces = board.unused();
		//TODO Check for zero size of the list.
	}

	/**
	 * Test cases for empty cells on the board.
	 */
	@Test
	public void checkForEmptyCell() {
		Board board = new Board();

		/* Test outside of the board. */
		try {
			board.isEmpty(-1, -1);
			fail("Invalid coordinates exception was not thrown!");
		} catch (ArrayIndexOutOfBoundsException e) {
		}
		try {
			board.isEmpty(0, -1);
			fail("Invalid coordinates exception was not thrown!");
		} catch (ArrayIndexOutOfBoundsException e) {
		}
		try {
			board.isEmpty(-1, 0);
			fail("Invalid coordinates exception was not thrown!");
		} catch (ArrayIndexOutOfBoundsException e) {
		}
		try {
			board.isEmpty(Integer.MAX_VALUE, Integer.MAX_VALUE);
			fail("Invalid coordinates exception was not thrown!");
		} catch (ArrayIndexOutOfBoundsException e) {
		}
		try {
			board.isEmpty(0, Integer.MAX_VALUE);
			fail("Invalid coordinates exception was not thrown!");
		} catch (ArrayIndexOutOfBoundsException e) {
		}
		try {
			board.isEmpty(Integer.MAX_VALUE, 0);
			fail("Invalid coordinates exception was not thrown!");
		} catch (ArrayIndexOutOfBoundsException e) {
		}

		/* Select random piece of pieces, which are not on the board. */
		List<Piece> pieces = board.unused();
		Collections.shuffle(pieces);

		/* Test when the cell is not empty. */
		board.place(pieces.get(0), 0, 0);
		assertEquals("Cell should not be empty!", false, board.isEmpty(0, 0));

		/* Test when the cell is empty. */
		board.remove(0, 0);
		assertEquals("Cell should be empty!", true, board.isEmpty(0, 0));
	}
}
