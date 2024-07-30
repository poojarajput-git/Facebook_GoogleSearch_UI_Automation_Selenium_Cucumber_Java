package automation.steps;

import automation.helper.ExtentManager;
import automation.helper.WebDriverHelper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

public class Hooks {

    private static ExtentReports extent = ExtentManager.getReporter();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    private static WebDriverHelper webDriverHelper = new WebDriverHelper();
    private static WebDriver driver;

    @Before
    public void beforeScenario(Scenario scenario) {
        ExtentTest extentTest = extent.createTest(scenario.getName());
        test.set(extentTest);
        driver = webDriverHelper.getDriver();
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            test.get().fail("Scenario failed");
            // Add screenshot or other details if necessary
        } else {
            test.get().pass("Scenario passed");
        }
        extent.flush();
        //webDriverHelper.closeDriver();
    }

    public static ExtentTest getTest() {
        return test.get();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
