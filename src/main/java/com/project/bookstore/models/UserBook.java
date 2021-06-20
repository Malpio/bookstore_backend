package com.project.bookstore.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="user_book")
public class UserBook {
    @EmbeddedId
    private UserBookId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("bookId")
    private Book book;

    @Enumerated(EnumType.STRING)
    @NotBlank
    private EUserBook status;

    public UserBook(User user, Book book, EUserBook status) {
        this.book = book;
        this.user = user;
        this.status = status;
        this.id = new UserBookId(user.getId(), book.getId());
    }

    public UserBook() {
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

    public EUserBook getStatus() {
        return status;
    }

    public void setStatus(EUserBook status) {
        this.status = status;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
