package com.example.viewrecyclerapp;

public class Person {
    private int id;
    private String firstName;
    private String lastName;
    private int imageId;

    public Person(int id, String firstName, String lastName, int imageId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.imageId = imageId;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getImageId() {
        return imageId;
    }
}
