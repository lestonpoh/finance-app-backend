package com.example.backend.model.telegram;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TelegramUserResponse {
    private String email;
    private String username;
    private Long telegramId;
    private String token;
}
