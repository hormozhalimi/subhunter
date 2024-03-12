package com.gamecodeschool.subhunter;
public class GridFactory {
    public static Grid createGrid(int width, int height) {
        Grid grid = new Grid();
        grid.initialize(width, height);
        return grid;
    }
}
