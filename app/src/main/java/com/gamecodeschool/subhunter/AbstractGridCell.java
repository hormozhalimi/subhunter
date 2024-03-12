package com.gamecodeschool.subhunter;

import android.graphics.Canvas;
import android.graphics.Paint;

public abstract class AbstractGridCell {
    protected int x;
    protected int y;

    public AbstractGridCell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public abstract void draw(Canvas canvas, Paint paint, int blockSize);
}
