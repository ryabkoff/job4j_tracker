package ru.job4j.gc.leak2;

public class Comment {

    private String text;

    private User user;

    public Comment(String text, User user) {
        this.text = text;
        this.user = user;
    }

    /*getter/setter*/
}