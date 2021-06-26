package com.project.bookstore.payload.response;

import com.project.bookstore.models.Book;

public class OrderDetailsResponse {
    private Long id;
    private BookResponse book;
    private String customerFullName;
    private String deliverFullAddress;

    public OrderDetailsResponse(Long id, BookResponse book, String customerFullName, String deliverFullAddress) {
        this.book = book;
        this.id = id;
        this.customerFullName = customerFullName;
        this.deliverFullAddress = deliverFullAddress;
    }

    public Long getId() {
        return id;
    }

    public BookResponse getBook() {
        return book;
    }

    public String getCustomerFullName() {
        return customerFullName;
    }

    public String getDeliverFullAddress() {
        return deliverFullAddress;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBook(BookResponse book) {
        this.book = book;
    }

    public void setCustomerFullName(String customerFullName) {
        this.customerFullName = customerFullName;
    }

    public void setDeliverFullAddress(String deliverFullAddress) {
        this.deliverFullAddress = deliverFullAddress;
    }
}
