package com.gamecodeschool.subhunter;

public class Grid {
    private AbstractGridCell[][] cells;

    public void initialize(int width, int height) {
        cells = new AbstractGridCell[width][height];
        for (int x =  0; x < width; x++) {
            for (int y =  0; y < height; y++) {
                cells[x][y] = new EmptyGridCell(x, y);
            }
        }
    }

    public AbstractGridCell getCellAt(int x, int y) {
        return cells[x][y];
    }
}
