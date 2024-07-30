package automation.helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverHelper {
    private WebDriver driver;

    public WebDriverHelper() {
        String browser = ConfigReader.getProperty("browser").toLowerCase();

        String chromeDriverPath = ConfigReader.getProperty("chromeDriverPath");
        String chromeBrowserPath = ConfigReader.getProperty("chromeBrowserPath");
        String firefoxDriverPath = ConfigReader.getProperty("firefoxDriverPath");

        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", chromeDriverPath);
                ChromeOptions co = new ChromeOptions();
                co.setBinary(chromeBrowserPath);
                driver = new ChromeDriver(co);
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
                driver = new FirefoxDriver();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        // Common setup for all drivers
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public void closeDriver() {
        if (driver != null) {
            driver.close();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}
