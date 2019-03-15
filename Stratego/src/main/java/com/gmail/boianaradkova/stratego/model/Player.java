package com.gmail.boianaradkova.stratego.model;

/**
 * Describe player on the board.
 *
 * @author Boyana Kantarska
 */
final class Player {
	/**
	 * Player's color.
	 */
	private Piece.Color color;

	/**
	 * The real name of the player.
	 */
	private String name;

	/**
	 * Constructor with parameters.
	 *
	 * @param name  Real name of the player.
	 * @param color Color of the player.
	 * @throws RuntimeException Thrown when player information is incorrect.
	 */
	public Player(String name, Piece.Color color) throws RuntimeException {
		//TODO Create own exception class.

		if (name == null) {
			throw new RuntimeException("Invalid player!");
		}

		if (color == null) {
			throw new RuntimeException("Invalid player!");
		}

		this.name = name;
		this.color = color;
	}

	/**
	 * Player's color getter.
	 *
	 * @return Reference to the color constant.
	 */
	public Piece.Color color() {
		return color;
	}

	/**
	 * Player's color setter.
	 *
	 * @param color Reference to the color constant.
	 * @throws RuntimeException Thrown for invalid color reference.
	 */
	public void color(Piece.Color color) throws RuntimeException {
		//TODO Create own exception class.

		if (color == null) {
			throw new RuntimeException("Invalid color constant!");
		}

		this.color = color;
	}

	/**
	 * Player's name getter.
	 *
	 * @return Player's name object reference.
	 */
	public String name() {
		return name;
	}

	/**
	 * Player's name setter.
	 *
	 * @param name Player's name object.
	 * @throws RuntimeException Thrown for invalid string object.
	 */
	public void name(String name) throws RuntimeException {
		//TODO Create own exception class.

		if (color == null) {
			throw new RuntimeException("Invalid string constant!");
		}

		this.name = name;
	}
}
