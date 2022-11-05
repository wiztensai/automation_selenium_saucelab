package tests.practice;

import core.driver.WebDriverManager;
import core.reporter.ExtentUtil;
import core.util.ActionUtil;
import org.testng.annotations.Test;
import pages.LoginPage;

public class Pom {
    @Test
    public void chrome() {
        var driver = WebDriverManager.chromeDriver();
        ExtentUtil.setCategory("chrome");

        ActionUtil.openUrl(driver,"https://www.saucedemo.com/");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.click("Click login button");

        driver.quit();
    }
}
