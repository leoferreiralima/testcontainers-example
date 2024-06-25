package dev.leoferreira.testcontainers.dtos;

import java.util.List;

public record UserResponseListDTO(
        List<UserResponseDTO> users
) {
}
