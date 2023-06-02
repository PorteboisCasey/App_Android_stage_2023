package com.example.viewrecyclerapp;

public class BowlingPlayer extends Person {

    private int score;

    public BowlingPlayer(int id, String firstName, String lastName, int score) {
        super(id, firstName, lastName, R.drawable.bowling);
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
