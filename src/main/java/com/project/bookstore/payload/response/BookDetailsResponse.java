package com.project.bookstore.payload.response;

import com.project.bookstore.models.Book;
import com.project.bookstore.models.BookReview;

import java.util.List;

public class BookDetailsResponse {
    private Book book;
    private double rate;
    private int myRate;
    private List<ReviewResponse> reviews;
    private boolean isRateByMe;
    private boolean isReviewByMe;

    public BookDetailsResponse(Book book, double rate, int myRate, List<ReviewResponse> reviews, boolean isRateByMe, boolean isReviewByMe) {
        this.book = book;
        this.rate = rate;
        this.reviews = reviews;
        this.myRate = myRate;
        this.isReviewByMe = isReviewByMe;
        this.isRateByMe = isRateByMe;
    }

    public Book getBook() {
        return book;
    }

    public double getRate() {
        return rate;
    }

    public int getMyRate() {
        return myRate;
    }

    public boolean getIsRateByMe() {
        return isRateByMe;
    }

    public boolean getIsReviewByMe() {
        return isReviewByMe;
    }

    public List<ReviewResponse> getReviews() {
        return reviews;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setMyRate(int myRate) {
        this.myRate = myRate;
    }

    public void setRateByMe(boolean rateByMe) {
        isRateByMe = rateByMe;
    }

    public void setReviewByMe(boolean reviewByMe) {
        isReviewByMe = reviewByMe;
    }

    public void setReviews(List<ReviewResponse> reviews) {
        this.reviews = reviews;
    }
}
