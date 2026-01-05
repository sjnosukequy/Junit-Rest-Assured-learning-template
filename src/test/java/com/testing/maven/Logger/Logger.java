package com.testing.maven.Logger;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Logger {
    static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    private static LocalDateTime getTime() {
        return LocalDateTime.now();
    }

    private static String formatTime() {
        return getTime().format(fmt);
    }

    public static void Info(String message) {
        System.out.format("[INFO] %s | %s %n", formatTime(), message);
    }
    public static void Error(String message) {
        System.out.format("[ERROR] %s | %s %n", formatTime(), message);
    }

    public static void Warning(String message) {
        System.out.format("[WARNING] %s | %s %n", formatTime(), message);
    }

    public static void Debug(String message) {
        System.out.format("[DEBUG] %s | %s %n", formatTime(), message);
    }

    public static void NewLine(){
        System.out.println("-".repeat(50));
    }
}
