package com.adaze.quizz.enums;

public enum Category {

    BIBLE("Bible", "Bible quiz questions"),
    MUSIC("Music", "Questions about various things in music"),
    MOVIES("Movies", "Movies quiz"),
    OTHERS("Others", "Quiz on various other things");

    private String name;

    private String description;

    Category(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

}
