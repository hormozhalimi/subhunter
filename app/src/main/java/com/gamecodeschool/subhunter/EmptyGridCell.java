package com.gamecodeschool.subhunter;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class EmptyGridCell extends AbstractGridCell {
    // Specific implementation for empty cells
    public EmptyGridCell(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Canvas canvas, Paint paint, int blockSize) {
        // Draw an empty cell (e.g., a white square)
        paint.setColor(Color.WHITE);
        int startX = getX() * blockSize;
        int startY = getY() * blockSize;
        canvas.drawRect(startX, startY, startX + blockSize, startY + blockSize, paint);
    }
}
