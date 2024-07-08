package Utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
public class Browersmanager extends DriverManager{

	public WebDriver initChrome(){
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    public WebDriver initEdge(){
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver();
    }   
     public WebDriver initFirefox(){
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
    }
    public WebDriver initChromeHeadless(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable gpu", "--headless");
        return new ChromeDriver(options);
    }

    public void launchBrowser(String browser){
        WebDriver getDriver;
		switch (browser){
            case "chrome": getDriver = initChrome();
                break;
            case "edge": getDriver =  initEdge();
                break;
            case "firefox": getDriver =  initFirefox();
                 break;
            case "headless": getDriver =  initChromeHeadless();
                break;
            default: getDriver = initChrome();
                break;
        }
     //   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
     //   driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        getDriver.manage().window().maximize();
    }
    public  void  closeBrowser(){
        WebDriver getDriver = null;
		getDriver.manage().deleteAllCookies();
        getDriver.quit();
    }

}
