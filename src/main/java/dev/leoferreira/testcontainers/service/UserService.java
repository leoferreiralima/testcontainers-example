package dev.leoferreira.testcontainers.service;

import dev.leoferreira.testcontainers.domain.User;

import java.util.List;

public interface UserService {
    User createUser(User newUser);

    List<User> getAll();
}
