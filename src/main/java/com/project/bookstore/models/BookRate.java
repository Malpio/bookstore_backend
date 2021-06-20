package com.project.bookstore.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="book_rate")
public class BookRate {
    @EmbeddedId
    private UserBookId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("bookId")
    private Book book;

    @NotBlank
    private int rate;

    public BookRate(User user, Book book, int rate) {
        this.book = book;
        this.user = user;
        this.rate = rate;
        this.id = new UserBookId(user.getId(), book.getId());
    }

    public BookRate() {
    }

    public UserBookId getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Book getBook() {
        return book;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
