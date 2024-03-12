package com.gamecodeschool.subhunter;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.widget.ImageView;

public class GameDrawer {
    private ImageView gameView;
    private Bitmap blankBitmap;
    private Canvas canvas;
    private Paint paint;
    private int blockSize;
    private int gridWidth;
    private int gridHeight;

    public GameDrawer(ImageView gameView, Bitmap blankBitmap, Canvas canvas, Paint paint, int blockSize, int gridWidth, int gridHeight) {
        this.gameView = gameView;
        this.blankBitmap = blankBitmap;
        this.canvas = canvas;
        this.paint = paint;
        this.blockSize = blockSize;
        this.gridWidth = gridWidth;
        this.gridHeight = gridHeight;
    }

    public void drawGrid() {
        canvas.drawColor(Color.WHITE);
        paint.setColor(Color.BLACK);

        // Draw vertical lines of the grid
        for (int i =  0; i < gridWidth; i++) {
            canvas.drawLine(blockSize * i,  0, blockSize * i, gridHeight * blockSize, paint);
        }

        // Draw horizontal lines of the grid\
        for (int i =  0; i < gridHeight; i++) {
            canvas.drawLine(0, blockSize * i, gridWidth * blockSize, blockSize * i, paint);
        }
    }

    public void drawShot(Shot shot) {
        paint.setColor(Color.BLUE);
        int x = shot.getX() * blockSize;
        int y = shot.getY() * blockSize;
        canvas.drawRect(x, y, x + blockSize, y + blockSize, paint);
    }

    public void drawHUD(int shotsTaken, int distanceFromSub) {
        paint.setTextSize(blockSize *  2);
        paint.setColor(Color.BLUE);
        canvas.drawText("Shots Taken: " + shotsTaken + "  Distance: " + distanceFromSub, blockSize, blockSize *  1.75f, paint);
    }

    public void clearScreen() {
        canvas.drawColor(Color.WHITE);
    }

    public void drawBoom() {
        canvas.drawColor(Color.RED);
        paint.setColor(Color.WHITE);
        paint.setTextSize(blockSize *  10);
        canvas.drawText("BOOM!", blockSize *  4, blockSize *  14, paint);
        paint.setTextSize(blockSize *  2);
        canvas.drawText("Take a shot to start again", blockSize *  8, blockSize *  18, paint);
    }

    public void updateView() {
        gameView.setImageBitmap(blankBitmap);
    }
}
