package com.lestonpoh.financeapp_backend.controller;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lestonpoh.financeapp_backend.client.IbkrClient;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/investments")
@RequiredArgsConstructor
public class InvestmentController {
    private final IbkrClient ibkrClient;

    @GetMapping
    public ResponseEntity<String> getHello() throws IOException {
        ibkrClient.getReport("");
        return ResponseEntity.ok("");
    }
}
