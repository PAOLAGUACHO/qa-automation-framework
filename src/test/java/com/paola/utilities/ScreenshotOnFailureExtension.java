package com.paola.utilities;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ScreenshotOnFailureExtension implements TestWatcher {
    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        try {

            TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);

            Path dir = Paths.get("target", "screenshots");
            Files.createDirectories(dir);

            String testName = context.getDisplayName()
                    .replaceAll("[^a-zA-Z0-9._-]", "_");

            String fileName = testName + "_" + System.currentTimeMillis() + ".png";
            Path filePath = dir.resolve(fileName);

            Files.write(filePath, screenshot);

            System.out.println("Saved screenshot: " + filePath.toAbsolutePath());

        } catch (Exception e) {
            System.out.println("Failed to save screenshot: " + e.getMessage());
        }
    }
}
