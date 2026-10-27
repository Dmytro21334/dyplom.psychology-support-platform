package org.example.dyplom.service;

import org.example.dyplom.model.User;
import org.example.dyplom.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    // Реєстрація нового анонімного студента
    public User registerUser(String username, String rawPassword) {
        if (userRepository.findByUsername(username).isPresent()) {
            throw new RuntimeException("Користувач із таким псевдонімом вже існує!");
        }

        User user = new User();
        user.setUsername(username);
        // Хешуємо пароль заради безпеки персональних даних
        user.setPassword(passwordEncoder.encode(rawPassword));
        user.setRole("ROLE_STUDENT"); // Присвоюємо роль студента

        return userRepository.save(user);
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}