package com.example.bloomapp;

import android.os.Parcel;
import android.os.Parcelable;

public class Bowling implements Parcelable {
    private int firstBall;
    private int secondBall;
    private int score;
    private boolean split;
    private Player player;
    private Game game;

    public Bowling(int firstBall, int secondBall, int score, boolean split, Player player, Game game) {
        this.firstBall = firstBall;
        this.secondBall = secondBall;
        this.score = score;
        this.split = split;
        this.player = player;
        this.game = game;
    }

    protected Bowling(Parcel in) {
        firstBall = in.readInt();
        secondBall = in.readInt();
        score = in.readInt();
        split = in.readByte() != 0;
        player = in.readParcelable(Player.class.getClassLoader());
        game = in.readParcelable(Game.class.getClassLoader());
    }

    public static final Creator<Bowling> CREATOR = new Creator<Bowling>() {
        @Override
        public Bowling createFromParcel(Parcel in) {
            return new Bowling(in);
        }

        @Override
        public Bowling[] newArray(int size) {
            return new Bowling[size];
        }
    };

    public int getFirstBall() {
        return firstBall;
    }

    public int getSecondBall() {
        return secondBall;
    }

    public int getScore() {
        return score;
    }

    public boolean isSplit() {
        return split;
    }

    public Player getPlayer() {
        return player;
    }

    public Game getGame() {
        return game;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(firstBall);
        dest.writeInt(secondBall);
        dest.writeInt(score);
        dest.writeByte((byte) (split ? 1 : 0));
        dest.writeParcelable(player, flags);
        dest.writeParcelable(game, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }
}
