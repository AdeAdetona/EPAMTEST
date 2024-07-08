package PAGES;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utility.BasePage;

public class HomePage extends BasePage{
	
	@FindBy(linkText = "All")
    private WebElement allMenu;

    @FindBy(linkText = "Electronics and Computers")
    private WebElement electronicsAndComputersMenu;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void navigateToElectronicsAndComputers() {
        allMenu.click();
        electronicsAndComputersMenu.click();
    }

}
