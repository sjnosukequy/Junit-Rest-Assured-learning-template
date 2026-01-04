package com.testing.maven.Tests.Posts;

import com.testing.maven.Template.Template;

import static org.junit.jupiter.api.Assumptions.assumeFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

import io.restassured.filter.log.LogDetail;
import io.restassured.module.jsv.JsonSchemaValidator;
import static org.hamcrest.Matchers.*;

public class SimplePostTest extends Template {

    @Test
    void fetchAll() {
        given()
        .when()
            .get("/posts")
        .then()
            .statusCode(200)
            .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("AllPostsSchema.json"));
    }

    @Test
    void fetchOne() {
        int postId = 1;

        given()
        .when()
            .get("/posts/{id}", postId)
        .then()
            .log().ifValidationFails(LogDetail.BODY)
            .statusCode(200)
            .body("id", equalTo(2));
    } 


    @Test
    void getComments() {
        assumeFalse(getLastTestFailed(), "Skipping test because the previous test failed.");

        int postId = 1;
        given()
        .when()
            .get("/posts/{id}/comments", postId)
        .then()
            .statusCode(200)
            .body("[0].id", equalTo(1));
    }

    @Override
    @BeforeEach
    public void init(org.junit.jupiter.api.TestInfo testInfo) {
        super.init(testInfo);
        System.out.println("override method called");
    }

    // You can not ovverride static method of parent class -> therefore we create a new static method
    // @BeforeAll
    // public static void beforeAll() {
    //     System.out.println("SimplePostTest before all called #2");
    // }

}
