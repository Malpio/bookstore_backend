package com.project.bookstore.repository;

import com.project.bookstore.models.Book;
import com.project.bookstore.models.BookRate;
import com.project.bookstore.models.User;
import com.project.bookstore.models.UserBookId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRateRepository extends JpaRepository<BookRate, UserBookId> {
    Optional<BookRate> findByUserAndBook(User user, Book book);
    List<BookRate> findAllByBook(Book book);
}
