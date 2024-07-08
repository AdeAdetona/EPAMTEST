package PAGES;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utility.BasePage;

public class PhonesAndAccessoriesPage extends BasePage{
	
	@FindBy(linkText = "Mobile Phones")
    private WebElement mobilePhonesMenu;

    public PhonesAndAccessoriesPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToMobilePhones() {
        mobilePhonesMenu.click();
    }

}
