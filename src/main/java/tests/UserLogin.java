package tests;

import core.driver.AppDriver;
import core.driver.WebDriverManager;
import core.reporter.ExtentUtil;
import core.util.ActionUtil;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;

import java.time.Duration;

public class UserLogin {
    LoginPage loginPage;
    WebDriver driver;

    @Parameters({"deviceName"})
    @BeforeTest
    public void setup(String deviceName) {
        AppDriver.setDriver(WebDriverManager.getDriverFromParam(deviceName));
        driver = AppDriver.getDriver();

//        driver = WebDriverManager.getDriverFromParam(deviceName);
        loginPage = new LoginPage(driver);
    }

    @Test
    public void loginWithInvalidData() {
        ActionUtil.openUrl(driver, "https://www.saucedemo.com/");
        loginPage.login("standard_user", "asdf");

        var errorMessage = loginPage.getErrorMessage();
        Assert.assertTrue(errorMessage.contains("do not match"));
    }

    @Test
    public void loginWithValidData() {
        ActionUtil.openUrl(driver, "https://www.saucedemo.com/");
        loginPage.login("standard_user", "secret_sauce");
    }

    @Test
    public void logout() {
        ActionUtil.openUrl(driver, "https://www.saucedemo.com/");
        Assert.assertTrue(false);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
