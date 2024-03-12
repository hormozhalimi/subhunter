package com.gamecodeschool.subhunter;

import android.util.Log;

public class DebuggingTest {
    public void printDebuggingInfo(GameEngine gameEngine, GameDrawer gameDrawer) {
        // Debugging logic
        int shotsTaken = gameEngine.getShotsTaken();
        int distanceFromSub = gameEngine.getDistanceFromSub();
        int subHorizontalPosition = gameEngine.getSubHorizontalPosition();
        int subVerticalPosition = gameEngine.getSubVerticalPosition();

        Log.d("info", "Shots taken: " + shotsTaken);
        Log.d("info", "Distance from sub: " + distanceFromSub);
        Log.d("info", "Sub horizontal position: " + subHorizontalPosition);
        Log.d("info", "Sub vertical position: " + subVerticalPosition);




    }
}