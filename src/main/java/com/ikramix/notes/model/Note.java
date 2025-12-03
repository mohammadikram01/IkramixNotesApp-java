package com.ikramix.notes.model;

public class Note {
    private String category;
    private String text;

    public Note() {}

    public Note(String category, String text) {
        this.category = category;
        this.text = text;
    }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getText() { return text; }
    public void setText(String text) { this.text = text; }
}
