package com.testing.maven.Logger;

public class Logger {
    public static void Info(String message) {
        System.out.format("[INFO] `%s`%n", message);
    }
    public static void Error(String message) {
        System.out.format("[ERROR] `%s`%n", message);
    }

    public static void Warning(String message) {
        System.out.format("[WARNING] `%s`%n", message);
    }

    public static void Debug(String message) {
        System.out.format("[DEBUG] `%s`%n", message);
    }

    public static void NewLine(){
        System.out.println("-".repeat(50));
    }
}
