package com.project.bookstore.payload.request;

public class BookRequest {
    private String title;
    private String author;
    private double price;

    public BookRequest(String title, String author, double price) {
        this.author = author;
        this.title = title;
        this.price = price;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
