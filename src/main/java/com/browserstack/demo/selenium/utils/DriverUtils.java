package com.browserstack.demo.selenium.utils;

import org.openqa.selenium.Dimension;

/**
 * Works directly with the WebDriverThread object to work with the Selenium driver
 */
public class DriverUtils {

    /**
     * Opens the WebBrowser, navigates to the supplied URL, and sets the Browser dimensions
     * based on the config.property values
     * @param url String
     */
    public static void navigateToURL(String url) {
        WebDriverThread.getDriver().get(url);
    }

    /**
     * Sets the Browser Dimension based on the config.property for browser width and height
     * @return Dimension
     */
    public static Dimension getBrowserDimension() {
        return new Dimension(ConfigPropertyUtils.getBroswerWindowWidth(), ConfigPropertyUtils.getBroswerWindowHeight());
    }

    /**
     * Returns the current URL during test execution
     *
     * @return String
     */
    public static String getCurrentURL() {
        return WebDriverThread.getDriver().getCurrentUrl();
    }

    /**
     * Returns the current title during test execution
     *
     * @return String
     */
    public static String getTitle() {
        return WebDriverThread.getDriver().getTitle();
    }

    /**
     * Returns the window handle
     *
     * @return String
     */
    public static String getWindowHandle() {
        return WebDriverThread.getDriver().getWindowHandle();
    }

    /**
     * Refreshes the driver instance.
     * Note: elements on the page may need to be reinitialized
     */
    public static void refreshPage() {
        WebDriverThread.getDriver().navigate().refresh();
    }
}
