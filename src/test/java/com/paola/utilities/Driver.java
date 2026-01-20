package com.paola.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Driver {

    // Private Constructor, prevents instantiation
    private Driver() {
    }

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();

            // headless toggle: -Dheadless=true
            boolean headless = Boolean.parseBoolean(System.getProperty("headless", "false"));
            if (headless) {
                options.addArguments("--headless=new");
            }

            options.addArguments("--window-size=1920,1080");

            driver = new ChromeDriver(options);
        }
        return driver;
    }

    public static void closeDriver(){
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }

}
