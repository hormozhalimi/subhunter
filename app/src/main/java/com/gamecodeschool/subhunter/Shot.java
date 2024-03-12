package com.gamecodeschool.subhunter;

public class Shot {
    private int x;
    private int y;
    private boolean isHit;

    public Shot(int x, int y) {
        this.x = x;
        this.y = y;
        this.isHit = false;
    }

    public void setHit(boolean hit) {
        isHit = hit;
    }

    public boolean isHit() {
        return isHit;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}