package com.project.bookstore.payload.request;

public class RateRequest {
    private Long bookId;
    private int rate;

    public RateRequest(Long bookId, int rate) {
        this.bookId = bookId;
        this.rate = rate;
    }

    public Long getBookId() {
        return bookId;
    }

    public int getRate() {
        return rate;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}
