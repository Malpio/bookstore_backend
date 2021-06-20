package com.project.bookstore.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="book_review")
public class BookReview {
    @EmbeddedId
    private UserBookId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("bookId")
    private Book book;

    @NotBlank
    private String review;

    public BookReview(User user, Book book, String review) {
        this.book = book;
        this.user = user;
        this.review = review;
        this.id = new UserBookId(user.getId(), book.getId());
    }

    public BookReview() {
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

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
