package com.paola.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {

    public static WebElement waitForVisibility(WebDriverWait wait, By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
