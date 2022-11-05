package pages;

import core.util.ActionUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='login-button']")
    private WebElement btnLogin;

    @FindBy(xpath = "//input[@id='user-name']")
    private WebElement fUsername;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement fPassword;

    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement errorMessage;

    public void click(String msg) {
        ActionUtil.click(btnLogin, msg);
    }

    public void login(String username, String password) {
        ActionUtil.sendKeys(fUsername, username, "Input "+username+" to username textbox");
        ActionUtil.sendKeys(fPassword, password, "Input "+password+" to password textbox");
        ActionUtil.click(btnLogin, "Click login button");
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }
}
