package com.testing.maven.Template;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import static com.testing.maven.Logger.Logger.*;

public class Watcher implements TestWatcher {
    private static boolean testFailed = false;

    public static boolean resetTestStatus(){
        testFailed = false;
        return testFailed;
    }

    public static boolean getTestStatus(){
        return testFailed;
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        testFailed = false;
        Info("Test passed: " + context.getDisplayName());
        NewLine();
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        testFailed = true;
        Error("Test failed: " + context.getDisplayName());
        Error("Cause: " +cause.getMessage());
        NewLine();
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        Warning("Test aborted: " + context.getDisplayName());
        Warning("Cause: " + cause.getMessage());
        NewLine();
    }

    @Override
    public void testDisabled(ExtensionContext context, java.util.Optional<String> reason) {
        Info("Test disabled: " + context.getDisplayName());
        Info("Reason: " + reason.orElse("No reason provided"));
        NewLine();
    }
    
}
