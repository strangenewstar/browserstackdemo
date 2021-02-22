package com.browserstack.demo;

import com.browserstack.demo.selenium.utils.AutomationConfiguration;
import com.browserstack.demo.selenium.utils.ConfigPropertyUtils;
import com.browserstack.demo.selenium.utils.LoadProperties;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;

public class BaseBrowserStackDemoTest {
    String url;

    @BeforeSuite(alwaysRun = true)
    public void bestSuite() throws IOException, InstantiationException {
        LoadProperties uiProperties = new LoadProperties();
        uiProperties.loadProperties(new File("./src/test/resources/config.properties"));
        ConfigPropertyUtils.setMaxWaitTime(uiProperties.getProperty("maxWaitTime"));
        ConfigPropertyUtils.setPollingInterval(uiProperties.getProperty("pollingInterval"));
        ConfigPropertyUtils.setStatusUpdateWait(uiProperties.getProperty("statusUpdateWait"));
        ConfigPropertyUtils.setBroswerWindowHeight(uiProperties.getProperty("browserWindowHeight"));
        ConfigPropertyUtils.setBroswerWindowWidth(uiProperties.getProperty("browserWindowWidth"));

        url = AutomationConfiguration.getProperty("url");
    }
}
