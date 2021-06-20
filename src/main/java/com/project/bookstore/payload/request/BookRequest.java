package com.project.bookstore.payload.request;

public class BookRequest {
    private String title;
    private String author;

    public BookRequest(String title, String author) {
        this.author = author;
        this.title = title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }
}
