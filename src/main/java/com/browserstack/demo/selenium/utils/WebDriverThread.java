package com.browserstack.demo.selenium.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class WebDriverThread {

    public static final String AUTOMATE_USERNAME = "jessicarosen2";
    public static final String AUTOMATE_ACCESS_KEY = "axDJsQEJxQFzgLTSNTcp";
    public static final String url = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";

    //https://live.browserstack.com/dashboard#os=Windows&os_version=7&browser=IE&browser_version=8.0&scale_to_fit=true&url=www.google.com&resolution=responsive-mode&speed=1&start=true

    private static ThreadLocal<WebDriver> driver = ThreadLocal.withInitial(() -> {
                DesiredCapabilities caps = new DesiredCapabilities();
                caps.setCapability("browserName", System.getenv("browser"));
                caps.setCapability("version", "latest");
                caps.setCapability("platform", "Windows");
                caps.setCapability("screenResolution", "1024x768");
                caps.setCapability("name", "Browserstack Demo Test"); // test name
                caps.setCapability("build", "test"); // CI/CD job or build name
                try {
                    return new RemoteWebDriver(new URL(url), caps);
                } catch (MalformedURLException e) {
                    return null;
                }
            });
//        Driver.OS_TYPE os = ConfigPropertyUtils.getOSType();
//        if (Driver.OS_TYPE.MAC.equals(os) || Driver.OS_TYPE.LINUX.equals(os)) {
//            System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
//        } else if (Driver.OS_TYPE.WINDOWS.equals(os)) {
//            System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
//        }

//        ChromeOptions options = new ChromeOptions();
//        options.setAcceptInsecureCerts(Boolean.TRUE);
//        options.addArguments("--no-sandbox", "--ignore-certificate-errors");
//
//        return new ChromeDriver(options); //You can use other driver based on your requirement.



    public static WebDriver getDriver() {
        System.out.println("driver: " + driver);
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
