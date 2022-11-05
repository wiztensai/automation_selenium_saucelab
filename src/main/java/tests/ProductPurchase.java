package tests;

import core.driver.AppDriver;
import core.driver.WebDriverManager;
import core.reporter.ExtentUtil;
import core.util.ActionUtil;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.*;

import java.time.Duration;

public class ProductPurchase {
    LoginPage loginPage;
    ProductListPage plp;
    CartPage cartPage;
    CheckoutInfoPage checkoutInfoPage;
    CheckoutOverviewPage checkoutOverviewPage;

    CheckoutCompletePage checkoutCompletePage;

    WebDriver driver;

    @Parameters({"deviceName"})
    @BeforeTest
    public void setup(String deviceName) {
        AppDriver.setDriver(WebDriverManager.getDriverFromParam(deviceName));
        driver = AppDriver.getDriver();

//        driver = WebDriverManager.getDriverFromParam(deviceName);

        loginPage = new LoginPage(driver);
        plp = new ProductListPage(driver);
        cartPage = new CartPage(driver);
        checkoutInfoPage = new CheckoutInfoPage(driver);
        checkoutOverviewPage = new CheckoutOverviewPage(driver);
        checkoutCompletePage = new CheckoutCompletePage(driver);
    }

    @Test
    public void makingOrder() {
        ActionUtil.openUrl(driver,"https://www.saucedemo.com/");

        loginPage.login("standard_user", "secret_sauce");

        plp.selectFirstItem("Click 'ADD TO CART' button to first product in PLP");
        plp.clickCartButton("Click cart button in top navigation");

        cartPage.clickCheckoutButton("Click 'CHECKOUT' button in YOUR CART page");

        checkoutInfoPage.inputFirstName("asd", "Input 'asd' to 'First Name' textbox in CHECKOUT: YOUR INFORMATION page");
        checkoutInfoPage.inputLastName("asd", "Input 'asd' to 'Last Name' textbox");
        checkoutInfoPage.inputZip("1234", "Input '1234' to ZIP' textbox");
        checkoutInfoPage.clickContinueBtn("Click continue button");

        checkoutOverviewPage.clickFinishBtn("Click 'CONTINUE' button in CHECKOUT: OVERVIEW page");

        var checkoutMsg = checkoutCompletePage.getCheckoutMsg();
        Assert.assertTrue(checkoutMsg.contains("Your order has been dispatched"));
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
