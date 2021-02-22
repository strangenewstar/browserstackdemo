package com.browserstack.demo.selenium.utils;

/**
 * Sets Configuration values to ThreadLocal instances.
 */
public class ConfigPropertyUtils {
    private static ThreadLocal<Integer> maxWaitTime = new ThreadLocal<Integer>();
    private static ThreadLocal<Integer> pollingInterval = new ThreadLocal<Integer>();
    private static ThreadLocal<Integer> loadingIconDisappearTime = new ThreadLocal<Integer>();
    private static ThreadLocal<Integer> statusUpdateWait = new ThreadLocal<Integer>();
    private static ThreadLocal<Integer> browserWindowWidth = new ThreadLocal<Integer>();
    private static ThreadLocal<Integer> browserWindowHeight = new ThreadLocal<Integer>();
    private static ThreadLocal<Integer> browserVersion = new ThreadLocal<>();
    private static ThreadLocal<Boolean> browserVersionAuto = new ThreadLocal<>();
    private static ThreadLocal<Boolean> driverDownloadForce = new ThreadLocal<>();

    public static void setMaxWaitTime(String secondWait) {
        maxWaitTime.set(Integer.parseInt(secondWait));
    }

    public static int getMaxWaitTime() {
        return maxWaitTime.get();
    }

    public static void setPollingInterval(String pollingIntervalTime) {
        pollingInterval.set(Integer.parseInt(pollingIntervalTime));
    }

    public static int getPollingInterval() {
        return pollingInterval.get();
    }

    public static void setLoadingIconDisappearMaxTime(String loadingIconDisappearMaxTime) {
        loadingIconDisappearTime.set(Integer.parseInt(loadingIconDisappearMaxTime));
    }

    public static int getLoadingIconDisappearMaxTime() {
        return loadingIconDisappearTime.get();
    }

    public static void setStatusUpdateWait(String statusUpdateTime) {
        statusUpdateWait.set(Integer.parseInt(statusUpdateTime));
    }

    public static int getStatusUpdateWait() {
        return statusUpdateWait.get();
    }

    public static void setBroswerWindowWidth(String browserWidth) {
        browserWindowWidth.set(Integer.parseInt(browserWidth));
    }

    public static int getBroswerWindowWidth() { return browserWindowWidth.get(); }

    public static void setBroswerWindowHeight(String browserHeight) {
        browserWindowHeight.set(Integer.parseInt(browserHeight));
    }

    public static int getBroswerWindowHeight() { return browserWindowHeight.get(); }

//    public static void setBrowserType(String browser) {
//        browserType.set(DRIVER_TYPE.valueOf(browser.toUpperCase()));
//    }

//    public static DRIVER_TYPE getBrowserType() {
//        return browserType.get();
//    }

//    public static void setOSType(String os) {
//        osType.set(OS_TYPE.valueOf(os.toUpperCase()));
//    }

//    public static OS_TYPE getOSType() {
//        return osType.get();
//    }
}
