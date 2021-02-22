package com.browserstack.demo.pages;

import com.browserstack.demo.selenium.elements.BaseElement;
import com.browserstack.demo.selenium.utils.AttributeType;
import com.browserstack.demo.selenium.utils.ExpectedConditionsUtils;
import com.browserstack.demo.selenium.utils.SeleniumUtils;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * This is the Browserstack Home page. Any elements that are specific to the
 * Browserstack Home page shall be defined here.
 *
 * The constuctor waits for the visibility of the Header Title as a basis for
 * this page loading.
 */
public class BrowserStackMainLandingPage {

    BaseElement landingPageTitle;
    private void initLandingPageTitle() {
        landingPageTitle = new BaseElement(AttributeType.CSS_SELECTOR,"div[class='container'] h1");
    }

    public BaseElement getLandingPageTitle() {
        if(landingPageTitle == null) {
            initLandingPageTitle();
        }

        return landingPageTitle;
    }

    BrowserStackHeader browserStackHeader;
    private void initBrowserStackHeader() {
        browserStackHeader = new BrowserStackHeader();
    }

    public BrowserStackHeader getBrowserStackHeader() {
        if(browserStackHeader == null) {
            initBrowserStackHeader();
        }

        return browserStackHeader;
    }

    public BrowserStackMainLandingPage() {
        ExpectedConditionsUtils.visibilityOfElementLocated(
                SeleniumUtils.generateBy(AttributeType.CSS_SELECTOR, "div[class='container'] h1"),
                10);
    }

    /**
     * Returns the Main page title text.
     *
     * @return String forthe Main page title text
     */
    public String getLandingPageTitleTxt() {
        return getLandingPageTitle().getText();
    }
}
