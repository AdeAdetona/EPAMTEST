package PAGES;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import Utility.BasePage;

import java.util.List;

public class MobilePhonesPage extends BasePage {
	
	@FindBy(xpath = "//span[contains(text(),'Samsung') and contains(text(),'20 MP') and contains(text(),'2023') and contains(text(),'£50 - £100')]")
    private List<WebElement> samsungPhones;

    public MobilePhonesPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getSamsungPhones() {
        return samsungPhones;
    }

}
