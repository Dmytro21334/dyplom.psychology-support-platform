package org.example.dyplom.repository;

import org.example.dyplom.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Метод для пошуку користувача за логіном (username)
    Optional<User> findByUsername(String username);
}