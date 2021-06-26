package com.project.bookstore.repository;

import com.project.bookstore.models.User;
import com.project.bookstore.models.UserOrder;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<UserOrder, Long> {
    @NotNull
    Optional<UserOrder> findById(@NotNull Long id);
    List<UserOrder> findByUser(User user);
}
