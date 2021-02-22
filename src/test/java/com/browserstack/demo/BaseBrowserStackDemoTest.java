package com.browserstack.demo;

import com.browserstack.demo.selenium.utils.AutomationConfiguration;
import com.browserstack.demo.selenium.utils.ConfigPropertyUtils;
import com.browserstack.demo.selenium.utils.LoadProperties;
import com.browserstack.demo.selenium.utils.WebDriverThread;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;

public class BaseBrowserStackDemoTest {
    String url;

    @BeforeSuite(alwaysRun = true)
    public void bestSuite() {
        LoadProperties uiProperties = new LoadProperties();
        uiProperties.loadProperties(new File("./src/test/resources/config.properties"));
        ConfigPropertyUtils.setMaxWaitTime(uiProperties.getProperty("maxWaitTime"));
        ConfigPropertyUtils.setPollingInterval(uiProperties.getProperty("pollingInterval"));
        ConfigPropertyUtils.setStatusUpdateWait(uiProperties.getProperty("statusUpdateWait"));
        ConfigPropertyUtils.setBroswerWindowHeight(uiProperties.getProperty("browserWindowHeight"));
        ConfigPropertyUtils.setBroswerWindowWidth(uiProperties.getProperty("browserWindowWidth"));

        url = AutomationConfiguration.getProperty("url");
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown(){
        WebDriverThread.quit();
    }
}
