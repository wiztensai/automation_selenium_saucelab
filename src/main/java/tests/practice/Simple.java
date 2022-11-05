package tests.practice;

import core.driver.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Simple {
    @Test
    public void chrome() {
        System.setProperty("webdriver.chrome.driver", "E:/My Software Project/Selenium Projects/chromedriver.exe");
        var driver =  new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.saucedemo.com/");
        var btnLogin = driver.findElement(By.xpath("//input[@id='login-button']")) ;
        btnLogin.click();

        driver.quit();
    }
}
