package org.example.dyplom.controller;

import org.example.dyplom.service.AiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/chat")
@CrossOrigin(origins = "*") // Дозволяє запити з фронтенду
public class ChatController {

    private final AiService aiService;

    public ChatController(AiService aiService) {
        this.aiService = aiService;
    }

    // Ендпоінт для відправки повідомлення ШІ-психологу
    @PostMapping("/send")
    public ResponseEntity<Map<String, String>> sendMessage(@RequestBody Map<String, String> request) {
        String studentMessage = request.get("message");

        // Отримуємо відповідь від нашого ШІ-сервісу
        String aiResponse = aiService.getAiResponse(studentMessage);

        return ResponseEntity.ok(Map.of("response", aiResponse));
    }
}