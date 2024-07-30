package automation.steps;

import automation.Utilities.ExcelUtils;
import automation.pages.FacebookPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;


public class FacebookSteps {
    private WebDriver driver;
    private FacebookPage facebookPage;
    private ExcelUtils excelUtils;

    public FacebookSteps() {
        this.driver = Hooks.getDriver();
        this.excelUtils = new ExcelUtils("./src/test/resources/testData/testdataSheet.xlsx");
    }


    @Given("I am on the Facebook login page")
    public void i_am_on_the_facebook_login_page() {
        driver.get("https://www.facebook.com/");
        facebookPage = new FacebookPage(driver);
        Hooks.getTest().info("Navigating to Facebook login page");

    }

    @When("I enter the email and password")
    public void i_enter_the_email_and_password() {
        String email = excelUtils.getCellData("Login Credentials", 1, 1);
        facebookPage.enterEmail(email);
        String password = excelUtils.getCellData("Login Credentials", 1, 2);
        facebookPage.enterPassword(password);
        Hooks.getTest().info("Entering email: " + email + " and password: " + password);

    }

    @Then("I click on the login button")
    public void i_click_on_the_login_button() {
        facebookPage.clickLoginButton();
        Hooks.getTest().info("Clicking on login button");
    }

}
