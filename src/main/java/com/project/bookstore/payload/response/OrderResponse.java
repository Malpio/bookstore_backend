package com.project.bookstore.payload.response;

import com.project.bookstore.models.Book;

public class OrderResponse {
    private Long id;
    private BookResponse book;

    public OrderResponse(Long id, BookResponse book) {
        this.book = book;
        this.id = id;
    }

    public BookResponse getBook() {
        return book;
    }

    public Long getId() {
        return id;
    }

    public void setBook(BookResponse book) {
        this.book = book;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
