package com.adaptionsoft.games.uglytrivia;

public class Board {
    public String getCategoryFromPosition(int currentPlayerPosition) {
        if (currentPlayerPosition == 0) return "Pop";
        if (currentPlayerPosition == 4) return "Pop";
        if (currentPlayerPosition == 8) return "Pop";
        if (currentPlayerPosition == 1) return "Science";
        if (currentPlayerPosition == 5) return "Science";
        if (currentPlayerPosition == 9) return "Science";
        if (currentPlayerPosition == 2) return "Sports";
        if (currentPlayerPosition == 6) return "Sports";
        if (currentPlayerPosition == 10) return "Sports";
        return "Rock";
    }
}
