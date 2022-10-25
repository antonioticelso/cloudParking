package com.github.antonioticelso.cloudParking.controller;

import com.github.antonioticelso.cloudParking.model.dto.ParkingCreateDTO;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ParkingControllerTestTest {

    @LocalServerPort
    private int randomPort;

    @BeforeEach
    public void setUpTest() {
        RestAssured.port = randomPort;
    }

    @Test
    void whenFindAllThenCheckResult() {
        RestAssured.given()
                .when()
                .get("/parking")
                .then()
                .statusCode( HttpStatus.OK.value());
//                .body("license[0]", Matchers.equalTo("WBC-007"));
//                .extract().response().body().prettyPrint();
    }

    @Test
    void findById() {
    }

    @Test
    void whenCreateThenCheckIsCreated() {
        ParkingCreateDTO createDTO = new ParkingCreateDTO();
        createDTO.setLicense("JFT-4844");
        createDTO.setModel("PASSAT");
        createDTO.setColor("PRATA");
        createDTO.setState("DF");

        RestAssured.given()
                .when()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(createDTO)
                .post("/parking")
                .then()
                .statusCode(HttpStatus.CREATED.value())
                .body("license", Matchers.equalTo("JFT-4844"))
                .body("color", Matchers.equalTo("PRATA"));

    }

    @Test
    void update() {
    }

    @Test
    void checkOut() {
    }

    @Test
    void delete() {
    }
}