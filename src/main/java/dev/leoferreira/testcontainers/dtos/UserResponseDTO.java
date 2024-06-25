package dev.leoferreira.testcontainers.dtos;

public record UserResponseDTO(
        String id,
        String name,
        String email,
        String phone
) {
}
