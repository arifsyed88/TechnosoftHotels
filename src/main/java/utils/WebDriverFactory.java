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
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class WebDriverFactory {
	
	private static WebDriver driver = null;
	private static final String URL = "https://www.hotels.com/";
	public static final String USERNAME = "technosoft";
	public static final String ACCESS_KEY = "269969d4-632a-4e8f-a1e4-c924430aa4fe";
    public static final String SLURL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";
    private final static String CHECK_OS = System.getProperty("os.name");
    private static String CURRENT_OS = null;

	public static WebDriver getDriver() {
		return driver;
	}
	
   
    private String getOperatingSystem(){
    	if((CHECK_OS.toLowerCase().indexOf("win") >= 0)){
    		return CURRENT_OS = "windows";
    	}else if(CHECK_OS.toLowerCase().indexOf("mac") >= 0){
    		return CURRENT_OS = "mac";
    	}else{
    		return "OS IS NOT SUPPORTED";
    	}
    }
    
    private void chooseBrowser(String browserName){
    	getOperatingSystem();
    	switch(browserName){
    		case "firefox":
    			if(CURRENT_OS.equalsIgnoreCase("mac")){
    				System.setProperty("webdriver.gecko.driver", "Resources/WebDrivers/geckodriver");
					driver = new FirefoxDriver();
    			}else if(CURRENT_OS.equalsIgnoreCase("windows")){
    				System.setProperty("webdriver.gecko.driver", "Resources/WebDrivers/geckodriver.exe");
    				driver = new FirefoxDriver();
    			}break;
    		case "chrome":
    			if(CURRENT_OS.equalsIgnoreCase("mac")){
    				System.setProperty("webdriver.chrome.driver", "Resources/WebDrivers/chromedriver");
					driver = new ChromeDriver();
    			}else if(CURRENT_OS.equalsIgnoreCase("windows")){
    				System.setProperty("webdriver.chrome.driver", "Resources/WebDrivers/chromedriver.exe");
    				driver = new ChromeDriver();
    			}break;
    		case "IE":
    				System.setProperty("webdriver.edge.driver", "Resources/WebDrivers/MicrosoftWebDriver.exe");
    				driver = new EdgeDriver();
    				break;
    		case "saucelabs":
    			try {
					DesiredCapabilities caps = DesiredCapabilities.chrome();
					    caps.setCapability("platform", "Windows XP");
					    caps.setCapability("version", "43.0");
					    driver = new RemoteWebDriver(new URL(SLURL), caps);
				} catch (MalformedURLException e) {
					e.printStackTrace();
					}
    			break;
    			}
    	}	

	@BeforeTest
	@Parameters("browserName")
	public void setBrowser(String browserName){
		chooseBrowser(browserName);
		driver.manage().window().maximize();
		driver.navigate().to(URL);
		}
	
	@AfterTest
	public void tearDown() {
		if (driver != null);
		driver.manage().deleteAllCookies();
		driver.quit();
	}

}
