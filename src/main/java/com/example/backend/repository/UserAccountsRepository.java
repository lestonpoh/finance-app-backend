package com.example.backend.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.backend.model.dao.UserAccounts;

public interface UserAccountsRepository extends MongoRepository<UserAccounts, String> {
    Optional<UserAccounts> findByUserId(String userId);
}
