package com.browserstack.demo.selenium.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverThread {
    private static ThreadLocal<WebDriver> driver = ThreadLocal.withInitial(() -> {
//        Driver.OS_TYPE os = ConfigPropertyUtils.getOSType();
//        if (Driver.OS_TYPE.MAC.equals(os) || Driver.OS_TYPE.LINUX.equals(os)) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
//        } else if (Driver.OS_TYPE.WINDOWS.equals(os)) {
//            System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
//        }

        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(Boolean.TRUE);
        options.addArguments("--no-sandbox", "--ignore-certificate-errors");

        return new ChromeDriver(options); //You can use other driver based on your requirement.
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
