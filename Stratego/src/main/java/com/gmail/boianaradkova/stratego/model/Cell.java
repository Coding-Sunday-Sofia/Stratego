package com.gmail.boianaradkova.stratego.model;

/**
 * The board has many cells.
 *
 * @author Boyana Kantarska
 */
final class Cell {
	/**
	 * What kind of cell.
	 */
	enum Kind {
		LAKE,
		CENTRAL,
		BORDER,
	};

	/**
	 * What kind of cell is this one.
	 */
	private Kind kind;

	/**
	 * Holds reference to a particular piece or null pointer if the cell is empty.
	 */
	private Piece piece = null;

	/**
	 * Constructor with all necessary parameters.
	 *
	 * @param kind What kind of cell.
	 */
	public Cell(Kind kind) {
		this.kind = kind;
	}

	/**
	 * Piece reference getter.
	 *
	 * @return Reference to the particular piece over this cell.
	 */
	public Piece piece() {
		return piece;
	}

	/**
	 * Piece reference setter.
	 *
	 * @param piece Piece which should stay in the cell.
	 */
	public void piece(Piece piece) {
		this.piece = piece;
	}
}
