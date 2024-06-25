package dev.leoferreira.testcontainers.mapper.impl;

import dev.leoferreira.testcontainers.domain.User;
import dev.leoferreira.testcontainers.dtos.UserResponseDTO;
import dev.leoferreira.testcontainers.mapper.ResponseDTOMapper;
import org.springframework.stereotype.Component;

@Component("userResponseDTOMapper")
public class UserResponseDTOMapper implements ResponseDTOMapper<UserResponseDTO, User> {

    @Override
    public UserResponseDTO toResponse(User domain) {
        return new UserResponseDTO(
                domain.id(),
                domain.name(),
                domain.email(),
                domain.phone()
        );
    }
}
