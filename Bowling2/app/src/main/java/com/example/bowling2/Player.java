package com.example.bowling2;

public class Player {
    private String playerName;
    private int score;

    public Player(String playerName, int score)
    {
        this.playerName = playerName;

        this.score = score;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getScore() {
        return score;
    }
}
