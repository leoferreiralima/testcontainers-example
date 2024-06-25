package dev.leoferreira.testcontainers.api;

import dev.leoferreira.testcontainers.domain.User;
import dev.leoferreira.testcontainers.dtos.CreateUserRequestDTO;
import dev.leoferreira.testcontainers.dtos.UserResponseDTO;
import dev.leoferreira.testcontainers.dtos.UserResponseListDTO;
import dev.leoferreira.testcontainers.mapper.RequestDTOMapper;
import dev.leoferreira.testcontainers.mapper.ResponseDTOMapper;
import dev.leoferreira.testcontainers.service.UserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/users")
public class UserController {
    private final UserService userService;
    private final ResponseDTOMapper<UserResponseDTO, User> userResponseDTOMapper;
    private final RequestDTOMapper<CreateUserRequestDTO, User> createUserRequestDTOMapper;

    public UserController(
            UserService userService,
            @Qualifier("userResponseDTOMapper")
            ResponseDTOMapper<UserResponseDTO, User> userResponseDTOMapper,
            @Qualifier("createUserRequestDTOMapper")
            RequestDTOMapper<CreateUserRequestDTO, User> createUserRequestDTOMapper
    ) {
        this.userService = userService;
        this.userResponseDTOMapper = userResponseDTOMapper;
        this.createUserRequestDTOMapper = createUserRequestDTOMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponseDTO createUser(@RequestBody CreateUserRequestDTO createUserRequestDTO) {
        User newUser = userService.createUser(
                createUserRequestDTOMapper.toDomain(
                        createUserRequestDTO
                )
        );

        return userResponseDTOMapper.toResponse(newUser);
    }

    @GetMapping
    public UserResponseListDTO getAll() {
        return new UserResponseListDTO(
                userResponseDTOMapper.toResponseList(
                        userService.getAll()
                )
        );
    }
}
