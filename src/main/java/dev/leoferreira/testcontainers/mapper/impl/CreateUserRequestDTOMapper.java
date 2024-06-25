package dev.leoferreira.testcontainers.mapper.impl;

import dev.leoferreira.testcontainers.domain.User;
import dev.leoferreira.testcontainers.dtos.CreateUserRequestDTO;
import dev.leoferreira.testcontainers.mapper.RequestDTOMapper;
import org.springframework.stereotype.Component;

@Component("createUserRequestDTOMapper")
public class CreateUserRequestDTOMapper implements RequestDTOMapper<CreateUserRequestDTO, User> {
    @Override
    public User toDomain(CreateUserRequestDTO requestDTO) {
        return new User(
                null,
                requestDTO.name(),
                requestDTO.email(),
                requestDTO.phone()
        );
    }
}
