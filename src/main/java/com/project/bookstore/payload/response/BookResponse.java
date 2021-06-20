package com.project.bookstore.payload.response;

public class BookResponse {
    private Long id;
    private String title;
    private String author;

    public BookResponse(Long id, String title, String author) {
        this.author = author;
        this.id = id;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
