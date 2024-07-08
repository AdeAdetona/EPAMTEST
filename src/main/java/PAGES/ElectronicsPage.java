package PAGES;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utility.BasePage;

public class ElectronicsPage extends BasePage{
	
	@FindBy(linkText = "Phones and Accessories")
    private WebElement phonesAndAccessoriesMenu;

    public ElectronicsPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToPhonesAndAccessories() {
        phonesAndAccessoriesMenu.click();
    }

}
