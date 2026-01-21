package com.paola.tests.ui;

import com.paola.pages.DocsPage;
import com.paola.pages.HomePage;
import com.paola.utilities.Driver;
import com.paola.utilities.UiBaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class HomePageTests extends UiBaseTest {

    @DisplayName("Validating user journeys")
    @Test
    public void homePage_userCanNavigateToDocs() {
        HomePage homePage = openHomePage();

        assertTrue(homePage.isLoaded());
        assertTrue(homePage.isSearchButtonVisible(wait));
        assertTrue(homePage.isViewDocsLinkVisible(wait));

        DocsPage docsPage = homePage.goToDocs(wait);
        assertTrue(docsPage.isLoaded());
        assertTrue(docsPage.isIntroductionHeadingVisible(wait));
    }

    @DisplayName("Validating page-specific content in isolation")
    @Test
    public void docsPage_headingShouldNotContainGettingStarted() {
        DocsPage docsPage = openDocsPage();

        String heading = docsPage.getIntroductionHeading(wait).getText();
        assertFalse(heading.contains("Getting Started"));

    }

    private HomePage openHomePage() {
        HomePage homePage = new HomePage(Driver.getDriver());
        homePage.open();
        return homePage;
    }

    private DocsPage openDocsPage(){
        DocsPage docsPage = new DocsPage(Driver.getDriver());
        docsPage.open();
        return docsPage;
    }

}