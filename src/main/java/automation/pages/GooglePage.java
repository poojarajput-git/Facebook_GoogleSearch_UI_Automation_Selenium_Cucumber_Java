package automation.pages;

import automation.Utilities.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GooglePage {
    WebDriver driver;
    Utils utils;

    public GooglePage(WebDriver driver) {

        this.driver = driver;
        this.utils = new Utils(driver);
    }

    By searchField = By.name("q");
    By searchButton = By.name("btnK");


    public void enterSearchText(String text) {
        driver.findElement(searchField).sendKeys(text);
    }

    public void clickSearchButton() {
        driver.findElement(searchButton).submit();
    }
}

