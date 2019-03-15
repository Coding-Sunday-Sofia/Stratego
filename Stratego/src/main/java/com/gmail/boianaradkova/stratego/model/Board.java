package com.gmail.boianaradkova.stratego.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Object-oriented model of the game board.
 * <p>
 * Stratego is a strategy board game for two players on a board of 10×10 squares.
 *
 * @author Boyana Kantarska
 */
public final class Board {
	/** State of the board. */
	enum State {
		EMPTY,
		SETUP,
		PLAY,
		FINISH,
	};

	/** All pieces available on the board are stored as Java objects in a single collection. */
	private static final List<Piece> PIECES = new ArrayList<>();

	/** Just a reference ot the real object. */
	private static final Piece BLUE_FLAG;

	/** Just a reference ot the real object. */
	private static final Piece RED_FLAG;

	/** Keep track of the board state. */
	private State state = State.EMPTY;

	/**
	 * The board consists of cells. Rectangular cardboard playing board imprinted with a 10x10 grid
	 * of spaces.
	 */
	private final Cell cells[][] = {
		{	new Cell(Cell.Kind.BORDER),	new Cell(Cell.Kind.BORDER),	new Cell(Cell.Kind.BORDER),	new Cell(Cell.Kind.BORDER),	new Cell(Cell.Kind.CENTRAL),	new Cell(Cell.Kind.CENTRAL),	new Cell(Cell.Kind.CENTRAL),	new Cell(Cell.Kind.CENTRAL),	new Cell(Cell.Kind.BORDER),	new Cell(Cell.Kind.BORDER),	new Cell(Cell.Kind.BORDER),	new Cell(Cell.Kind.BORDER),	},
		{	new Cell(Cell.Kind.BORDER),	new Cell(Cell.Kind.BORDER),	new Cell(Cell.Kind.BORDER),	new Cell(Cell.Kind.BORDER),	new Cell(Cell.Kind.CENTRAL),	new Cell(Cell.Kind.CENTRAL),	new Cell(Cell.Kind.CENTRAL),	new Cell(Cell.Kind.CENTRAL),	new Cell(Cell.Kind.BORDER),	new Cell(Cell.Kind.BORDER),	new Cell(Cell.Kind.BORDER),	new Cell(Cell.Kind.BORDER),	},
		{	new Cell(Cell.Kind.BORDER),	new Cell(Cell.Kind.BORDER),	new Cell(Cell.Kind.BORDER),	new Cell(Cell.Kind.BORDER),	new Cell(Cell.Kind.LAKE),	new Cell(Cell.Kind.LAKE),	new Cell(Cell.Kind.LAKE),	new Cell(Cell.Kind.LAKE),	new Cell(Cell.Kind.BORDER),	new Cell(Cell.Kind.BORDER),	new Cell(Cell.Kind.BORDER),	new Cell(Cell.Kind.BORDER),	},
		{	new Cell(Cell.Kind.BORDER),	new Cell(Cell.Kind.BORDER),	new Cell(Cell.Kind.BORDER),	new Cell(Cell.Kind.BORDER),	new Cell(Cell.Kind.LAKE),	new Cell(Cell.Kind.LAKE),	new Cell(Cell.Kind.LAKE),	new Cell(Cell.Kind.LAKE),	new Cell(Cell.Kind.BORDER),	new Cell(Cell.Kind.BORDER),	new Cell(Cell.Kind.BORDER),	new Cell(Cell.Kind.BORDER),	},
		{	new Cell(Cell.Kind.BORDER),	new Cell(Cell.Kind.BORDER),	new Cell(Cell.Kind.BORDER),	new Cell(Cell.Kind.BORDER),	new Cell(Cell.Kind.CENTRAL),	new Cell(Cell.Kind.CENTRAL),	new Cell(Cell.Kind.CENTRAL),	new Cell(Cell.Kind.CENTRAL),	new Cell(Cell.Kind.BORDER),	new Cell(Cell.Kind.BORDER),	new Cell(Cell.Kind.BORDER),	new Cell(Cell.Kind.BORDER),	},
		{	new Cell(Cell.Kind.BORDER),	new Cell(Cell.Kind.BORDER),	new Cell(Cell.Kind.BORDER),	new Cell(Cell.Kind.BORDER),	new Cell(Cell.Kind.CENTRAL),	new Cell(Cell.Kind.CENTRAL),	new Cell(Cell.Kind.CENTRAL),	new Cell(Cell.Kind.CENTRAL),	new Cell(Cell.Kind.BORDER),	new Cell(Cell.Kind.BORDER),	new Cell(Cell.Kind.BORDER),	new Cell(Cell.Kind.BORDER),	},
		{	new Cell(Cell.Kind.BORDER),	new Cell(Cell.Kind.BORDER),	new Cell(Cell.Kind.BORDER),	new Cell(Cell.Kind.BORDER),	new Cell(Cell.Kind.LAKE),	new Cell(Cell.Kind.LAKE),	new Cell(Cell.Kind.LAKE),	new Cell(Cell.Kind.LAKE),	new Cell(Cell.Kind.BORDER),	new Cell(Cell.Kind.BORDER),	new Cell(Cell.Kind.BORDER),	new Cell(Cell.Kind.BORDER),	},
		{	new Cell(Cell.Kind.BORDER),	new Cell(Cell.Kind.BORDER),	new Cell(Cell.Kind.BORDER),	new Cell(Cell.Kind.BORDER),	new Cell(Cell.Kind.LAKE),	new Cell(Cell.Kind.LAKE),	new Cell(Cell.Kind.LAKE),	new Cell(Cell.Kind.LAKE),	new Cell(Cell.Kind.BORDER),	new Cell(Cell.Kind.BORDER),	new Cell(Cell.Kind.BORDER),	new Cell(Cell.Kind.BORDER),	},
		{	new Cell(Cell.Kind.BORDER),	new Cell(Cell.Kind.BORDER),	new Cell(Cell.Kind.BORDER),	new Cell(Cell.Kind.BORDER),	new Cell(Cell.Kind.CENTRAL),	new Cell(Cell.Kind.CENTRAL),	new Cell(Cell.Kind.CENTRAL),	new Cell(Cell.Kind.CENTRAL),	new Cell(Cell.Kind.BORDER),	new Cell(Cell.Kind.BORDER),	new Cell(Cell.Kind.BORDER),	new Cell(Cell.Kind.BORDER),	},
		{	new Cell(Cell.Kind.BORDER),	new Cell(Cell.Kind.BORDER),	new Cell(Cell.Kind.BORDER),	new Cell(Cell.Kind.BORDER),	new Cell(Cell.Kind.CENTRAL),	new Cell(Cell.Kind.CENTRAL),	new Cell(Cell.Kind.CENTRAL),	new Cell(Cell.Kind.CENTRAL),	new Cell(Cell.Kind.BORDER),	new Cell(Cell.Kind.BORDER),	new Cell(Cell.Kind.BORDER),	new Cell(Cell.Kind.BORDER),	},
	};

	/** Players on the board. */
	private final List<Player> players = new ArrayList<>();

	/** Each player moves one piece per turn. */
	private int turn = 0;

	/* Initialization of the the static fields. */
	static {
		/*
		 * Each player controls 40 pieces representing individual officer ranks in an army.
		 */
		PIECES.add(new Piece(Piece.Color.RED, Piece.Rank.BOMB));
		PIECES.add(new Piece(Piece.Color.RED, Piece.Rank.BOMB));
		PIECES.add(new Piece(Piece.Color.RED, Piece.Rank.BOMB));
		PIECES.add(new Piece(Piece.Color.RED, Piece.Rank.BOMB));
		PIECES.add(new Piece(Piece.Color.RED, Piece.Rank.BOMB));
		PIECES.add(new Piece(Piece.Color.RED, Piece.Rank.BOMB));
		PIECES.add(new Piece(Piece.Color.RED, Piece.Rank.MARSHAL));
		PIECES.add(new Piece(Piece.Color.RED, Piece.Rank.GENERAL));
		PIECES.add(new Piece(Piece.Color.RED, Piece.Rank.COLONEL));
		PIECES.add(new Piece(Piece.Color.RED, Piece.Rank.COLONEL));
		PIECES.add(new Piece(Piece.Color.RED, Piece.Rank.MAJOR));
		PIECES.add(new Piece(Piece.Color.RED, Piece.Rank.MAJOR));
		PIECES.add(new Piece(Piece.Color.RED, Piece.Rank.MAJOR));
		PIECES.add(new Piece(Piece.Color.RED, Piece.Rank.CAPTAIN));
		PIECES.add(new Piece(Piece.Color.RED, Piece.Rank.CAPTAIN));
		PIECES.add(new Piece(Piece.Color.RED, Piece.Rank.CAPTAIN));
		PIECES.add(new Piece(Piece.Color.RED, Piece.Rank.CAPTAIN));
		PIECES.add(new Piece(Piece.Color.RED, Piece.Rank.LIEUTENANT));
		PIECES.add(new Piece(Piece.Color.RED, Piece.Rank.LIEUTENANT));
		PIECES.add(new Piece(Piece.Color.RED, Piece.Rank.LIEUTENANT));
		PIECES.add(new Piece(Piece.Color.RED, Piece.Rank.LIEUTENANT));
		PIECES.add(new Piece(Piece.Color.RED, Piece.Rank.SERGEANT));
		PIECES.add(new Piece(Piece.Color.RED, Piece.Rank.SERGEANT));
		PIECES.add(new Piece(Piece.Color.RED, Piece.Rank.SERGEANT));
		PIECES.add(new Piece(Piece.Color.RED, Piece.Rank.SERGEANT));
		PIECES.add(new Piece(Piece.Color.RED, Piece.Rank.SAPPER));
		PIECES.add(new Piece(Piece.Color.RED, Piece.Rank.SAPPER));
		PIECES.add(new Piece(Piece.Color.RED, Piece.Rank.SAPPER));
		PIECES.add(new Piece(Piece.Color.RED, Piece.Rank.SAPPER));
		PIECES.add(new Piece(Piece.Color.RED, Piece.Rank.SAPPER));
		PIECES.add(new Piece(Piece.Color.RED, Piece.Rank.SCOUT));
		PIECES.add(new Piece(Piece.Color.RED, Piece.Rank.SPY));
		PIECES.add(RED_FLAG = new Piece(Piece.Color.RED, Piece.Rank.FLAG));
		PIECES.add(new Piece(Piece.Color.BLUE, Piece.Rank.BOMB));
		PIECES.add(new Piece(Piece.Color.BLUE, Piece.Rank.BOMB));
		PIECES.add(new Piece(Piece.Color.BLUE, Piece.Rank.BOMB));
		PIECES.add(new Piece(Piece.Color.BLUE, Piece.Rank.BOMB));
		PIECES.add(new Piece(Piece.Color.BLUE, Piece.Rank.BOMB));
		PIECES.add(new Piece(Piece.Color.BLUE, Piece.Rank.BOMB));
		PIECES.add(new Piece(Piece.Color.BLUE, Piece.Rank.MARSHAL));
		PIECES.add(new Piece(Piece.Color.BLUE, Piece.Rank.GENERAL));
		PIECES.add(new Piece(Piece.Color.BLUE, Piece.Rank.COLONEL));
		PIECES.add(new Piece(Piece.Color.BLUE, Piece.Rank.COLONEL));
		PIECES.add(new Piece(Piece.Color.BLUE, Piece.Rank.MAJOR));
		PIECES.add(new Piece(Piece.Color.BLUE, Piece.Rank.MAJOR));
		PIECES.add(new Piece(Piece.Color.BLUE, Piece.Rank.MAJOR));
		PIECES.add(new Piece(Piece.Color.BLUE, Piece.Rank.CAPTAIN));
		PIECES.add(new Piece(Piece.Color.BLUE, Piece.Rank.CAPTAIN));
		PIECES.add(new Piece(Piece.Color.BLUE, Piece.Rank.CAPTAIN));
		PIECES.add(new Piece(Piece.Color.BLUE, Piece.Rank.CAPTAIN));
		PIECES.add(new Piece(Piece.Color.BLUE, Piece.Rank.LIEUTENANT));
		PIECES.add(new Piece(Piece.Color.BLUE, Piece.Rank.LIEUTENANT));
		PIECES.add(new Piece(Piece.Color.BLUE, Piece.Rank.LIEUTENANT));
		PIECES.add(new Piece(Piece.Color.BLUE, Piece.Rank.LIEUTENANT));
		PIECES.add(new Piece(Piece.Color.BLUE, Piece.Rank.SERGEANT));
		PIECES.add(new Piece(Piece.Color.BLUE, Piece.Rank.SERGEANT));
		PIECES.add(new Piece(Piece.Color.BLUE, Piece.Rank.SERGEANT));
		PIECES.add(new Piece(Piece.Color.BLUE, Piece.Rank.SERGEANT));
		PIECES.add(new Piece(Piece.Color.BLUE, Piece.Rank.SAPPER));
		PIECES.add(new Piece(Piece.Color.BLUE, Piece.Rank.SAPPER));
		PIECES.add(new Piece(Piece.Color.BLUE, Piece.Rank.SAPPER));
		PIECES.add(new Piece(Piece.Color.BLUE, Piece.Rank.SAPPER));
		PIECES.add(new Piece(Piece.Color.BLUE, Piece.Rank.SAPPER));
		PIECES.add(new Piece(Piece.Color.BLUE, Piece.Rank.SCOUT));
		PIECES.add(new Piece(Piece.Color.BLUE, Piece.Rank.SPY));
		PIECES.add(BLUE_FLAG = new Piece(Piece.Color.BLUE, Piece.Rank.FLAG));
	}

	/**
	 * Check for captured flag.
	 *
	 * @param flag Flag of some opponent.
	 * @return True if the flag is captured, false otherwise.
	 */
	private boolean isFlagCaptured(Piece flag) {
		/*
		 * Null pointer should not be possible, but in case of null pointer we accept that the flag is
		 * not captured,
		 */
		if (flag == null) {
			return false;
		}

		/* Capturing is checked by player flag. */
		if(flag.rank() != Piece.Rank.FLAG) {
			if(flag.color() == Piece.Color.RED) {
				flag = RED_FLAG;
			}
			if(flag.color() == Piece.Color.BLUE) {
				flag = BLUE_FLAG;
			}
		}

		if (true) throw new RuntimeException("Unit test needed!");
		//TODO DO the real check.

		return false;
	}

	/**
	 * Check for blocked player.
	 *
	 * @param player One of the player marked with his color.
	 * @return True if the player has some valid moves, false otherwise.
	 */
	private boolean hasValidMove(Piece.Color player) {
		/* If the player does not exist he could nod move. */
		if(player == null) {
			return false;
		}

		if (true) throw new RuntimeException("Unit test needed!");
		//TODO DO the real check.

		return false;
	}

	/**
	 * Check for game over conditions.
	 *
	 * @return True if the game is over, false otherwise.
	 */
	public boolean isGameOver() {
		if (true) throw new RuntimeException("Unit test needed!");

		//TODO Check for flag capture conditions.
		//TODO Check for no availble move conditions.

		return false;
	}

	/**
	 * Place piece over the board.
	 *
	 * @param piece Piece reference for deployment.
	 * @param x Column index.
	 * @param y Row index.
	 *
	 * @return True if the placement is successful, false otherwise.
	 */
	public boolean place(Piece piece, int x, int y) {
		if (true) throw new RuntimeException("Unit test needed!");

		return false;
	}

	/**
	 * Do a single move during playing phase.
	 *
	 * @param piece Piece to move.
	 * @param startX Start x position.
	 * @param startY Start y position.
	 * @param endX End x position.
	 * @param endY End y position.
	 *
	 * @return True if the movement is successful, false otherwise.
	 */
	public boolean move(Piece piece, int startX, int startY, int endX, int endY) {
		if (true) throw new RuntimeException("Unit test needed!");

		return false;
	}

	/**
	 * Handle click on the board.
	 *
	 * @param x Column on the board.
	 * @param y Row on the board.
	 *
	 * @return True if the click is successful, false otherwise.
	 */
	public boolean click(int x, int y) {
		if (true) throw new RuntimeException("Unit test needed!");

		return false;
	}
}
