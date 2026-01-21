package com.paola.pages;

import org.openqa.selenium.WebDriver;

public class DocsPage {
    private WebDriver driver;

    public DocsPage(WebDriver driver){
        this.driver = driver;
    }

    private final String url = "https://fakeapi.platzi.com/en/about/introduction/";

    public void open(){
        driver.navigate().to(url);
    }

    public boolean isLoaded(){
        boolean isTitle = driver.getTitle() != null && driver.getTitle().contains("Introduction");
        boolean isUrl = driver.getCurrentUrl().contains(url);

        return isTitle && isUrl;
    }
}
