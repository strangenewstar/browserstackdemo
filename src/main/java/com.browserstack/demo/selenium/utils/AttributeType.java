package com.browserstack.demo.selenium.utils;

/**
 * AttributeTypes defined by Selenium that can be used to create a BaseElement
 */
public enum AttributeType {
    CLASS_NAME("class"),
    CSS_SELECTOR("cssSelector"),
    ID("id"),
    LINK_TEXT("linkText"),
    NAME("name"),
    PARTIAL_LINK_TEXT("partialLinkText"),
    TAG_NAME("tagName"),
    XPATH("xpath");

    private String attributeType;
    AttributeType(String attributeType) {
        this.attributeType = attributeType;
    }

    @Override
    public String toString() {
        return attributeType;
    }
}
