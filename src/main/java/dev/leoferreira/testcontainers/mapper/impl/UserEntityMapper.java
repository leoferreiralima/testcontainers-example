package dev.leoferreira.testcontainers.mapper.impl;

import dev.leoferreira.testcontainers.domain.User;
import dev.leoferreira.testcontainers.entity.UserEntity;
import dev.leoferreira.testcontainers.mapper.EntityMapper;
import org.springframework.stereotype.Component;

@Component("userEntityMapper")
public class UserEntityMapper implements EntityMapper<UserEntity, User> {

    @Override
    public User toDomain(UserEntity entity) {
        return new User(
                entity.getId(),
                entity.getName(),
                entity.getEmail(),
                entity.getPhone()
        );
    }

    @Override
    public UserEntity toEntity(User domain) {
        return new UserEntity(
                domain.id(),
                domain.name(),
                domain.email(),
                domain.phone()
        );
    }
}
