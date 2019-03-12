package com.gmail.boianaradkova.stratego.model;

/**
 * Object-oriented model of the game pieces.
 * <p>
 * Each player controls 40 pieces representing individual officer ranks in an army.
 *
 * @author Boyana Kantarska
 */
final class Piece {
	/**
	 * Each piece has rank as property.
	 */
	enum Rank {
		BOMB(Movement.FIXED),
		MARSHAL(Movement.SINGLE),
		GENERAL(Movement.SINGLE),
		COLONEL(Movement.SINGLE),
		MAJOR(Movement.SINGLE),
		CAPTAIN(Movement.SINGLE),
		LIEUTENANT(Movement.SINGLE),
		SERGEANT(Movement.SINGLE),
		SAPPER(Movement.SINGLE),
		SCOUT(Movement.MULTIPLE),
		SPY(Movement.SINGLE),
		FLAG(Movement.FIXED);

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
		 * Constrictor with parameters.
		 *
		 * @param movement Allowed movement.
		 */
		Rank(Movement movement) {
			this.movement = movement;
		}

		/**
		 * Movement getter.
		 *
		 * @return Movement object reference.
		 */
		public Movement movement() {
			return movement;
		}
	}

	/**
	 * Each piece has color as property.
	 */
	enum Color {
		RED,
		BLUE;
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
}
