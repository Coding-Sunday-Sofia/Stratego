package com.gmail.boianaradkova.stratego;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.gmail.boianaradkova.stratego.model.Board;
import com.gmail.boianaradkova.stratego.model.Cell;
import com.gmail.boianaradkova.stratego.model.Piece;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.gmail.boianaradkova.stratego.model.Board.PIECES;

/**
 * Game board screen.
 *
 * @author Boyana Kantarska
 */
public class BoardActivity extends Activity {
    /**
     * Drawable resources needed for an empty battlefield.
     */
    private static final int EMPTY_FIELD_DRAWABLES[][] = {
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
     * Drawable resources for the pieces.
     */
    private static final Map<Piece, Integer> PIECES_DRAWABLES = new HashMap<>();

    /**
     * Pick piece request code.
     */
    static final int PICK_PIECE_REQUEST = 1;

    /**
     * Pieces key for the intent extra.
     */
    static final String PIECES_KEY = "pieces";

    /**
     * Keep references to image view controls.
     */
    private ImageView cellView[][] = null;

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
            for (int i = 0; i < cellView.length; i++) {
                for (int j = 0; j < cellView[i].length; j++) {
                    /* If the view reference does not match do nothing. */
                    if (view != cellView[i][j]) {
                        continue;
                    }

                    /* It is used only for testing. */
                    Toast.makeText(BoardActivity.this, "Cell" + i + "" + j, Toast.LENGTH_SHORT).show();
                    /* It is used only for testing. */

                    if (board.click(i, j) == true) {
                        lastClicked = new Point(i, j);
                    }

                    break loops;
                }
            }

            /* Redraw GUI after model action. */
            updateViews();
        }
    };

    /**
     * The game has a board.
     */
    private Board board = new Board();

    /* Initialization of the the static fields. */
    static {
        PIECES_DRAWABLES.put(PIECES.get(0), R.drawable.red_bomb);
        PIECES_DRAWABLES.put(PIECES.get(1), R.drawable.red_bomb);
        PIECES_DRAWABLES.put(PIECES.get(2), R.drawable.red_bomb);
        PIECES_DRAWABLES.put(PIECES.get(3), R.drawable.red_bomb);
        PIECES_DRAWABLES.put(PIECES.get(4), R.drawable.red_bomb);
        PIECES_DRAWABLES.put(PIECES.get(5), R.drawable.red_bomb);

        PIECES_DRAWABLES.put(PIECES.get(6), R.drawable.red_10);

        PIECES_DRAWABLES.put(PIECES.get(7), R.drawable.red_09);

        PIECES_DRAWABLES.put(PIECES.get(8), R.drawable.red_08);
        PIECES_DRAWABLES.put(PIECES.get(9), R.drawable.red_08);

        PIECES_DRAWABLES.put(PIECES.get(10), R.drawable.red_07);
        PIECES_DRAWABLES.put(PIECES.get(11), R.drawable.red_07);
        PIECES_DRAWABLES.put(PIECES.get(12), R.drawable.red_07);

        PIECES_DRAWABLES.put(PIECES.get(13), R.drawable.red_06);
        PIECES_DRAWABLES.put(PIECES.get(14), R.drawable.red_06);
        PIECES_DRAWABLES.put(PIECES.get(15), R.drawable.red_06);
        PIECES_DRAWABLES.put(PIECES.get(16), R.drawable.red_06);

        PIECES_DRAWABLES.put(PIECES.get(17), R.drawable.red_05);
        PIECES_DRAWABLES.put(PIECES.get(18), R.drawable.red_05);
        PIECES_DRAWABLES.put(PIECES.get(19), R.drawable.red_05);
        PIECES_DRAWABLES.put(PIECES.get(20), R.drawable.red_05);

        PIECES_DRAWABLES.put(PIECES.get(21), R.drawable.red_04);
        PIECES_DRAWABLES.put(PIECES.get(22), R.drawable.red_04);
        PIECES_DRAWABLES.put(PIECES.get(23), R.drawable.red_04);
        PIECES_DRAWABLES.put(PIECES.get(24), R.drawable.red_04);

        PIECES_DRAWABLES.put(PIECES.get(25), R.drawable.red_03);
        PIECES_DRAWABLES.put(PIECES.get(26), R.drawable.red_03);
        PIECES_DRAWABLES.put(PIECES.get(27), R.drawable.red_03);
        PIECES_DRAWABLES.put(PIECES.get(28), R.drawable.red_03);
        PIECES_DRAWABLES.put(PIECES.get(29), R.drawable.red_03);

        PIECES_DRAWABLES.put(PIECES.get(30), R.drawable.red_02);
        PIECES_DRAWABLES.put(PIECES.get(31), R.drawable.red_02);
        PIECES_DRAWABLES.put(PIECES.get(32), R.drawable.red_02);
        PIECES_DRAWABLES.put(PIECES.get(33), R.drawable.red_02);
        PIECES_DRAWABLES.put(PIECES.get(34), R.drawable.red_02);
        PIECES_DRAWABLES.put(PIECES.get(35), R.drawable.red_02);
        PIECES_DRAWABLES.put(PIECES.get(36), R.drawable.red_02);
        PIECES_DRAWABLES.put(PIECES.get(37), R.drawable.red_02);

        PIECES_DRAWABLES.put(PIECES.get(38), R.drawable.red_spy);

        PIECES_DRAWABLES.put(PIECES.get(39), R.drawable.red_flag);

        PIECES_DRAWABLES.put(PIECES.get(40), R.drawable.blue_bomb);
        PIECES_DRAWABLES.put(PIECES.get(41), R.drawable.blue_bomb);
        PIECES_DRAWABLES.put(PIECES.get(42), R.drawable.blue_bomb);
        PIECES_DRAWABLES.put(PIECES.get(43), R.drawable.blue_bomb);
        PIECES_DRAWABLES.put(PIECES.get(44), R.drawable.blue_bomb);
        PIECES_DRAWABLES.put(PIECES.get(45), R.drawable.blue_bomb);

        PIECES_DRAWABLES.put(PIECES.get(46), R.drawable.blue_10);

        PIECES_DRAWABLES.put(PIECES.get(47), R.drawable.blue_09);

        PIECES_DRAWABLES.put(PIECES.get(48), R.drawable.blue_08);
        PIECES_DRAWABLES.put(PIECES.get(49), R.drawable.blue_08);

        PIECES_DRAWABLES.put(PIECES.get(50), R.drawable.blue_07);
        PIECES_DRAWABLES.put(PIECES.get(51), R.drawable.blue_07);
        PIECES_DRAWABLES.put(PIECES.get(52), R.drawable.blue_07);

        PIECES_DRAWABLES.put(PIECES.get(53), R.drawable.blue_06);
        PIECES_DRAWABLES.put(PIECES.get(54), R.drawable.blue_06);
        PIECES_DRAWABLES.put(PIECES.get(55), R.drawable.blue_06);
        PIECES_DRAWABLES.put(PIECES.get(56), R.drawable.blue_06);

        PIECES_DRAWABLES.put(PIECES.get(57), R.drawable.blue_05);
        PIECES_DRAWABLES.put(PIECES.get(58), R.drawable.blue_05);
        PIECES_DRAWABLES.put(PIECES.get(59), R.drawable.blue_05);
        PIECES_DRAWABLES.put(PIECES.get(60), R.drawable.blue_05);

        PIECES_DRAWABLES.put(PIECES.get(61), R.drawable.blue_04);
        PIECES_DRAWABLES.put(PIECES.get(62), R.drawable.blue_04);
        PIECES_DRAWABLES.put(PIECES.get(63), R.drawable.blue_04);
        PIECES_DRAWABLES.put(PIECES.get(64), R.drawable.blue_04);

        PIECES_DRAWABLES.put(PIECES.get(65), R.drawable.blue_03);
        PIECES_DRAWABLES.put(PIECES.get(66), R.drawable.blue_03);
        PIECES_DRAWABLES.put(PIECES.get(67), R.drawable.blue_03);
        PIECES_DRAWABLES.put(PIECES.get(68), R.drawable.blue_03);
        PIECES_DRAWABLES.put(PIECES.get(69), R.drawable.blue_03);

        PIECES_DRAWABLES.put(PIECES.get(70), R.drawable.blue_02);
        PIECES_DRAWABLES.put(PIECES.get(71), R.drawable.blue_02);
        PIECES_DRAWABLES.put(PIECES.get(72), R.drawable.blue_02);
        PIECES_DRAWABLES.put(PIECES.get(73), R.drawable.blue_02);
        PIECES_DRAWABLES.put(PIECES.get(74), R.drawable.blue_02);
        PIECES_DRAWABLES.put(PIECES.get(75), R.drawable.blue_02);
        PIECES_DRAWABLES.put(PIECES.get(76), R.drawable.blue_02);
        PIECES_DRAWABLES.put(PIECES.get(77), R.drawable.blue_02);

        PIECES_DRAWABLES.put(PIECES.get(78), R.drawable.blue_spy);

        PIECES_DRAWABLES.put(PIECES.get(79), R.drawable.blue_flag);
    }

    /**
     * Update all visual components.
     */
    private void updateViews() {
        //TODO if (true) throw new RuntimeException("Unit test needed!");

        /* Reset alpha values to all image views. */
        for (View[] views : cellView) {
            for (View image : views) {
                image.setAlpha(1.0F);
            }
        }

        Cell[][] cells = board.cells();
       for (int x = 0; x < cells.length && x < cellView.length; x++) {
            for (int y = 0; y < cells[x].length && y < cellView[x].length; y++) {
                cellView[x][y].setImageResource(EMPTY_FIELD_DRAWABLES[x][y]);

                /* If the cell is empty use the background image only. */
                if (board.isEmpty(x, y) == true) {
                    continue;
                }

                /* Draw nothing for null pointers. */
                Piece piece = cells[x][y].piece();
                if (piece == null) {
                    continue;
                }

                /* Draw piece. */
                Drawable[] layers = {getResources().getDrawable(EMPTY_FIELD_DRAWABLES[x][y]), getResources().getDrawable(PIECES_DRAWABLES.get(piece))};
                cellView[x][y].setImageDrawable(new LayerDrawable(layers));
            }
        }

        /* Mark the selected piece. */
        if (board.state() == Board.State.PLAY && board.hasSelectedCell() == true) {
            cellView[lastClicked.x][lastClicked.y].setAlpha(0.5F);
        }

        /* Call dialog with the available pieces. */
        if (board.state() == Board.State.SETUP && board.hasSelectedCell() == true) {
            Intent intent = new Intent(this, PiecesActivity.class);

            /* Transform all pieces into text information. */
            ArrayList<String> values = new ArrayList<>();
            for (Piece piece : board.unused()) {
                values.add(piece.toString());
            }

            /* Call another activity. */
            intent.putExtra(PIECES_KEY, values);
            startActivityForResult(intent, PICK_PIECE_REQUEST);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //TODO if (true) throw new RuntimeException("Unit test needed!");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);

        /* Obtain cells image references. */
        cellView = new ImageView[][]{
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
        for (int i = 0; i < cellView.length; i++) {
            for (int j = 0; j < cellView[i].length; j++) {
                cellView[i][j].setOnClickListener(onCellClick);
            }
        }

        /* Initial draw of GUI. */
        updateViews();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onActivityResult(int request, int result, Intent data) {
        //TODO if (true) throw new RuntimeException("Unit test needed!");
        if (request == PICK_PIECE_REQUEST) {
            if (result == Activity.RESULT_OK) {
                String value = data.getStringExtra(PiecesActivity.SELECTED_KEY);
                Piece piece = board.findAvailablePiece(value);

                if (board.place(piece) == false) {
                    board.hasSelectedCell(false);
                }

                if (board.setupFinish() == true) {
                    Toast.makeText(BoardActivity.this, getString(R.string.sart_playing_text), Toast.LENGTH_SHORT).show();
                }
            }

            if (result == Activity.RESULT_CANCELED) {
                board.hasSelectedCell(false);
            }
        }

        updateViews();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.board_option_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.new_game:
                board.reset();
                Toast.makeText(BoardActivity.this, getString(R.string.setup_board_text), Toast.LENGTH_SHORT).show();
                /* It is used only for testing. */
                board.randomSetup();
                board.setupFinish();
                /* It is used only for testing. */
                updateViews();
                break;
            case R.id.help:
                startActivity(new Intent(BoardActivity.this, HelpActivity.class));
                break;
            case R.id.about:
                startActivity(new Intent(BoardActivity.this, AboutActivity.class));
                break;
        }
        return true;
    }
}
