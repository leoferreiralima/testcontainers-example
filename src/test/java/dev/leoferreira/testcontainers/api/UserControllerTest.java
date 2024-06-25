package dev.leoferreira.testcontainers.api;

import dev.leoferreira.testcontainers.TestcontainersConfiguration;
import dev.leoferreira.testcontainers.dtos.CreateUserRequestDTO;
import dev.leoferreira.testcontainers.entity.UserEntity;
import dev.leoferreira.testcontainers.repository.UserRepository;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.Import;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@Import(TestcontainersConfiguration.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
class UserControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void setup() {
        RestAssured.port = port;

        userRepository.deleteAll();
    }

    @Test
    void shouldCreateUser() {
        CreateUserRequestDTO createUserRequest = new CreateUserRequestDTO(
                "Leonardo Ferreira",
                "leonardo@leoferreira.dev",
                "(11) 9 9999-9999"
        );

        given().contentType(ContentType.JSON)
                .body(createUserRequest)
                .when()
                .post("/v1/users")
                .then()
                .statusCode(201)
                .body("id", notNullValue())
                .body("name", equalTo("Leonardo Ferreira"))
                .body("email", equalTo("leonardo@leoferreira.dev"))
                .body("phone", equalTo("(11) 9 9999-9999"));
    }

    @Test
    void shouldGetAll() {
        userRepository.saveAll(
                List.of(
                        new UserEntity("id1", "name1", "email1@test.org", "(11) 9 9999-9999"),
                        new UserEntity("id2", "name2", "email2@test.org", "(11) 9 9999-9999")
                )
        );

        given().when()
                .when()
                .get("/v1/users")
                .then()
                .statusCode(200)
                .body("users", hasSize(2))
                .body("users[0].id", equalTo("id1"))
                .body("users[0].name", equalTo("name1"))
                .body("users[0].email", equalTo("email1@test.org"))
                .body("users[0].phone", equalTo("(11) 9 9999-9999"))
                .body("users[1].id", equalTo("id2"))
                .body("users[1].name", equalTo("name2"))
                .body("users[1].email", equalTo("email2@test.org"))
                .body("users[1].phone", equalTo("(11) 9 9999-9999"));
    }
}