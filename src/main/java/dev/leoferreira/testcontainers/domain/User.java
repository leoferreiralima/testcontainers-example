package dev.leoferreira.testcontainers.domain;

public record User(
        String id,
        String name,
        String email,
        String phone
) {
}
