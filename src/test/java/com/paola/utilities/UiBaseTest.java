package com.paola.utilities;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;

import static java.lang.Thread.sleep;

public class UiBaseTest {

    @BeforeAll
    public static void UI_Set_Up(){
        WebDriver driver = Driver.getDriver();
        driver.get("https://www.google.com/");


    }

//    @AfterAll()
//    public static void UI_Tear_Down(){
//        Driver.closeDriver();
//    }
}
