package automation.steps;

import automation.helper.WebDriverHelper;
import automation.pages.GooglePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

public class GoogleSteps {

    private WebDriver driver;
    private GooglePage googlePage;

    public GoogleSteps() {
        this.driver = Hooks.getDriver();
    }

    @Given("I am on the Google search page")
    public void i_am_on_the_google_search_page() {
        driver.get("https://www.google.com/");
        googlePage = new GooglePage(driver);
        Hooks.getTest().info("Navigated to Google search page");
    }

    @When("I enter the search text {string}")
    public void i_enter_the_search_text(String searchText) {
        googlePage.enterSearchText(searchText);
        Hooks.getTest().info("Entered search text: " + searchText);
    }

    @When("I click on the search button")
    public void i_click_on_the_search_button() {
        googlePage.clickSearchButton();
        Hooks.getTest().info("Clicked on search button");
    }

    @Then("I should see the search results")
    public void i_should_see_the_search_results() {
        // Add assertions or checks to verify search results
        Hooks.getTest().info("Search results displayed");
    }
}
