package dev.leoferreira.testcontainers.service.impl;

import dev.leoferreira.testcontainers.domain.User;
import dev.leoferreira.testcontainers.entity.UserEntity;
import dev.leoferreira.testcontainers.mapper.EntityMapper;
import dev.leoferreira.testcontainers.repository.UserRepository;
import dev.leoferreira.testcontainers.service.UserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultUserService implements UserService {
    private final UserRepository userRepository;
    private final EntityMapper<UserEntity, User> userEntityMapper;

    public DefaultUserService(
            UserRepository userRepository,
            @Qualifier("userEntityMapper")
            EntityMapper<UserEntity, User> userEntityMapper
    ) {
        this.userRepository = userRepository;
        this.userEntityMapper = userEntityMapper;
    }

    @Override
    public User createUser(User newUser) {
        UserEntity userEntity = userRepository.save(
                userEntityMapper.toEntity(newUser)
        );

        return userEntityMapper.toDomain(userEntity);
    }

    @Override
    public List<User> getAll() {
        return userEntityMapper.toDomainList(
                userRepository.findAll()
        );
    }
}
