package com.gmail.boianaradkova.stratego.model;

/**
 * Object-oriented model of the game pieces.
 * <p>
 * Each player controls 40 pieces representing individual officer ranks in an army.
 *
 * @author Boyana Kantarska
 */
final class Piece {
	/** Each piece has rank as property. */
	enum Rank {
		BOMB,
		MARSHAL,
		GENERAL,
		COLONEL,
		MAJOR,
		CAPTAIN,
		LIEUTENANT,
		SERGEANT,
		SAPPER,
		SCOUT,
		SPY,
		FLAG,
	}

	/** Each piece has color as property. */
	enum Color {
		RED,
		BLUE,
	}

	/** Piece color property. */
	private final Color color;


	/** Piece rank property. */
	private final Rank rank;

	/**
	 * Constructor with all parameters.
	 * <p>
	 * It is used as master setter.
	 *
	 * @param color Color of the piece.
	 * @param rank  Rank of the piece.
	 *
	 * @throws RuntimeException Thrown when it is illegal to create the piece.
	 */
	public Piece(Color color, Rank rank) throws RuntimeException {
		//TODO Create own exception class.

		if(color == null) {
			throw new RuntimeException("Invalid piece!");
		}

		if(rank == null) {
			throw new RuntimeException("Invalid piece!");
		}

		this.color = color;
		this.rank = rank;
	}

	/**
	 * Color getter.
	 *
	 * @return Color object reference.
	 */
	public Color color() {
		return color;
	}

	/**
	 * Rank getter.
	 *
	 * @return Rank object reference.
	 */
	public Rank rank() {
		return rank;
	}
}
