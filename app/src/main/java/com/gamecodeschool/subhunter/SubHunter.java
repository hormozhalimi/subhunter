package com.gamecodeschool.subhunter;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.graphics.Paint;

public class SubHunter extends Activity {
    private GameEngine gameEngine;
    private GameDrawer gameDrawer;
    private Grid grid;
    private Submarine submarine;
    private DebuggingTest debuggingTest;
    private int blockSize;
    private int gridWidth =  40;
    private int gridHeight;
    private boolean debugging = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Get the current device's screen resolution
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        // Initialize our size based variables based on the screen resolution
        int numberHorizontalPixels = size.x;
        int numberVerticalPixels = size.y;
        blockSize = numberHorizontalPixels / gridWidth;
        gridHeight = numberVerticalPixels / blockSize;

        // Initialize all the objects ready for drawing
        Bitmap blankBitmap = Bitmap.createBitmap(numberHorizontalPixels, numberVerticalPixels, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(blankBitmap);
        Paint paint = new Paint();
        ImageView gameView = new ImageView(this);

        // Initialize gameEngine, gameDrawer, grid, submarine, and debuggingTest
        gameEngine = new GameEngine();
        gameDrawer = new GameDrawer(gameView, blankBitmap, canvas, paint, blockSize, gridWidth, gridHeight);
        grid = GridFactory.createGrid(gridWidth, gridHeight);
        submarine = new Submarine(gameEngine.getSubHorizontalPosition(), gameEngine.getSubVerticalPosition());
        debuggingTest = new DebuggingTest();

        // Set the content view to the gameView from gameDrawer
        setContentView(gameView);

        // Start a new game
        gameEngine.newGame();

        // Draw the initial state of the game
        gameDrawer.drawGrid();
        gameDrawer.drawHUD(gameEngine.getShotsTaken(), gameEngine.getDistanceFromSub());
        gameDrawer.updateView();
    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & MotionEvent.ACTION_MASK) == MotionEvent.ACTION_UP) {
            // Process the player's shot by passing the coordinates of the player's finger to takeShot
            int x = (int) motionEvent.getX() / blockSize;
            int y = (int) motionEvent.getY() / blockSize;
            gameEngine.takeShot(x, y);

            // Draw the shot and update the HUD
            Shot shot = new Shot(x, y);
            gameDrawer.clearScreen();
            gameDrawer.drawGrid();
            gameDrawer.drawShot(shot);
            gameDrawer.drawHUD(gameEngine.getShotsTaken(), gameEngine.getDistanceFromSub());

            // Check if the shot hit the submarine
            if (gameEngine.isHit()) {
                gameDrawer.drawBoom();
                gameEngine.newGame(); // Start a new game after a hit
                gameDrawer.clearScreen();
                gameDrawer.drawGrid(); // Redraw the grid for the new game
                gameDrawer.drawHUD(gameEngine.getShotsTaken(), gameEngine.getDistanceFromSub()); // Redraw the HUD for the new game
            }

            gameDrawer.updateView();
        }
        return true;
    }
}
