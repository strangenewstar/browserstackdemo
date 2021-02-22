package com.browserstack.demo.selenium.utils;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

import java.io.File;

import static java.util.Optional.ofNullable;

/**
 * Loads the configuration property file and retrieves relevant values
 */
public class AutomationConfiguration {

    private static final Configuration config;

    static {
        Configurations configs = new Configurations();
        try {
            config = configs.properties(new File("C:\\Users\\jrosen\\git\\demo\\src\\test\\resources\\config.properties"));
        } catch (ConfigurationException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Returns a property value associated with the supplied property name
     *
     * @param propertyName String name of the property
     * @return String property value
     */
    public static String getProperty(final String propertyName) {
        return ofNullable(System.getenv(propertyName))
                .or(() -> ofNullable(System.getProperty(propertyName)))
                .orElse(config.getString(propertyName));
    }

//    public static String getPropertyOrDefault(final String propertyName, final String defaultValue) {
//        return ofNullable(System.getenv(propertyName))
//                .or(() -> ofNullable(System.getProperty(propertyName)))
//                .or(() -> ofNullable(config.getString(propertyName)))
//                .orElse(defaultValue);
//    }
}

