package com.project.bookstore.payload.response;

import com.project.bookstore.models.EUserBook;

public class UserBookResponse {
    private String title;
    private EUserBook status;

    public UserBookResponse(String title, EUserBook status) {
        this.status = status;
        this.title = title;
    }

    public void setStatus(EUserBook status) {
        this.status = status;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public EUserBook getStatus() {
        return status;
    }

    public String getTitle() {
        return title;
    }
}
