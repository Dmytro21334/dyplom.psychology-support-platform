package org.example.dyplom.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "chat_messages")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Зв'язок із користувачем, який пише повідомлення
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String message; // Повідомлення від студента або відповідь ШІ

    @Column(nullable = false)
    private String senderType; // "USER" або "AI"

    @Column(nullable = false)
    private LocalDateTime timestamp = LocalDateTime.now();
}