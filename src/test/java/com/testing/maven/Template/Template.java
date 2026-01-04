package com.testing.maven.Template;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.extension.ExtendWith;

import io.restassured.RestAssured;
import io.restassured.builder.*;

import static com.testing.maven.Logger.Logger.*;

@ExtendWith(Watcher.class)
public class Template {
    public static boolean lastTestFailed;

    public boolean getLastTestFailed() {
        lastTestFailed = Watcher.getTestStatus();
        return lastTestFailed;
    }

    public boolean resetLastTestFailed() {
        lastTestFailed = Watcher.resetTestStatus();
        return lastTestFailed;
    }

    @BeforeAll
    public static void setUp() {
        lastTestFailed = Watcher.resetTestStatus();
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setContentType("application/json")
                .build();
    }

    @BeforeEach
    public void init(TestInfo testInfo) {
        getLastTestFailed();
        String displayName = testInfo.getDisplayName();
        Info("Starting test: " + displayName);
    }
}
