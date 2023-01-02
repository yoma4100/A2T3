package ru.netology.rest;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;

public class PostmanEchoResponseTest {
    @Test
    public void shouldResponse200() {
        given()
                .baseUri("https://postman-echo.com")
                .body("some data")
                .when()
                .post("/post")
                .then()
                .statusCode(300)
        ;
    }

    @Test
    public void shouldResponseSameBody() {
        given()
                .baseUri("https://postman-echo.com")
                .body("some data")
                .when()
                .post("/post")
                .then()
                .body("data", equalTo("somedata"))
        ;
    }

    @Test
    public void shouldResponse404() {
        given()
                .baseUri("https://postman-echo.com")
                .body("some data")
                .when()
                .get("/post")
                .then()
                .statusCode(200)
        ;
    }
}
