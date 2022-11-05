package core.driver;

import org.openqa.selenium.WebDriver;

public class AppDriver {
    static private ThreadLocal <WebDriver> driver = new ThreadLocal<WebDriver>();

    static public WebDriver getDriver() {
        return driver.get();
    }

    static public void setDriver(WebDriver driver) {
        AppDriver.driver.set(driver);
    }
}
