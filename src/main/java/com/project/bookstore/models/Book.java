package com.project.bookstore.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(	name = "books",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "title"),
        })
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 30)
    private String title;

    @NotBlank
    @Size(max = 30)
    private String author;

    @OneToMany(
            mappedBy = "book",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<UserBook> users = new ArrayList<>();

    private double price;

    @OneToMany(mappedBy = "book",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<UserOrder> orders;

    public Book(String title, String author, double price) {
        this.author = author;
        this.title = title;
        this.price = price;
    }

    public Book() {

    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Long getId() {
        return id;
    }

    public Set<UserOrder> getOrders() {
        return orders;
    }

    public void setOrders(Set<UserOrder> orders) {
        this.orders = orders;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
