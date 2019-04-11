package com.gmail.boianaradkova.stratego;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * List of available for placement pieces.
 *
 * @author Boyana Kantarska
 */
public class PiecesActivity extends Activity {

	/**
	 * Selected pieces key for the intent extra.
	 */
	static final String SELECTED_KEY = "selected";

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		//TODO if (true) throw new RuntimeException("Unit test needed!");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pieces);

		//TODO Use list of images instead of list of abbreviations.

		ListView list = (ListView) findViewById(R.id.available_pieces);
		final ArrayList<String> values = getIntent().getStringArrayListExtra(BoardActivity.PIECES_KEY);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, values);
		list.setAdapter(adapter);

		/* Item select event handler. */
		list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			/**
			 * {@inheritDoc}
			 */
			@Override
			public void onItemClick(AdapterView<?> adapter, View view, int i, long l) {
				Intent intent = new Intent();
				intent.putExtra(SELECTED_KEY, values.get(i));
				setResult(Activity.RESULT_OK, intent);
				PiecesActivity.this.finish();
			}
		});
	}
}
