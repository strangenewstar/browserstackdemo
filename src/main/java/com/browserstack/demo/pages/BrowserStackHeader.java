package com.browserstack.demo.pages;

import com.browserstack.demo.pages.products.AutomatePage;
import com.browserstack.demo.selenium.elements.BaseElement;
import com.browserstack.demo.selenium.utils.AttributeType;

/**
 * This is the shared Browserstack Header. Any elements that are specific to the
 * Browserstack Header shall be defined here.
 */
public class BrowserStackHeader {

    /**
     * An enumeration for Main Header elements. This is not an exhaustive list for the
     * demo. Only the hyperlink title for Products has been filled out as the demo
     * interacts with this element only.
     */
    public enum MAIN_HEADER {
        PRODUCTS("product-menu-toggle"),
        DEVELOPERS(""),
        LIVE_FOR_TEAMS(""),
        PRICING("");

        String hyperlinkTitle;
        MAIN_HEADER(String hyperlinkTitle) {
            this.hyperlinkTitle = hyperlinkTitle;
        }

        public BaseElement getHyperlinkTitle() {
            return new BaseElement(AttributeType.ID, hyperlinkTitle);
        }
    }

    /**
     * An enumeration for Main Header Product Select elements. This is not an exhaustive list for the
     * demo. Only the hyperlink title for Automate has been filled out as the demo
     * interacts with this element only.
     */
    public enum PRODUCTS {
        //small subset for demo only
        AUTOMATE("a[title='Automate']"),
        PERCY("");

        String hyperlinkTitle;
        PRODUCTS(String hyperlinkTitle) {
            this.hyperlinkTitle = hyperlinkTitle;
        }

        public BaseElement getHyperlinkTitle() {
            return new BaseElement(AttributeType.CSS_SELECTOR, hyperlinkTitle);
        }
    }

    BaseElement docSearchIcon;
    private void initDocSearchIcon() {
        docSearchIcon = new BaseElement(AttributeType.CSS_SELECTOR, "a[title='Docs Search']");
    }

    public BaseElement getDocSearchIcon() {
        if(docSearchIcon == null) {
            initDocSearchIcon();
        }

        return docSearchIcon;
    }

    BaseElement docSearchTextField;
    private void initDocSearchTextfield() {
        docSearchTextField = new BaseElement(AttributeType.ID, "doc-search-box-input");
    }

    public BaseElement getDocSearchTextField() {
        if(docSearchTextField == null) {
            initDocSearchTextfield();
        }

        return docSearchTextField;
    }

    public BaseElement enterDocSearchBtn;
    private void initEnterDocSearchBtn() {
        enterDocSearchBtn = new BaseElement(AttributeType.CSS_SELECTOR, "button[title='Submit the search query.']");
    }

    public BaseElement getEnterDocSearchBtn() {
        if(enterDocSearchBtn == null) {
            initEnterDocSearchBtn();
        }

        return enterDocSearchBtn;
    }

    /**
     * Clicks on a header link.
     *
     * @param mainHeader an enum value defined within MAIN_HEADER
     */
    public void clickMainHeaderHyperlink(MAIN_HEADER mainHeader) {
        mainHeader.getHyperlinkTitle().click();
    }

    /**
     * Clicks on the 'Products' header link followed by the 'Automate' option.
     * @return instance of AutomatePage
     */
    public AutomatePage navigateToAutomatePage() {
        clickMainHeaderHyperlink(MAIN_HEADER.PRODUCTS);
        PRODUCTS.AUTOMATE.getHyperlinkTitle().click();
        return new AutomatePage();
    }

    /**
     * Clicks on the search icon and enters a String value in the search text field. Once
     * completed the enter button is clicked.
     *
     * @param documentSearchStr The string a user wishes to search for
     * @return instance of SearchResultsPage
     */
    public SearchResultsPage searchDocuments(String documentSearchStr) {
        getDocSearchIcon().click();
        getDocSearchTextField().typeText(documentSearchStr);
        getEnterDocSearchBtn().click();

        return new SearchResultsPage();
    }
}
