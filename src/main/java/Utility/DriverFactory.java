package Utility;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

	//public static WebDriver getDriver() {
		//System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver_win32\\chromedriver.exe");
       // return new ChromeDriver();
        
	//}
      // public static WebDriver getDriver() {
         //  System.setProperty("webdriver.firefox.driver","C:\\Program Files\\Mozilla Firefox\\firefox.exe");
           //return new FirefoxDriver();
     // }      
      public static WebDriver getDriver() {
          System.setProperty("webdriver.edge.driver","C:\\Program Files\\edgedriver\\msedgedriver.exe");
           return new EdgeDriver();     
            
	}
}
