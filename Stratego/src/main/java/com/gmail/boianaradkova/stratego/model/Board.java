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
	/**
	 * State of the board.
	 */
	public enum State {
		EMPTY,
		SETUP,
		PLAY,
		FINISH,
	}

	;

	/**
	 * All pieces available on the board are stored as Java objects in a single collection.
	 */
	private static final List<Piece> PIECES = new ArrayList<>();

	/**
	 * Just a reference ot the real object.
	 */
	private static final Piece BLUE_FLAG;

	/**
	 * Just a reference ot the real object.
	 */
	private static final Piece RED_FLAG;

	/**
	 * Keep track of the board state.
	 */
	private State state = State.EMPTY;

	/**
	 * The board consists of cells. Rectangular cardboard playing board imprinted with a 10x10 grid
	 * of spaces.
	 */
	private final Cell cells[][] = {
					{new Cell(Cell.Territory.BLUE), new Cell(Cell.Territory.BLUE), new Cell(Cell.Territory.BLUE), new Cell(Cell.Territory.BLUE), new Cell(Cell.Territory.NEUTRAL), new Cell(Cell.Territory.NEUTRAL), new Cell(Cell.Territory.NEUTRAL), new Cell(Cell.Territory.NEUTRAL), new Cell(Cell.Territory.RED), new Cell(Cell.Territory.RED), new Cell(Cell.Territory.RED), new Cell(Cell.Territory.RED),},
					{new Cell(Cell.Territory.BLUE), new Cell(Cell.Territory.BLUE), new Cell(Cell.Territory.BLUE), new Cell(Cell.Territory.BLUE), new Cell(Cell.Territory.NEUTRAL), new Cell(Cell.Territory.NEUTRAL), new Cell(Cell.Territory.NEUTRAL), new Cell(Cell.Territory.NEUTRAL), new Cell(Cell.Territory.RED), new Cell(Cell.Territory.RED), new Cell(Cell.Territory.RED), new Cell(Cell.Territory.RED),},
					{new Cell(Cell.Territory.BLUE), new Cell(Cell.Territory.BLUE), new Cell(Cell.Territory.BLUE), new Cell(Cell.Territory.BLUE), new Cell(Cell.Territory.LAKE), new Cell(Cell.Territory.LAKE), new Cell(Cell.Territory.LAKE), new Cell(Cell.Territory.LAKE), new Cell(Cell.Territory.RED), new Cell(Cell.Territory.RED), new Cell(Cell.Territory.RED), new Cell(Cell.Territory.RED),},
					{new Cell(Cell.Territory.BLUE), new Cell(Cell.Territory.BLUE), new Cell(Cell.Territory.BLUE), new Cell(Cell.Territory.BLUE), new Cell(Cell.Territory.LAKE), new Cell(Cell.Territory.LAKE), new Cell(Cell.Territory.LAKE), new Cell(Cell.Territory.LAKE), new Cell(Cell.Territory.RED), new Cell(Cell.Territory.RED), new Cell(Cell.Territory.RED), new Cell(Cell.Territory.RED),},
					{new Cell(Cell.Territory.BLUE), new Cell(Cell.Territory.BLUE), new Cell(Cell.Territory.BLUE), new Cell(Cell.Territory.BLUE), new Cell(Cell.Territory.NEUTRAL), new Cell(Cell.Territory.NEUTRAL), new Cell(Cell.Territory.NEUTRAL), new Cell(Cell.Territory.NEUTRAL), new Cell(Cell.Territory.RED), new Cell(Cell.Territory.RED), new Cell(Cell.Territory.RED), new Cell(Cell.Territory.RED),},
					{new Cell(Cell.Territory.BLUE), new Cell(Cell.Territory.BLUE), new Cell(Cell.Territory.BLUE), new Cell(Cell.Territory.BLUE), new Cell(Cell.Territory.NEUTRAL), new Cell(Cell.Territory.NEUTRAL), new Cell(Cell.Territory.NEUTRAL), new Cell(Cell.Territory.NEUTRAL), new Cell(Cell.Territory.RED), new Cell(Cell.Territory.RED), new Cell(Cell.Territory.RED), new Cell(Cell.Territory.RED),},
					{new Cell(Cell.Territory.BLUE), new Cell(Cell.Territory.BLUE), new Cell(Cell.Territory.BLUE), new Cell(Cell.Territory.BLUE), new Cell(Cell.Territory.LAKE), new Cell(Cell.Territory.LAKE), new Cell(Cell.Territory.LAKE), new Cell(Cell.Territory.LAKE), new Cell(Cell.Territory.RED), new Cell(Cell.Territory.RED), new Cell(Cell.Territory.RED), new Cell(Cell.Territory.RED),},
					{new Cell(Cell.Territory.BLUE), new Cell(Cell.Territory.BLUE), new Cell(Cell.Territory.BLUE), new Cell(Cell.Territory.BLUE), new Cell(Cell.Territory.LAKE), new Cell(Cell.Territory.LAKE), new Cell(Cell.Territory.LAKE), new Cell(Cell.Territory.LAKE), new Cell(Cell.Territory.RED), new Cell(Cell.Territory.RED), new Cell(Cell.Territory.RED), new Cell(Cell.Territory.RED),},
					{new Cell(Cell.Territory.BLUE), new Cell(Cell.Territory.BLUE), new Cell(Cell.Territory.BLUE), new Cell(Cell.Territory.BLUE), new Cell(Cell.Territory.NEUTRAL), new Cell(Cell.Territory.NEUTRAL), new Cell(Cell.Territory.NEUTRAL), new Cell(Cell.Territory.NEUTRAL), new Cell(Cell.Territory.RED), new Cell(Cell.Territory.RED), new Cell(Cell.Territory.RED), new Cell(Cell.Territory.RED),},
					{new Cell(Cell.Territory.BLUE), new Cell(Cell.Territory.BLUE), new Cell(Cell.Territory.BLUE), new Cell(Cell.Territory.BLUE), new Cell(Cell.Territory.NEUTRAL), new Cell(Cell.Territory.NEUTRAL), new Cell(Cell.Territory.NEUTRAL), new Cell(Cell.Territory.NEUTRAL), new Cell(Cell.Territory.RED), new Cell(Cell.Territory.RED), new Cell(Cell.Territory.RED), new Cell(Cell.Territory.RED),},
	};

	/**
	 * Each player moves one piece per turn.
	 */
	private int turn = 0;

	/**
	 * Players on the board.
	 */
	private final List<Player> players = new ArrayList<>();

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
		PIECES.add(new Piece(Piece.Color.RED, Piece.Rank.SCOUT));
		PIECES.add(new Piece(Piece.Color.RED, Piece.Rank.SCOUT));
		PIECES.add(new Piece(Piece.Color.RED, Piece.Rank.SCOUT));
		PIECES.add(new Piece(Piece.Color.RED, Piece.Rank.SCOUT));
		PIECES.add(new Piece(Piece.Color.RED, Piece.Rank.SCOUT));
		PIECES.add(new Piece(Piece.Color.RED, Piece.Rank.SCOUT));
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
		PIECES.add(new Piece(Piece.Color.BLUE, Piece.Rank.SCOUT));
		PIECES.add(new Piece(Piece.Color.BLUE, Piece.Rank.SCOUT));
		PIECES.add(new Piece(Piece.Color.BLUE, Piece.Rank.SCOUT));
		PIECES.add(new Piece(Piece.Color.BLUE, Piece.Rank.SCOUT));
		PIECES.add(new Piece(Piece.Color.BLUE, Piece.Rank.SCOUT));
		PIECES.add(new Piece(Piece.Color.BLUE, Piece.Rank.SCOUT));
		PIECES.add(new Piece(Piece.Color.BLUE, Piece.Rank.SCOUT));
		PIECES.add(new Piece(Piece.Color.BLUE, Piece.Rank.SPY));
		PIECES.add(BLUE_FLAG = new Piece(Piece.Color.BLUE, Piece.Rank.FLAG));
	}

	/**
	 * Board state setter.
	 *
	 * @param state Board state constant.
	 */
	public void state(State state) {
		this.state = state;
	}

	/**
	 * Board state getter.
	 *
	 * @return Board state constant.
	 */
	public State state() {
		return state;
	}

	/**
	 * Cells getter.
	 *
	 * @return Array reference to the cells object.
	 */
	public Cell[][] cells() {
		//TODO if (true) throw new RuntimeException("Unit test needed!");
		return cells;
	}

	/**
	 * Return list of unused pieces on the board.
	 *
	 * @return List of the pieces references.
	 */
	public List<Piece> unused() {
		List<Piece> list = new ArrayList<>(PIECES);

		/* Check each piece one by one. */
		for (Piece piece : PIECES) {
			for (Cell array[] : cells) {
				for (Cell element : array) {
					if (element.piece() == null) {
						continue;
					}

					if (piece.equals(element.piece()) == false) {
						continue;
					}

					/* If the piece is found, remove it from the list. */
					list.remove(piece);
				}
			}
		}

		return list;
	}

	/**
	 * Check for empty cell on the board.
	 *
	 * @param x Index of a column on the board.
	 * @param y Index of a row on the board.
	 * @return True if the cell is empty, false otherwise.
	 * @throws RuntimeException Thrown when cell is out of the board.
	 */
	public boolean isEmpty(int x, int y) throws RuntimeException {
		if (x < 0) {
			throw new RuntimeException("Invalid coordinates!");
		}

		if (y < 0) {
			throw new RuntimeException("Invalid coordinates!");
		}

		if (x >= cells.length) {
			throw new RuntimeException("Invalid coordinates!");
		}

		if (y >= cells[x].length) {
			throw new RuntimeException("Invalid coordinates!");
		}

		if (cells[x][y].piece() == null) {
			return true;
		}

		return false;
	}

	/**
	 * Check for cell allowed for setup.
	 *
	 * @param x Index of a column on the board.
	 * @param y Index of a row on the board.
	 * @return True if the cell is allowed, false otherwise.
	 * @throws RuntimeException Thrown when cell is out of the board.
	 */
	public boolean isSetupable(int x, int y) throws RuntimeException {
		if (true) throw new RuntimeException("Unit test needed!");

		if (x < 0) {
			throw new RuntimeException("Invalid coordinates!");
		}

		if (y < 0) {
			throw new RuntimeException("Invalid coordinates!");
		}

		if (x >= cells.length) {
			throw new RuntimeException("Invalid coordinates!");
		}

		if (y >= cells[x].length) {
			throw new RuntimeException("Invalid coordinates!");
		}

		if (isEmpty(x, y) == false) {
			return false;
		}

		//TODO It depends of the player.

		return false;
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
		if (flag.rank() != Piece.Rank.FLAG) {
			if (flag.color() == Piece.Color.RED) {
				flag = RED_FLAG;
			}
			if (flag.color() == Piece.Color.BLUE) {
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
		if (player == null) {
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
	 * @param x     Column index.
	 * @param y     Row index.
	 * @return True if the placement is successful, false otherwise.
	 * @throws RuntimeException Invalid placement.
	 */
	public boolean place(Piece piece, int x, int y) throws RuntimeException {
		if (piece == null) {
			throw new RuntimeException("Invalid piece!");
		}

		if (x < 0) {
			throw new RuntimeException("Invalid coordinates!");
		}

		if (y < 0) {
			throw new RuntimeException("Invalid coordinates!");
		}

		if (x >= cells.length) {
			throw new RuntimeException("Invalid coordinates!");
		}

		if (y >= cells[x].length) {
			throw new RuntimeException("Invalid coordinates!");
		}

		/* Lakes are forbidden territory. */
		if (cells[x][y].territory() == Cell.Territory.LAKE) {
			return false;
		}

		/* Occupied cell is forbidden for placement. */
		if (cells[x][y].piece() != null) {
			return false;
		}

		/* Only proper territory can be used for the placement. */
		if (cells[x][y].territory() == Cell.Territory.RED && piece.color() == Piece.Color.BLUE) {
			return false;
		} else if (cells[x][y].territory() == Cell.Territory.BLUE && piece.color() == Piece.Color.RED) {
			return false;
		}

		/* Place piece on the board. */
		cells[x][y].piece(piece);
		return true;
	}

	/**
	 * Remove piece from the board.
	 *
	 * @param x Column index.
	 * @param y Row index.
	 * @return True if the removement is successful, false otherwise.
	 * @throws RuntimeException Thrown for invalid coordinates.
	 */
	public boolean remove(int x, int y) throws RuntimeException {
		if (x < 0) {
			throw new RuntimeException("Invalid coordinates!");
		}

		if (y < 0) {
			throw new RuntimeException("Invalid coordinates!");
		}

		if (x >= cells.length) {
			throw new RuntimeException("Invalid coordinates!");
		}

		if (y >= cells[x].length) {
			throw new RuntimeException("Invalid coordinates!");
		}

		/* If there is no piece there is nothing to remove. */
		if (cells[x][y].piece() == null) {
			return false;
		}

		/* Set a null pointer as remove procedure. */
		cells[x][y].piece(null);
		return true;
	}

	/**
	 * Do a single move during playing phase.
	 *
	 * @param piece  Piece to move.
	 * @param startX Start x position.
	 * @param startY Start y position.
	 * @param endX   End x position.
	 * @param endY   End y position.
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
	 * @return True if the click is successful, false otherwise.
	 * @throws RuntimeException Thrown for invalid coordinates.
	 */
	public boolean click(int x, int y) throws RuntimeException {
		if (true) throw new RuntimeException("Unit test needed!");

		if (x < 0) {
			throw new RuntimeException("Invalid coordinates!");
		}

		if (y < 0) {
			throw new RuntimeException("Invalid coordinates!");
		}

		if (x >= cells.length) {
			throw new RuntimeException("Invalid coordinates!");
		}

		if (y >= cells[x].length) {
			throw new RuntimeException("Invalid coordinates!");
		}

		switch (state) {
			case SETUP:
				break;
			case PLAY:
				break;
		}

		return false;
	}
}
