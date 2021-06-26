package com.project.bookstore.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user_order")
public class UserOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bookId")
    private Book book;

    @NotBlank
    @Size(max = 50)
    private String customerFullName;

    @NotBlank
    private String deliverFullAddress;

    public UserOrder(){};
    public UserOrder(User user, Book book, String customerFullName, String deliverFullAddress){
        this.book = book;
        this.user=  user;
        this.customerFullName = customerFullName;
        this.deliverFullAddress = deliverFullAddress;
    }

    public Long getId() {
        return id;
    }

    public Book getBook() {
        return book;
    }

    public User getUser() {
        return user;
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

    public void setBook(Book book) {
        this.book = book;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setCustomerFullName(String customerFullName) {
        this.customerFullName = customerFullName;
    }

    public void setDeliverFullAddress(String deliverFullAddress) {
        this.deliverFullAddress = deliverFullAddress;
    }
}
