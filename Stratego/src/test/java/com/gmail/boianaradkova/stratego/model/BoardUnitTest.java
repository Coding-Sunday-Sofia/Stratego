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

		board.state(Board.State.SETUP);

		/* Pieces are not used yet. */
		List<Piece> pieces = board.unused();
		assertEquals("All pieces should not be unused!", 80, pieces.size());

		/* Place all pices on the board. */
		while (pieces.size() > 0) {
			if (board.place(pieces.get(0), (int) (Math.random() * 10), (int) (Math.random() * 10)) == false) {
				continue;
			}

			pieces.remove(0);
		}

		//TODO Check for half of the pieces to be used.

		/* When all pieces are on the board there should not be unused pieces. */
		pieces = board.unused();
		assertEquals("All pieces should be unused!", 0, pieces.size());

		//TODO Check for half of the pieces to be used.

		/* Remove all pieces from the board. */
		for (int y = 0; y < 10; y++) {
			for (int x = 0; x < 10; x++) {
				board.remove(x, y);
			}
		}

		/* Pieces are not used anymore. */
		pieces = board.unused();
		assertEquals("All pieces should not be unused!", 80, pieces.size());
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
