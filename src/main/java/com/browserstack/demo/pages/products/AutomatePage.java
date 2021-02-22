package com.browserstack.demo.pages.products;

import com.browserstack.demo.selenium.elements.BaseElement;
import com.browserstack.demo.selenium.utils.AttributeType;
import com.browserstack.demo.selenium.utils.ExpectedConditionsUtils;
import com.browserstack.demo.selenium.utils.SeleniumUtils;

/**
 * This is the Automate landing page. Any elements that are specific to the
 * Automate Landing page shall be defined here.
 *
 * The constuctor waits for the visibility of the Header Title as a basis for
 * this page loading.
 */
public class AutomatePage {

    public AutomatePage() {
        ExpectedConditionsUtils.visibilityOfElementLocated(
                SeleniumUtils.generateBy(AttributeType.CSS_SELECTOR, ".sec-header-title"),
                10);
    }
}
