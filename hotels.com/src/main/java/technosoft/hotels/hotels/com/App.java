package technosoft.hotels.hotels.com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Hello world!
 *
 */
public class App 
{
	WebDriver driver = null;
	private static String URL = "https://www.facebook.com/";
    public void ChromeDriverpick(){
    	System.setProperty("webdriver.gecko.driver", "WebDrivers/geckodriver.exe");
    	driver = new FirefoxDriver();
    }
    
    
    @BeforeMethod
    public void chooseDriver(){
    	ChromeDriverpick();
    }
    
    @Test
    public void gotoHome() throws InterruptedException{
    	driver.navigate().to(URL);
    }
}
