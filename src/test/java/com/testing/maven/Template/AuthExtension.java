package com.testing.maven.Template;

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import io.restassured.RestAssured;
import io.restassured.authentication.NoAuthScheme;
import io.restassured.authentication.AuthenticationScheme;
import io.restassured.authentication.PreemptiveBasicAuthScheme;

public class AuthExtension implements BeforeEachCallback, AfterEachCallback {
    // Store the previous auth scheme so we can restore it later
    private AuthenticationScheme originalAuth;

    @Override
    public void beforeEach(ExtensionContext context) {
        // 1. Capture the existing state (in case global config exists)
        originalAuth = RestAssured.authentication;

        // 2. Set your specific Authentication
        PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
        authScheme.setUserName("admin");
        authScheme.setPassword("password123");

        RestAssured.authentication = authScheme;

        System.out.println(">>> Auth applied for: " + context.getDisplayName());
    }

    @Override
    public void afterEach(ExtensionContext context) {
        // 3. Reset to the original state (or strictly NoAuthScheme)
        if (originalAuth == null) {
            RestAssured.authentication = new NoAuthScheme();
        } else {
            RestAssured.authentication = originalAuth;
        }

        System.out.println("<<< Auth removed for: " + context.getDisplayName());
    }
}
