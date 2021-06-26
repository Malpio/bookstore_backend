package com.project.bookstore.payload.request;

public class OrderRequest {
    private Long bookId;
    private String customerFullName;
    private String deliverFullAddress;

    public OrderRequest(Long bookId, String customerFullName, String deliverFullAddress) {
        this.bookId = bookId;
        this.customerFullName = customerFullName;
        this.deliverFullAddress = deliverFullAddress;
    }

    public String getDeliverFullAddress() {
        return deliverFullAddress;
    }

    public String getCustomerFullName() {
        return customerFullName;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setDeliverFullAddress(String deliverFullAddress) {
        this.deliverFullAddress = deliverFullAddress;
    }

    public void setCustomerFullName(String customerFullName) {
        this.customerFullName = customerFullName;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }
}
