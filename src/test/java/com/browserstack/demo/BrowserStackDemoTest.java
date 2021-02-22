package com.browserstack.demo;

import com.browserstack.demo.pages.BrowserStackHeader;
import com.browserstack.demo.pages.BrowserStackMainLandingPage;
import com.browserstack.demo.pages.SearchResultsPage;
import com.browserstack.demo.selenium.utils.DriverUtils;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class BrowserStackDemoTest extends BaseBrowserStackDemoTest {

    @Test(groups = {"Browserstack"}, description = "Verifies upload and scan binary and components/vulns")
    public void test_browserstack_workflow() {
        String textToSearch = "enterprise";
        SoftAssert softAssert = new SoftAssert();
        DriverUtils.navigateToURL("https://www.browserstack.com");
        BrowserStackMainLandingPage mainLandingPage = new BrowserStackMainLandingPage();
        softAssert.assertEquals(mainLandingPage.getLandingPageTitleTxt(), "App & Browser Testing Made Easy",
                "Validates the BrowserStack main landing page title text");
        BrowserStackHeader stackHeader = new BrowserStackHeader();
        stackHeader.navigateToAutomatePage();
        softAssert.assertEquals(DriverUtils.getCurrentURL(), "https://www.browserstack.com/automate",
                "Validates the current URL handle is that of the Automate page");
        SearchResultsPage searchResultsPage = stackHeader.searchDocuments(textToSearch);
        softAssert.assertTrue(searchResultsPage.getSearchResultsText().contains(textToSearch),
                "Validates the Search result text header contains " + textToSearch);
        softAssert.assertAll();
    }
}
