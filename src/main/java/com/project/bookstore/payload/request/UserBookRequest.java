package com.project.bookstore.payload.request;

import com.project.bookstore.models.EUserBook;

public class UserBookRequest {
    private Long bookId;
    private EUserBook status;

    public UserBookRequest(Long bookId, EUserBook status) {
        this.bookId = bookId;
        this.status = status;
    }

    public void setStatus(EUserBook status) {
        this.status = status;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public EUserBook getStatus() {
        return status;
    }

    public Long getBookId() {
        return bookId;
    }
}
