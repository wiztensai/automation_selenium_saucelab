package tests.practice;

import core.driver.WebDriverManager;
import core.reporter.ExtentUtil;
import core.util.ActionUtil;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class NoPom {
    @Test
    public void chrome() {
        var driver = WebDriverManager.chromeDriver();
        ExtentUtil.setCategory("chrome");

        ActionUtil.openUrl(driver, "https://www.saucedemo.com/");
        var firstProduct = driver.findElement(By.xpath("//input[@id='login-button']")) ;
        ActionUtil.click(firstProduct, "Click login button");

        driver.quit();
    }

    @Test
    public void firefox() {
        var driver = WebDriverManager.firefoxDriver();
        ExtentUtil.setCategory("firefox");

        ActionUtil.openUrl(driver, "https://www.saucedemo.com/");
        var firstProduct = driver.findElement(By.xpath("//input[@id='login-button']")) ;
        ActionUtil.click(firstProduct, "Click login button");

        driver.quit();
    }

    @Test
    public void edge() {
        var driver = WebDriverManager.edgeDriver();
        ExtentUtil.setCategory("edge");

        ActionUtil.openUrl(driver, "https://www.saucedemo.com/");
        var firstProduct = driver.findElement(By.xpath("//input[@id='login-button']")) ;
        ActionUtil.click(firstProduct, "Click login button");

        driver.quit();
    }
}
