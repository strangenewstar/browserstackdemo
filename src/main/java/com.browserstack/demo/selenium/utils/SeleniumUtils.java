package com.browserstack.demo.selenium.utils;

import org.openqa.selenium.By;

public class SeleniumUtils {
    public static By generateBy(AttributeType attributeType, String locator) {
        switch(attributeType) {
            case CLASS_NAME: return By.className(locator);
            case CSS_SELECTOR: return By.cssSelector(locator);
            case ID: return By.id(locator);
            case LINK_TEXT: return By.linkText(locator);
            case NAME: return By.name(locator);
            case PARTIAL_LINK_TEXT: return By.partialLinkText(locator);
            case TAG_NAME: return By.tagName(locator);
            default: return By.xpath(locator);
        }
    }
}
