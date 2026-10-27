package org.example.dyplom.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Вимикаємо CSRF для зручності роботи з REST API
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/auth/**", "/api/chat/**", "/", "/index.html", "/*.css", "/*.js").permitAll() // Дозволяємо доступ до реєстрації, чату та головної сторінки
                        .anyRequest().authenticated() // Усе інше вимагає захисту
                );

        return http.build();
    }
}