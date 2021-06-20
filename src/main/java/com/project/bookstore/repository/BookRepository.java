package com.project.bookstore.repository;

import java.util.List;
import java.util.Optional;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.bookstore.models.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @NotNull
    Optional<Book> findById(@NotNull Long id);
    @NotNull
    List<Book> findAll();
    Boolean existsByTitle(String title);
}
