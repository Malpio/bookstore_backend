package com.project.bookstore.payload.request;

public class ReviewRequest {
    private Long bookId;
    private String review;

    public ReviewRequest(Long bookId, String review) {
        this.bookId = bookId;
        this.review = review;
    }

    public Long getBookId() {
        return bookId;
    }

    public String getReview() {
        return review;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public void setReview(String rate) {
        this.review = rate;
    }
}
