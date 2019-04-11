package com.gmail.boianaradkova.stratego.model;

/**
 * Object-oriented model of the game pieces.
 * <p>
 * Each player controls 40 pieces representing individual officer ranks in an army.
 *
 * @author Boyana Kantarska
 */
public final class Piece {
	/**
	 * Each piece has rank as property.
	 */
	enum Rank {
		BOMB(Movement.FIXED, "B"),
		MARSHAL(Movement.SINGLE, "M"),
		GENERAL(Movement.SINGLE, "G"),
		COLONEL(Movement.SINGLE, "C"),
		MAJOR(Movement.SINGLE, "J"),
		CAPTAIN(Movement.SINGLE, "C"),
		LIEUTENANT(Movement.SINGLE, "L"),
		SERGEANT(Movement.SINGLE, "S"),
		SAPPER(Movement.SINGLE, "P"),
		SCOUT(Movement.MULTIPLE, "T"),
		SPY(Movement.SINGLE, "Y"),
		FLAG(Movement.FIXED, "F");

		/**
		 * All possible movement strategies.
		 */
		enum Movement {
			FIXED(new boolean[][]{
							{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,},
							{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,},
							{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,},
							{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,},
							{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,},
							{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,},
							{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,},
							{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,},
							{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,},
							{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,},
							{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,},
							{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,},
							{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,},
							{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,},
							{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,},
							{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,},
							{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,},
							{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,},
							{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,},
			}),

			SINGLE(new boolean[][]{
							{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,},
							{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,},
							{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,},
							{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,},
							{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,},
							{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,},
							{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,},
							{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,},
							{false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false,},
							{false, false, false, false, false, false, false, false, true, false, true, false, false, false, false, false, false, false, false,},
							{false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false,},
							{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,},
							{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,},
							{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,},
							{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,},
							{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,},
							{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,},
							{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,},
							{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,},
			}),

			MULTIPLE(new boolean[][]{
							{false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false,},
							{false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false,},
							{false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false,},
							{false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false,},
							{false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false,},
							{false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false,},
							{false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false,},
							{false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false,},
							{false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false,},
							{true, true, true, true, true, true, true, true, true, false, true, true, true, true, true, true, true, true, true,},
							{false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false,},
							{false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false,},
							{false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false,},
							{false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false,},
							{false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false,},
							{false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false,},
							{false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false,},
							{false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false,},
							{false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false,},
			});

			/**
			 * Matrix with allowed moves with true value.
			 */
			private boolean[][] allowed;

			/**
			 * Constructor with parameters.
			 *
			 * @param allowed Matrix with the allowed moves.
			 */
			Movement(boolean[][] allowed) {
				this.allowed = allowed;
			}

			/**
			 * Allowed moves getter.
			 *
			 * @return Array reference to the allowed moves matrix.
			 */
			public boolean[][] allowed() {
				return allowed;
			}
		}

		/**
		 * Piece movement property.
		 */
		private final Movement movement;

		/**
		 * Piece letter representation.
		 */
		private String letter;

		/**
		 * Constrictor with parameters.
		 *
		 * @param movement Allowed movement.
		 * @param letter   Letter representation.
		 */
		Rank(Movement movement, String letter) {
			this.movement = movement;
			this.letter = letter;
		}

		/**
		 * Movement getter.
		 *
		 * @return Movement object reference.
		 */
		Movement movement() {
			return movement;
		}

		/**
		 * Letter getter.
		 *
		 * @return Territory letter.
		 */
		public String letter() {
			return letter;
		}
	}

	/**
	 * Each piece has color as property.
	 */
	enum Color {
		RED("R"),
		BLUE("B");

		/**
		 * Piece color letter.
		 */
		private String letter;

		/**
		 * Constructor with parameters.
		 *
		 * @param letter Letter representation of the color.
		 */
		Color(String letter) {
			this.letter = letter;
		}

		/**
		 * Letter getter.
		 *
		 * @return Territory letter.
		 */
		public String letter() {
			return letter;
		}
	}

	/**
	 * Piece color property.
	 */
	private final Color color;


	/**
	 * Piece rank property.
	 */
	private final Rank rank;

	/**
	 * Constructor with all parameters.
	 * <p>
	 * It is used as master setter.
	 *
	 * @param color Color of the piece.
	 * @param rank  Rank of the piece.
	 * @throws RuntimeException Thrown when it is illegal to create the piece.
	 */
	public Piece(Color color, Rank rank) throws RuntimeException {
		//TODO Create own exception class.

		if (color == null) {
			throw new RuntimeException("Invalid piece!");
		}

		if (rank == null) {
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

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		//TODO if (true) throw new RuntimeException("Unit test needed!");
		return "" + rank().letter() + color().letter();
	}
}
