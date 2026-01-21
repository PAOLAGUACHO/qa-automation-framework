package com.paola.pages;

import com.paola.utilities.ElementUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.By.xpath;

public class DocsPage {
    private WebDriver driver;

    public DocsPage(WebDriver driver){
        this.driver = driver;
    }

    private final String url = "https://fakeapi.platzi.com/en/about/introduction/";

    public void open(){
        driver.navigate().to(url);
    }

    private By mainHeading = xpath("//h1[.='Introduction']");


    public WebElement getIntroductionHeading(WebDriverWait wait){
        return ElementUtils.waitForVisibility(wait, mainHeading );
    }

    public boolean isIntroductionHeadingVisible(WebDriverWait wait){
        return getIntroductionHeading(wait).isDisplayed();
    }


    public boolean isLoaded(){
        boolean isTitle = driver.getTitle() != null && driver.getTitle().contains("Introduction");
        boolean isUrl = driver.getCurrentUrl().contains(url);

        return isTitle && isUrl;
    }

}
