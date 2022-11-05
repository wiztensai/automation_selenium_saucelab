package tests;

import core.driver.AppDriver;
import core.driver.WebDriverManager;
import core.reporter.ExtentUtil;
import core.util.ActionUtil;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.LoginPage;
import pages.ProductListPage;

import java.time.Duration;

public class SortInProductListPage {
    LoginPage loginPage;
    ProductListPage productListPage;
    WebDriver driver;

    @Parameters({"deviceName"})
    @BeforeTest
    public void setup(String deviceName) {
        AppDriver.setDriver(WebDriverManager.getDriverFromParam(deviceName));
        driver = AppDriver.getDriver();

//        driver = WebDriverManager.getDriverFromParam(deviceName);

        loginPage = new LoginPage(driver);
        productListPage = new ProductListPage(driver);
    }

    @Test
    public void sortNameAz() {
        ActionUtil.openUrl(driver,"https://www.saucedemo.com/");
        loginPage.login("standard_user", "secret_sauce");

        productListPage.selectSortNameAZ("Select NAME (A TO Z) in sort dropdown over top navigation");
        productListPage.validateSortNameAZ("Validate product name sorted by ascending name");
    }

    @Test
    public void sortNameZa() {
        ActionUtil.openUrl( driver,"https://www.saucedemo.com/");
        loginPage.login("standard_user", "secret_sauce");

        productListPage.selectSortNameZA("Select NAME (Z TO A) in sort dropdown over top navigation");
        productListPage.validateSortNameZA("Validate product name sorted by descending name");
    }

    @Test
    public void sortPriceLohi() {
        ActionUtil.openUrl(driver,"https://www.saucedemo.com/");
        loginPage.login("standard_user", "secret_sauce");

        productListPage.selectSortPriceLowToHigh("Select PRICE (LOW TO HIGH) in sort dropdown over top navigation");
        productListPage.validateSortPriceLohi("Validate product price sorted from low to high");
    }

    @Test
    public void sortPriceHilo() {
        ActionUtil.openUrl(driver, "https://www.saucedemo.com/");
        loginPage.login("standard_user", "secret_sauce");

        productListPage.selectSortPriceHighToLow("Select PRICE (HIGH TO LOW) in sort dropdown over top navigation");
        productListPage.validateSortPriceHilo("Validate product price sorted from high to low");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
