package pages;

import core.util.ActionUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutInfoPage {

    private WebDriver driver;

    public CheckoutInfoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='continue']")
    private WebElement btnContinue;

    @FindBy(xpath = "//input[@id='first-name']")
    private WebElement firstName;

    @FindBy(xpath = "//input[@id='last-name']")
    private WebElement lastName;

    @FindBy(xpath = "//input[@id='postal-code']")
    private WebElement zip;

    public void inputFirstName(String keys, String msg) {
        ActionUtil.sendKeys(firstName, keys, msg);
    }

    public void inputLastName(String keys, String msg) {
        ActionUtil.sendKeys(lastName, keys, msg);
    }

    public void inputZip(String keys, String msg) {
        ActionUtil.sendKeys(zip, keys, msg);
    }

    public void clickContinueBtn(String msg) {
        ActionUtil.click(btnContinue, msg);
    }
}
