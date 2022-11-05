package pages;

import core.reporter.ExtentUtil;
import core.util.ActionUtil;
import core.util.LogUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProductListPage {

    private WebDriver driver;
    public ProductListPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='inventory_list']//button[@id='add-to-cart-sauce-labs-backpack'][1]")
    private WebElement btnAddToCartFirstItem;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private WebElement btnCart;

    @FindBy(xpath = "//select[@class='product_sort_container']")
    private WebElement sortDropdown;

    @FindBy(xpath = "//div[@class='inventory_item']//div[@class='inventory_item_name']")
    private List<WebElement> productNameList;

    @FindBy(xpath = "//div[@class='inventory_item']//div[@class='inventory_item_price']")
    private List<WebElement> productPriceList;

    public void selectFirstItem(String msg) {
        ActionUtil.click(btnAddToCartFirstItem, msg);
    }

    public void clickCartButton(String msg){
        ActionUtil.click(btnCart, msg);
    }

    public void selectSortNameAZ(String msg) {
        ActionUtil.selectValueInDropdown(sortDropdown, "az", msg);
    }

    public void selectSortNameZA(String msg) {
        ActionUtil.selectValueInDropdown(sortDropdown, "za", msg);
    }

    public void selectSortPriceLowToHigh(String msg) {
        ActionUtil.selectValueInDropdown(sortDropdown, "lohi", msg);
    }

    public void selectSortPriceHighToLow(String msg) {
        ActionUtil.selectValueInDropdown(sortDropdown, "hilo", msg);
    }

    public void validateSortNameAZ(String msg) {
        ExtentUtil.logInfo(msg);

        // original sort of list product name
        String[] originalArr = new String[productNameList.size()];
        for (int i = 0; i < productNameList.size(); i++) {
            var name = productNameList.get(i).getText();
            System.out.println(name);
            originalArr[i] = name;
        }

        // modified sort to compare
        String[] ascendingArr = originalArr.clone();
        Arrays.sort(ascendingArr);

        Assert.assertEquals(originalArr, ascendingArr);
    }

    public void validateSortNameZA(String msg) {
        ExtentUtil.logInfo(msg);

        // original sort of list product name
        String[] originalArr = new String[productNameList.size()];
        for (int i = 0; i < productNameList.size(); i++) {
            var name = productNameList.get(i).getText();
            System.out.println(name);
            originalArr[i] = name;
        }

        // modified sort to compare
        String[] descendingArr = originalArr.clone();
        Arrays.sort(descendingArr, Collections.reverseOrder());

        Assert.assertEquals(originalArr, descendingArr);
    }

    public void validateSortPriceLohi(String msg) {
        ExtentUtil.logInfo(msg);

        // original sort of list product name
        Double[] originalArr = new Double[productPriceList.size()];
        for (int i = 0; i < productPriceList.size(); i++) {
            var price = productPriceList.get(i).getText();
            var removeDollar = price.replace("$","");
            var castToDouble = Double.valueOf(removeDollar);
            originalArr[i] = castToDouble;
        }

        // modified sort to compare
        Double[] ascendingArr = originalArr.clone();
        Arrays.sort(ascendingArr);

        LogUtil.printArray("originalArr: ", originalArr);
        LogUtil.printArray("ascendingArr: ", ascendingArr);

        Assert.assertEquals(originalArr, ascendingArr);
    }

    public void validateSortPriceHilo(String msg) {
        ExtentUtil.logInfo(msg);

        // original sort of list product name
        Double[] originalArr = new Double[productPriceList.size()];
        for (int i = 0; i < productPriceList.size(); i++) {
            var price = productPriceList.get(i).getText();
            var removeDollar = price.replace("$","");
            var castToDouble = Double.valueOf(removeDollar);
            originalArr[i] = castToDouble;
        }

        // modified sort to compare
        Double[] descendingArr = originalArr.clone();
        Arrays.sort(descendingArr, Comparator.reverseOrder());

        LogUtil.printArray("originalArr: ", originalArr);
        LogUtil.printArray("descendingArr: ", descendingArr);

        Assert.assertEquals(originalArr, descendingArr);
    }
}
