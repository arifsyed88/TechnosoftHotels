package utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class WebDriverFactory {
	
	private static WebDriver driver = null;
	private static final String URL = "https://www.hotels.com/";
	public static final String USERNAME = ""; //Enter Sauce Labs user name (if needed)
	public static final String ACCESS_KEY = ""; //Enter Sauce labs access key (if needed)
    public static final String SLURL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";

	public static WebDriver getDriver() {
		return driver;
	}
	
	@BeforeClass
	@Parameters("browserName")
	public void setBrowser(String browserName){
		
		if(browserName.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", "Resources/WebDrivers/geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}else if(browserName.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "Resources/WebDrivers/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}else if(browserName.equalsIgnoreCase("IE")){
			System.setProperty("webdriver.edge.driver", "Resources/WebDrivers/MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
			driver.manage().window().maximize();
		}else if(browserName.equalsIgnoreCase("saucelabs")){
			System.setProperty("webdriver.edge.driver", "Resources/WebDrivers/MicrosoftWebDriver.exe");
			try {
				DesiredCapabilities caps = DesiredCapabilities.chrome();
				    caps.setCapability("platform", "Windows XP");
				    caps.setCapability("version", "43.0");
				    driver = new RemoteWebDriver(new URL(SLURL), caps);
				    driver.manage().window().maximize();
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
		}
	
	@AfterClass
	public void tearDown() {
		if (driver != null);
		driver.manage().deleteAllCookies();
		driver.quit();
	}

}
