package com.gamecodeschool.subhunter;

import java.util.Random;

public class GameEngine {
    private int shotsTaken;
    private int distanceFromSub;
    private boolean hit;
    private int subHorizontalPosition;
    private int subVerticalPosition;

    public void newGame() {
        Random random = new Random();
        subHorizontalPosition = random.nextInt(40);
        subVerticalPosition = random.nextInt(40);
        shotsTaken =  0;
    }

    public void takeShot(int x, int y) {
        shotsTaken++;
        hit = x == subHorizontalPosition && y == subVerticalPosition;
        distanceFromSub = (int) Math.sqrt((x - subHorizontalPosition) * (x - subHorizontalPosition) + (y - subVerticalPosition) * (y - subVerticalPosition));
    }

    public boolean isHit() {
        return hit;
    }

    public int getShotsTaken() {
        return shotsTaken;
    }

    public int getDistanceFromSub() {
        return distanceFromSub;
    }

    public int getSubHorizontalPosition() {
        return subHorizontalPosition;
    }

    public int getSubVerticalPosition() {
        return subVerticalPosition;
    }
}
