package dev.leoferreira.testcontainers.dtos;

public record CreateUserRequestDTO(
        String name,
        String email,
        String phone
) {
}
