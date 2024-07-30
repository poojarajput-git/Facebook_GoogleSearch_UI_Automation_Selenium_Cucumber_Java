package automation.pages;

import automation.Utilities.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class FacebookPage {
    WebDriver driver;
    Utils utils;
    public FacebookPage(WebDriver driver) {
        this.driver = driver;
        this.utils = new Utils(driver);
    }

    By emailField = By.id("email");
    By passwordField = By.id("pass");
    By loginButton = By.name("login");

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
}

