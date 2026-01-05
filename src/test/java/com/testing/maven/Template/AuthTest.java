package com.testing.maven.Template;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@Target({ElementType.METHOD, ElementType.TYPE}) // Works on methods OR classes
@Retention(RetentionPolicy.RUNTIME)
@ExtendWith(AuthExtension.class) // Connects the extension
@Test // Defines this as a Test, so you don't need to add @Test manually
public @interface AuthTest {
}