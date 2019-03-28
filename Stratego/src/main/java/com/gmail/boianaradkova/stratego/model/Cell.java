package com.gmail.boianaradkova.stratego.model;

/**
 * The board has many cells.
 *
 * @author Boyana Kantarska
 */
public final class Cell {
	/**
	 * What kind of cell.
	 */
	enum Territory {
		LAKE("L"),
		NEUTRAL("N"),
		RED("R"),
		BLUE("B");

		/**
		 * Letter for territory representation.
		 */
		private String letter;

		/**
		 * Constructor with parameters.
		 *
		 * @param letter Letter for the territory.
		 */
		Territory(String letter) {
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

	;

	/**
	 * What kind of cell is this one.
	 */
	private Territory territory;

	/**
	 * Holds reference to a particular piece or null pointer if the cell is empty.
	 */
	private Piece piece = null;

	/**
	 * Constructor with all necessary parameters.
	 *
	 * @param territory What kind of cell.
	 */
	public Cell(Territory territory) {
		this.territory = territory;
	}

	/**
	 * Territory getter.
	 *
	 * @return Territory constant.
	 */
	public Territory territory() {
		//TODO if (true) throw new RuntimeException("Unit test needed!");
		return territory;
	}

	/**
	 * Territory setter.
	 *
	 * @param territory Territory constant.
	 */
	public void territory(Territory territory) {
		if (true) throw new RuntimeException("Unit test needed!");
		this.territory = territory;
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

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		//TODO if (true) throw new RuntimeException("Unit test needed!");
		return "" + territory.letter() + ((piece == null) ? ("__") : ("" + piece.rank().letter() + piece.color().letter()));
	}
}
