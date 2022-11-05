package core.util;

import core.reporter.ExtentUtil;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class ActionUtil {
    private ActionUtil() {
    }

    static public void openUrl(WebDriver driver, String url) {
        driver.get(url);
        ExtentUtil.logInfo("Open url "+url);
    }

    static public void scrollToElement(WebDriver driver, String title) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", title);
    }

    static public void scrollToFooter(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    static public void click(WebElement element, String msg) {
        element.click();
        ExtentUtil.logInfo(msg);
    }

    static public void sendKeys(WebElement element, String keys, String msg) {
        element.sendKeys(keys);
        ExtentUtil.logInfo(msg);
    }

    static public void selectValueInDropdown(WebElement element, String value, String msg) {
        Select dropdown = new Select(element);
        dropdown.selectByValue(value);
        ExtentUtil.logInfo(msg);
    }

    static public String takeScreenshot(WebDriver driver) {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        return screenshot.getScreenshotAs(OutputType.BASE64);
    }
}
