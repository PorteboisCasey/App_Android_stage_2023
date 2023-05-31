package com.example.bloomapp;

import android.os.Parcel;
import android.os.Parcelable;

public class Player implements Parcelable {
    private int id;
    private String nom;
    private String prenom;

    public Player(int id, String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
    }

    protected Player(Parcel in) {
        id = in.readInt();
        nom = in.readString();
        prenom = in.readString();
    }

    public static final Creator<Player> CREATOR = new Creator<Player>() {
        @Override
        public Player createFromParcel(Parcel in) {
            return new Player(in);
        }

        @Override
        public Player[] newArray(int size) {
            return new Player[size];
        }
    };

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(nom);
        dest.writeString(prenom);
    }

    @Override
    public int describeContents() {
        return 0;
    }
}
