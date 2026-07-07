package com.i2i.testautomation;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class ApiAutomationTest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    @Test
    public void shouldGetPostByIdSuccessfully() {
        given()
                .when()
                .get("/posts/1")
                .then()
                .statusCode(200)
                .time(lessThan(3000L))
                .body("id", equalTo(1))
                .body("userId", equalTo(1));
    }

    @Test
    public void shouldCreatePostSuccessfully() {
        Map<String, Object> requestBody = Map.of(
                "title", "i2i Academy Test Automation",
                "body", "REST Assured API automation test",
                "userId", 1
        );

        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/posts")
                .then()
                .statusCode(201)
                .time(lessThan(3000L))
                .body("title", equalTo("i2i Academy Test Automation"))
                .body("body", equalTo("REST Assured API automation test"))
                .body("userId", equalTo(1));
    }
}