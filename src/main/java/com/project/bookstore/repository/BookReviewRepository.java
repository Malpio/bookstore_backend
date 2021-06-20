package com.project.bookstore.repository;

import com.project.bookstore.models.Book;
import com.project.bookstore.models.BookReview;
import com.project.bookstore.models.User;
import com.project.bookstore.models.UserBookId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookReviewRepository extends JpaRepository<BookReview, UserBookId> {
    List<BookReview> findAllByBook(Book book);
    boolean existsBookReviewByUserAndBook(User user, Book book);
}
