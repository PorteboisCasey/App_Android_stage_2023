package com.example.bloomapp;

import android.os.Parcel;
import android.os.Parcelable;

public class Game implements Parcelable {
    private int id;
    private int score;
    private boolean complete;

    public Game(int id, int score, boolean complete) {
        this.id = id;
        this.score = score;
        this.complete = complete;
    }

    protected Game(Parcel in) {
        id = in.readInt();
        score = in.readInt();
        complete = in.readByte() != 0;
    }

    public static final Creator<Game> CREATOR = new Creator<Game>() {
        @Override
        public Game createFromParcel(Parcel in) {
            return new Game(in);
        }

        @Override
        public Game[] newArray(int size) {
            return new Game[size];
        }
    };

    public int getId() {
        return id;
    }

    public int getScore() {
        return score;
    }

    public boolean isComplete() {
        return complete;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeInt(score);
        dest.writeByte((byte) (complete ? 1 : 0));
    }

    @Override
    public int describeContents() {
        return 0;
    }
}
