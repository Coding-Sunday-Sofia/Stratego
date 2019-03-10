package com.gmail.boianaradkova.stratego;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.gmail.boianaradkova.stratego.model.Board;

/**
 * Game board screen.
 *
 * @author Boyana Kantarska
 */
public class BoardActivity extends AppCompatActivity {
	/** Drawable resources needed for an empty battlefield. */
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

	/** Keep references to image view controls. */
	private ImageView cells[][] = null;

	/** On cell click listener object. */
	private View.OnClickListener onCellClick = new View.OnClickListener() {
		/** {@inheritDoc} */
		@Override
		public void onClick(View view) {
			//TODO Find way to do unit testing.
			loops: for (int i = 0; i < cells.length; i++) {
				for (int j = 0; j < cells[i].length; j++) {
					/* If the view reference does not match do nothing. */
					if(view != cells[i][j]) {
						continue;
					}

					//Toast.makeText(BoardActivity.this, "Cell"+i+""+j,	Toast.LENGTH_SHORT).show();
					board.click(i, j);
					break loops;
				}
			}
		}
	};

	/** The game has a board. */
	private Board board = new Board();

	/** {@inheritDoc} */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_board);

		/* Obtain cells image references. */
		cells = new ImageView[][]{
			{findViewById(R.id.cell00), findViewById(R.id.cell10), findViewById(R.id.cell20), findViewById(R.id.cell30), findViewById(R.id.cell40), findViewById(R.id.cell50), findViewById(R.id.cell60), findViewById(R.id.cell70), findViewById(R.id.cell80), findViewById(R.id.cell90),},
			{findViewById(R.id.cell01), findViewById(R.id.cell11), findViewById(R.id.cell21), findViewById(R.id.cell31), findViewById(R.id.cell41), findViewById(R.id.cell51), findViewById(R.id.cell61), findViewById(R.id.cell71), findViewById(R.id.cell81), findViewById(R.id.cell91),},
			{findViewById(R.id.cell02), findViewById(R.id.cell12), findViewById(R.id.cell22), findViewById(R.id.cell32), findViewById(R.id.cell42), findViewById(R.id.cell52), findViewById(R.id.cell62), findViewById(R.id.cell72), findViewById(R.id.cell82), findViewById(R.id.cell92),},
			{findViewById(R.id.cell03), findViewById(R.id.cell13), findViewById(R.id.cell23), findViewById(R.id.cell33), findViewById(R.id.cell43), findViewById(R.id.cell53), findViewById(R.id.cell63), findViewById(R.id.cell73), findViewById(R.id.cell83), findViewById(R.id.cell93),},
			{findViewById(R.id.cell04), findViewById(R.id.cell14), findViewById(R.id.cell24), findViewById(R.id.cell34), findViewById(R.id.cell44), findViewById(R.id.cell54), findViewById(R.id.cell64), findViewById(R.id.cell74), findViewById(R.id.cell84), findViewById(R.id.cell94),},
			{findViewById(R.id.cell05), findViewById(R.id.cell15), findViewById(R.id.cell25), findViewById(R.id.cell35), findViewById(R.id.cell45), findViewById(R.id.cell55), findViewById(R.id.cell65), findViewById(R.id.cell75), findViewById(R.id.cell85), findViewById(R.id.cell95),},
			{findViewById(R.id.cell06), findViewById(R.id.cell16), findViewById(R.id.cell26), findViewById(R.id.cell36), findViewById(R.id.cell46), findViewById(R.id.cell56), findViewById(R.id.cell66), findViewById(R.id.cell76), findViewById(R.id.cell86), findViewById(R.id.cell96),},
			{findViewById(R.id.cell07), findViewById(R.id.cell17), findViewById(R.id.cell27), findViewById(R.id.cell37), findViewById(R.id.cell47), findViewById(R.id.cell57), findViewById(R.id.cell67), findViewById(R.id.cell77), findViewById(R.id.cell87), findViewById(R.id.cell97),},
			{findViewById(R.id.cell08), findViewById(R.id.cell18), findViewById(R.id.cell28), findViewById(R.id.cell38), findViewById(R.id.cell48), findViewById(R.id.cell58), findViewById(R.id.cell68), findViewById(R.id.cell78), findViewById(R.id.cell88), findViewById(R.id.cell98),},
			{findViewById(R.id.cell09), findViewById(R.id.cell19), findViewById(R.id.cell29), findViewById(R.id.cell39), findViewById(R.id.cell49), findViewById(R.id.cell59), findViewById(R.id.cell69), findViewById(R.id.cell79), findViewById(R.id.cell89), findViewById(R.id.cell99),},
		};

		/* Attach of the cells click listener object. */
		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells[i].length; j++) {
				cells[i][j].setOnClickListener(onCellClick);
			}
		}
	}
}
