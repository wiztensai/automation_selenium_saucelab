package core.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class WebDriverManager {
    static public WebDriver chromeDriver(){
        System.setProperty("webdriver.chrome.driver", "E:/My Software Project/Selenium Projects/chromedriver.exe");
        return new ChromeDriver();
    }

    static public WebDriver firefoxDriver(){
        System.setProperty("webdriver.gecko.driver", "E:/My Software Project/Selenium Projects/geckodriver.exe");
        var option = new FirefoxOptions();
        option.setBinary("C:/Program Files/Mozilla Firefox/firefox.exe");
        return new FirefoxDriver(option);
    }

    static public WebDriver edgeDriver(){
        System.setProperty("webdriver.edge.driver", "E:/My Software Project/Selenium Projects/msedgedriver.exe");
        return new EdgeDriver();
    }

    static public WebDriver getDriverFromParam(String deviceName) {
        if (deviceName.equalsIgnoreCase("chrome")) {
            return WebDriverManager.chromeDriver();
        } else if (deviceName.equalsIgnoreCase("firefox")) {
            return WebDriverManager.firefoxDriver();
        } else {
            return WebDriverManager.edgeDriver();
        }
    }
}
