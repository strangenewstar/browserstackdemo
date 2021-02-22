package com.browserstack.demo.selenium.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ExpectedConditionsUtils {
    static int pollingInterval = ConfigPropertyUtils.getPollingInterval();

    @SuppressWarnings("unchecked")
    private static ExpectedCondition<WebElement> invokeElementExpectedCondition(By locator, String methodName)
            throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException,
            InvocationTargetException {
        Method method = org.openqa.selenium.support.ui.ExpectedConditions.class.getDeclaredMethod(methodName, new Class[] { By.class });
        return (ExpectedCondition<WebElement>) method.invoke(null, locator);
    }

    private static ExpectedCondition<Boolean> invokeElementExpectedConditionByInvisiblility(By locator) {
        return org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOfElementLocated(locator);
    }

    public static WebElement presenceOfElementLocated(By locator, int timeout) {
        try {
            return (new WebDriverWait(WebDriverThread.getDriver(), timeout, pollingInterval))
                    .until(invokeElementExpectedCondition(locator, "presenceOfElementLocated"));
        } catch (Exception ex) {
            return null;
        }
    }

    public static WebElement visibilityOfElementLocated(By locator, int timeout) {
        try {
            return (new WebDriverWait(WebDriverThread.getDriver(), timeout, pollingInterval))
                    .until(invokeElementExpectedCondition(locator, "visibilityOfElementLocated"));
        } catch (Exception ex) {
            return null;
        }
    }

    public static Boolean waitUntilElementIsInvisible(By locator, int timeout) {
        return (new WebDriverWait(WebDriverThread.getDriver(), timeout, pollingInterval))
                .until(invokeElementExpectedConditionByInvisiblility(locator));
    }

    public static void waitForElementToBeClickable(WebElement elt, int timeout) {
        new WebDriverWait(WebDriverThread.getDriver(), timeout, pollingInterval)
                .until(ExpectedConditions.elementToBeClickable(elt));
    }
}
