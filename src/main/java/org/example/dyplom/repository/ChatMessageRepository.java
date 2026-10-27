package org.example.dyplom.repository;

import org.example.dyplom.model.ChatMessage;
import org.example.dyplom.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {
    // Отримати всі повідомлення конкретного користувача, відсортовані за часом
    List<ChatMessage> findByUserOrderByTimestampAsc(User user);
}