package com.paola.tests.ui;

import com.paola.pages.HomePage;
import com.paola.utilities.Driver;
import com.paola.utilities.UiBaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class HomePageTests extends UiBaseTest {

    @Test
    public void homePage_shouldLoadSuccessfully() {
        HomePage homePage = new HomePage(Driver.getDriver());

        homePage.open();

        assertTrue(homePage.isLoaded());

        assertTrue(homePage.getSearchButton(wait).isDisplayed());

        assertTrue(homePage.getViewDocsLink(wait).isDisplayed());

    }
}
