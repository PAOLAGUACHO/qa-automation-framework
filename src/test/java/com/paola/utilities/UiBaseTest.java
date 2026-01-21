package com.paola.utilities;

import dev.failsafe.internal.util.Durations;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.lang.Thread.sleep;

public class UiBaseTest {

    protected WebDriverWait wait;

    @BeforeAll
    public static void UI_Set_Up(){
        WebDriver driver = Driver.getDriver();
        driver.get("https://www.google.com/");
    }

    @BeforeEach
    public void WebDriverWait_Set_Up(){
         wait= new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
    }

    @AfterAll()
    public static void UI_Tear_Down() throws InterruptedException {
        sleep(3000);
        Driver.closeDriver();
    }
}
