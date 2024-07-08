package StepDefinitions;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import PAGES.ElectronicsPage;
import PAGES.HomePage;
import PAGES.MobilePhonesPage;
import PAGES.PhonesAndAccessoriesPage;
import Utility.DriverFactory;
import Utility.LoggerHelper;
import Utility.ReportManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MobilePhonesStep {
	
	private WebDriver driver;
    private HomePage homePage;
    private ElectronicsPage electronicsPage;
    private PhonesAndAccessoriesPage phonesAndAccessoriesPage;
    private MobilePhonesPage mobilePhonesPage;

    @Before
    public void setUp() {
        driver = DriverFactory.getDriver();
        homePage = new HomePage(driver);
        electronicsPage = new ElectronicsPage(driver);
        phonesAndAccessoriesPage = new PhonesAndAccessoriesPage(driver);
        mobilePhonesPage = new MobilePhonesPage(driver);
        ReportManager.setUpReport();
        LoggerHelper.log("Test setup completed.");
    }

    @Given("user is on Amazon homepage")
    public void user_is_on_Amazon_homepage() {
        driver.get("https://www.amazon.co.uk");
        ReportManager.createTest("List all Samsung phones with specified specifications");
        LoggerHelper.log("Navigated to Amazon homepage.");
    }

    @When("user navigates to Mobile Phones section")
    public void user_Navigates_to_Mobile_Phones_Section() {
        homePage.navigateToElectronicsAndComputers();
        electronicsPage.navigateToPhonesAndAccessories();
        phonesAndAccessoriesPage.navigateToMobilePhones();
        LoggerHelper.log("Navigated to Mobile Phones section.");
    }

    @Then("user lists all Samsung phones with specified specifications")
    public void user_Lists_All_samsung_Phones_with_specified_specifications() {
        List<WebElement> samsungPhones = mobilePhonesPage.getSamsungPhones();
        Assert.assertFalse(samsungPhones.isEmpty(), "No Samsung phones found with specified specifications.");
        LoggerHelper.log("Listed all Samsung phones with specified specifications.");
        ReportManager.getTest().pass("Successfully listed Samsung phones.");
    }

    @After
    public void  tearDown (Scenario scenario) {
        if (scenario.isFailed()) {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(source, new File("./screenshots/" + scenario.getName() + ".png"));
                LoggerHelper.log("Screenshot taken for failed scenario: " + scenario.getName());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (driver != null) {
            driver.quit();
        }
        ReportManager.tearDownReport();
        LoggerHelper.log("Test execution completed.");
    }

}
