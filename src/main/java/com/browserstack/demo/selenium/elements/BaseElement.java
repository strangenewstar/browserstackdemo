package com.browserstack.demo.selenium.elements;

import com.browserstack.demo.selenium.utils.*;
import org.openqa.selenium.*;

/**
 * This is the initialization of all elements used within the page objects.
 * This is a demo only so one BaseElement exists. In a more defined framework
 * separate object types extend this base class.
 */
public class BaseElement {
    protected By by;
    AttributeType attributeType;
    String attributeStr;
    protected WebElement webElement;
    int timeout = ConfigPropertyUtils.getMaxWaitTime();

    public BaseElement(AttributeType attributeType, String attributeStr) {
        this.attributeType = attributeType;
        this.attributeStr = attributeStr;
        this.by = SeleniumUtils.generateBy(attributeType, attributeStr);
        this.webElement = ExpectedConditionsUtils.presenceOfElementLocated(by, timeout);
    }

    /**
     * Returns the Selenium WebElement associated with the BaseElement
     * @return WebElement
     */
    public WebElement getWebElement() {
        return webElement;
    }

    /**
     * Returns the By object used to define the current BaseElement's WebElement
     * @return By
     */
    public By getBy() {
        return by;
    }

    /**
     * Returns the Attribute String used to create the BaseElement's WebElement's By
     * @return String used in By objects declaration
     */
    public String getAttributeStr() {
        return attributeStr;
    }

    /**
     * Returns the Attribute Type used to create the BaseElement's WebElement's By
     * @return AttributeType enum value used in By objects declaration
     */
    public AttributeType getAttributeType() {
        return attributeType;
    }

    /**
     * Returns the max wait timeout value defined in config.properties
     *
     * @return int for max timeout for each ExpectedCondition to complete
     */
    public int getMaxTimeout() {
        return timeout;
    }

    /**
     * Returns an attribute string associated with a WebElement's HTML attribute
     * Note: This is NOT to be confused with the Attribute String used to create
     * the BaseElement
     *
     * @param attributeName String name for the HTML attribute who's value is returned
     * (i.e. title, class, id, name)
     * @return the String value associated with the Attribute Name
     */
    public String getAttributeStr(String attributeName) {
        return getWebElement().getAttribute(attributeName);
    }

    private boolean webElementExists() {
        return webElement != null;
    }

    /**
     * Returns true is the BaseElement is visible on the page and false otherwise
     *
     * @return boolean true is displayed and false otherwise
     */
    public boolean isDisplayed() {
        this.webElement = ExpectedConditionsUtils.visibilityOfElementLocated(by, timeout);
        if(webElementExists()) {
            return webElement.isDisplayed();
        }

        return false;
    }
//
//    public boolean isPresent() {
//        this.webElement = ExpectedConditionsUtils.presenceOfElementLocated(by, timeout);
//        return webElementExists();
//    }

    /**
     * If the BaseElement is displayed on the page returns the text value displayed
     *
     * @return the String value associated with a displayed BaseElement
     */
    public String getText() {
        if(isDisplayed()) {
            return getWebElement().getText();
        }

        throw new TimeoutException("The element associated with " + getBy().toString() + " does not display " +
                "so no text can be retrieved");
    }

    /**
     * Clicks on the BaseElement
     */
    public void click() {
        if(getWebElement() == null) {
            this.webElement = ExpectedConditionsUtils.visibilityOfElementLocated(by, timeout);
        }

        ExpectedConditionsUtils.waitForElementToBeClickable(webElement, timeout);
        webElement.click();

    }

    /**
     * Types text when applicable on a BaseElement
     *
     * @param text String value to type on the page
     */
    public void typeText(String text) {
        if(getWebElement() == null) {
            this.webElement = ExpectedConditionsUtils.visibilityOfElementLocated(by, timeout);
        }

        ExpectedConditionsUtils.waitForElementToBeClickable(webElement, timeout);
        getWebElement().sendKeys(text);

    }

    /**
     * Scrolls the BaseElement into view on the page
     */
    public void scrollInToView(){
        ((JavascriptExecutor) WebDriverThread.getDriver()).executeScript("arguments[0].scrollIntoView(true);",
                getWebElement());
    }
}
