package com.example.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.backend.model.dao.User;
import com.example.backend.model.telegram.TelegramUserResponse;
import com.example.backend.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/telegramId/{id}")
    public ResponseEntity<TelegramUserResponse> getUserByTelegramId(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserByTelegramId(id));
    }

    @PatchMapping("/telegramId")
    public ResponseEntity<User> updateTelegramIdByEmail(@RequestParam String email, @RequestParam Long telegramId) {
        return ResponseEntity.ok(userService.updateTelegramIdByEmail(email, telegramId));
    }
}
