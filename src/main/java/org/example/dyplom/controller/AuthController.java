package org.example.dyplom.controller;

import org.example.dyplom.model.User;
import org.example.dyplom.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    // Ендпоінт для реєстрації нового анонімного користувача
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Map<String, String> request) {
        try {
            String username = request.get("username");
            String password = request.get("password");

            User newUser = userService.registerUser(username, password);
            return ResponseEntity.ok(Map.of("message", "Користувача успішно зареєстровано!", "username", newUser.getUsername()));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }
}