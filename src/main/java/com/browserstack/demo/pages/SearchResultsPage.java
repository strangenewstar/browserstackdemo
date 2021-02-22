package com.browserstack.demo.pages;

import com.browserstack.demo.selenium.elements.BaseElement;
import com.browserstack.demo.selenium.utils.AttributeType;

/**
 * This is the Search Results page. Any elements that are specific to the
 * Search Results page shall be defined here.
 *
 * The constuctor waits for the visibility of the Header Title as a basis for
 * this page loading.
 */
public class SearchResultsPage {

    public BaseElement searchResultsDescription;
    private void initSearchResultsDescription() {
        searchResultsDescription = new BaseElement(AttributeType.ID, "all-ds-stats");
    }

    public BaseElement getSearchResultsDescription() {
        if(searchResultsDescription == null) {
            initSearchResultsDescription();
        }

        return searchResultsDescription;
    }

    public String getSearchResultsText() {
        return getSearchResultsDescription().getText();
    }
}
