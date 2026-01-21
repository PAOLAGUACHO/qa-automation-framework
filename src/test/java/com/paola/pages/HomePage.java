package com.paola.pages;

import com.paola.utilities.Driver;
import com.paola.utilities.ElementUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //Driver.getDriver().navigate().to("https://fakeapi.platzi.com/");
    private final String URL = "https://fakeapi.platzi.com/";
    public void open() {
        driver.navigate().to(URL);
    }

    private By searchButton = By.xpath("//button[@aria-label='Search']");

    private By viewDocsLink = By.linkText("View Docs");


    public WebElement getSearchButton(WebDriverWait wait) {
        return ElementUtils.waitForVisibility(wait, searchButton);
    }

    public WebElement getViewDocsLink(WebDriverWait wait) {
        return ElementUtils.waitForVisibility(wait, viewDocsLink);
    }

    public boolean isLoaded(){
        boolean isTitle = driver.getTitle() != null && driver.getTitle().contains("Platzi");
        boolean isUrl = driver.getCurrentUrl().contains(URL);

        return isTitle && isUrl;
    }

}