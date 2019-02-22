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
	 * All pieces available on the board are stored as Java objects in a single collection.
	 */
	private static final List<Piece> PIECES = new ArrayList<Piece>();

	/*
	 * Initialization of the the static fields.
	 */
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
		PIECES.add(new Piece(Piece.Color.RED, Piece.Rank.FLAG));
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
		PIECES.add(new Piece(Piece.Color.BLUE, Piece.Rank.FLAG));
	}
}
