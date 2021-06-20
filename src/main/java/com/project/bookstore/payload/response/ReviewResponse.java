package com.project.bookstore.payload.response;

public class ReviewResponse {
    private String username;
    private String review;

    public ReviewResponse(String username, String review) {
        this.review = review;
        this.username = username;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getUsername() {
        return username;
    }

    public String getReview() {
        return review;
    }
}
