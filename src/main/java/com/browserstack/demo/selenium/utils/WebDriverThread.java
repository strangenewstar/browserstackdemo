package com.browserstack.demo.selenium.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class WebDriverThread {
    //having these hardcoded here isn't great as it would be in a DB but out of scope for this
    public static final String AUTOMATE_USERNAME = "jessicarosen2";
    public static final String AUTOMATE_ACCESS_KEY = "axDJsQEJxQFzgLTSNTcp";
    public static final String url = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";

    private static ThreadLocal<WebDriver> driver = ThreadLocal.withInitial(() -> {
                DesiredCapabilities caps = new DesiredCapabilities();
                caps.setCapability("browserName", System.getenv("browserName"));
                caps.setCapability("version", System.getenv("version"));
                caps.setCapability("platform", System.getenv("platform"));
                caps.setCapability("screenResolution", System.getenv("screenResolution"));
                caps.setCapability("name", System.getenv("testName")); // test name
                caps.setCapability("build", System.getenv("buildName")); // CI/CD job or build name
                try {
                    return new RemoteWebDriver(new URL(url), caps);
                } catch (MalformedURLException e) {
                    return null;
                }
            });

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void close() {
        driver.get().close();
    }

    public static void quit() {
        driver.get().quit();
    }

    /**
     * Clears cookies on web driver thread, used as a failsafe to logout of platform
     */
    public static void resetState() {
        driver.get().manage().deleteAllCookies();
    }

    @Deprecated
    public static void webDriverQuit() {
        getDriver().quit();
    }
}
