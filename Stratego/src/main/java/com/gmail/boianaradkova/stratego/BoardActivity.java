package com.gmail.boianaradkova.stratego;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.gmail.boianaradkova.stratego.model.Board;

/**
 * Game board screen.
 *
 * @author Boyana Kantarska
 */
public class BoardActivity extends AppCompatActivity {
	/**
	 * The game has a board.
	 */
	//private Board board = new Board();

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_board);
	}
}
