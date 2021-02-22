package com.browserstack.demo.selenium.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class LoadProperties {
    public Properties prop;

    public void loadProperties(File properties) {
        try {
            InputStream is = new FileInputStream(properties);
            prop = new Properties();
            prop.load(is);
        } catch (Exception ex) {
            throw new IllegalArgumentException("Error encountered when processing the file: " + properties + ". - " + ex.getMessage());
        }
    }

    public String getProperty(String name) {
        return prop.getProperty(name);
    }
}
