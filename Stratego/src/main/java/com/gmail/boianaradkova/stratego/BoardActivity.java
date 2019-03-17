package com.gmail.boianaradkova.stratego;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.gmail.boianaradkova.stratego.model.Board;

/**
 * Game board screen.
 *
 * @author Boyana Kantarska
 */
public class BoardActivity extends Activity {
	/**
	 * Drawable resources needed for an empty battlefield.
	 */
	private final int EMPTY_FIELD_DRAWABLES[][] = {
					{R.drawable.grass1, R.drawable.grass1, R.drawable.grass1, R.drawable.grass1, R.drawable.grass2, R.drawable.grass2, R.drawable.grass1, R.drawable.grass1, R.drawable.grass1, R.drawable.grass1,},
					{R.drawable.grass1, R.drawable.grass1, R.drawable.grass1, R.drawable.grass1, R.drawable.grass2, R.drawable.grass2, R.drawable.grass1, R.drawable.grass1, R.drawable.grass1, R.drawable.grass1,},
					{R.drawable.grass1, R.drawable.grass1, R.drawable.grass1, R.drawable.grass1, R.drawable.lake11, R.drawable.lake13, R.drawable.grass1, R.drawable.grass1, R.drawable.grass1, R.drawable.grass1,},
					{R.drawable.grass1, R.drawable.grass1, R.drawable.grass1, R.drawable.grass1, R.drawable.lake12, R.drawable.lake14, R.drawable.grass1, R.drawable.grass1, R.drawable.grass1, R.drawable.grass1,},
					{R.drawable.grass1, R.drawable.grass1, R.drawable.grass1, R.drawable.grass1, R.drawable.grass2, R.drawable.grass2, R.drawable.grass1, R.drawable.grass1, R.drawable.grass1, R.drawable.grass1,},
					{R.drawable.grass1, R.drawable.grass1, R.drawable.grass1, R.drawable.grass1, R.drawable.grass2, R.drawable.grass2, R.drawable.grass1, R.drawable.grass1, R.drawable.grass1, R.drawable.grass1,},
					{R.drawable.grass1, R.drawable.grass1, R.drawable.grass1, R.drawable.grass1, R.drawable.lake21, R.drawable.lake23, R.drawable.grass1, R.drawable.grass1, R.drawable.grass1, R.drawable.grass1,},
					{R.drawable.grass1, R.drawable.grass1, R.drawable.grass1, R.drawable.grass1, R.drawable.lake22, R.drawable.lake24, R.drawable.grass1, R.drawable.grass1, R.drawable.grass1, R.drawable.grass1,},
					{R.drawable.grass1, R.drawable.grass1, R.drawable.grass1, R.drawable.grass1, R.drawable.grass2, R.drawable.grass2, R.drawable.grass1, R.drawable.grass1, R.drawable.grass1, R.drawable.grass1,},
					{R.drawable.grass1, R.drawable.grass1, R.drawable.grass1, R.drawable.grass1, R.drawable.grass2, R.drawable.grass2, R.drawable.grass1, R.drawable.grass1, R.drawable.grass1, R.drawable.grass1,},
	};

	/**
	 * Keep references to image view controls.
	 */
	private ImageView cells[][] = null;

	/**
	 * Coordinates of the last clicked cell.
	 */
	private Point lastClicked = null;

	/**
	 * On cell click listener object.
	 */
	private View.OnClickListener onCellClick = new View.OnClickListener() {
		/** {@inheritDoc} */
		@Override
		public void onClick(View view) {
			//TODO Find way to do unit testing.
			loops:
			for (int i = 0; i < cells.length; i++) {
				for (int j = 0; j < cells[i].length; j++) {
					/* If the view reference does not match do nothing. */
					if (view != cells[i][j]) {
						continue;
					}

					//Toast.makeText(BoardActivity.this, "Cell"+i+""+j,	Toast.LENGTH_SHORT).show();

					if (board.state() == Board.State.SETUP && board.isSetupable(i, j) == true) {
						lastClicked = new Point(i, j);
						//TODO Show list with the available pieces.
					} else {
						board.click(i, j);
					}

					break loops;
				}
			}
		}
	};

	/**
	 * The game has a board.
	 */
	private Board board = new Board();

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_board);

		/* Obtain cells image references. */
		cells = new ImageView[][]{
						{(ImageView) findViewById(R.id.cell00), (ImageView) findViewById(R.id.cell10), (ImageView) findViewById(R.id.cell20), (ImageView) findViewById(R.id.cell30), (ImageView) findViewById(R.id.cell40), (ImageView) findViewById(R.id.cell50), (ImageView) findViewById(R.id.cell60), (ImageView) findViewById(R.id.cell70), (ImageView) findViewById(R.id.cell80), (ImageView) findViewById(R.id.cell90),},
						{(ImageView) findViewById(R.id.cell01), (ImageView) findViewById(R.id.cell11), (ImageView) findViewById(R.id.cell21), (ImageView) findViewById(R.id.cell31), (ImageView) findViewById(R.id.cell41), (ImageView) findViewById(R.id.cell51), (ImageView) findViewById(R.id.cell61), (ImageView) findViewById(R.id.cell71), (ImageView) findViewById(R.id.cell81), (ImageView) findViewById(R.id.cell91),},
						{(ImageView) findViewById(R.id.cell02), (ImageView) findViewById(R.id.cell12), (ImageView) findViewById(R.id.cell22), (ImageView) findViewById(R.id.cell32), (ImageView) findViewById(R.id.cell42), (ImageView) findViewById(R.id.cell52), (ImageView) findViewById(R.id.cell62), (ImageView) findViewById(R.id.cell72), (ImageView) findViewById(R.id.cell82), (ImageView) findViewById(R.id.cell92),},
						{(ImageView) findViewById(R.id.cell03), (ImageView) findViewById(R.id.cell13), (ImageView) findViewById(R.id.cell23), (ImageView) findViewById(R.id.cell33), (ImageView) findViewById(R.id.cell43), (ImageView) findViewById(R.id.cell53), (ImageView) findViewById(R.id.cell63), (ImageView) findViewById(R.id.cell73), (ImageView) findViewById(R.id.cell83), (ImageView) findViewById(R.id.cell93),},
						{(ImageView) findViewById(R.id.cell04), (ImageView) findViewById(R.id.cell14), (ImageView) findViewById(R.id.cell24), (ImageView) findViewById(R.id.cell34), (ImageView) findViewById(R.id.cell44), (ImageView) findViewById(R.id.cell54), (ImageView) findViewById(R.id.cell64), (ImageView) findViewById(R.id.cell74), (ImageView) findViewById(R.id.cell84), (ImageView) findViewById(R.id.cell94),},
						{(ImageView) findViewById(R.id.cell05), (ImageView) findViewById(R.id.cell15), (ImageView) findViewById(R.id.cell25), (ImageView) findViewById(R.id.cell35), (ImageView) findViewById(R.id.cell45), (ImageView) findViewById(R.id.cell55), (ImageView) findViewById(R.id.cell65), (ImageView) findViewById(R.id.cell75), (ImageView) findViewById(R.id.cell85), (ImageView) findViewById(R.id.cell95),},
						{(ImageView) findViewById(R.id.cell06), (ImageView) findViewById(R.id.cell16), (ImageView) findViewById(R.id.cell26), (ImageView) findViewById(R.id.cell36), (ImageView) findViewById(R.id.cell46), (ImageView) findViewById(R.id.cell56), (ImageView) findViewById(R.id.cell66), (ImageView) findViewById(R.id.cell76), (ImageView) findViewById(R.id.cell86), (ImageView) findViewById(R.id.cell96),},
						{(ImageView) findViewById(R.id.cell07), (ImageView) findViewById(R.id.cell17), (ImageView) findViewById(R.id.cell27), (ImageView) findViewById(R.id.cell37), (ImageView) findViewById(R.id.cell47), (ImageView) findViewById(R.id.cell57), (ImageView) findViewById(R.id.cell67), (ImageView) findViewById(R.id.cell77), (ImageView) findViewById(R.id.cell87), (ImageView) findViewById(R.id.cell97),},
						{(ImageView) findViewById(R.id.cell08), (ImageView) findViewById(R.id.cell18), (ImageView) findViewById(R.id.cell28), (ImageView) findViewById(R.id.cell38), (ImageView) findViewById(R.id.cell48), (ImageView) findViewById(R.id.cell58), (ImageView) findViewById(R.id.cell68), (ImageView) findViewById(R.id.cell78), (ImageView) findViewById(R.id.cell88), (ImageView) findViewById(R.id.cell98),},
						{(ImageView) findViewById(R.id.cell09), (ImageView) findViewById(R.id.cell19), (ImageView) findViewById(R.id.cell29), (ImageView) findViewById(R.id.cell39), (ImageView) findViewById(R.id.cell49), (ImageView) findViewById(R.id.cell59), (ImageView) findViewById(R.id.cell69), (ImageView) findViewById(R.id.cell79), (ImageView) findViewById(R.id.cell89), (ImageView) findViewById(R.id.cell99),},
		};

		/* Attach of the cells click listener object. */
		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells[i].length; j++) {
				cells[i][j].setOnClickListener(onCellClick);
			}
		}
	}
}
