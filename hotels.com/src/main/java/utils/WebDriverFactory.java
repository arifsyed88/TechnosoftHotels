package utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.google.common.base.Function;

public class WebDriverFactory {

	private static WebDriver driver = null;
	protected static final String URL = "https://www.hotels.com/";
	public static final String sauceLabsUserName = ""; // Enter Sauce Labs user
														// name (if required)
	public static final String ACCESS_KEY = ""; // Enter Sauce Labs Access Key
												// (if required)
	public static final String SLURL = "https://" + sauceLabsUserName + ":"
			+ ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";

	public static WebDriver getDriver() {
		return driver;
	}

	public void setDriver(int driverNumber) {
		switch (driverNumber) {
		case 1:
			setSauceLabs();
			break;
		case 2:
			setChromeLocal();
			break;
		case 3:
			setFirefoxLocal();
			break;
		default:
			setChromeLocal();
			break;
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(URL);
	}

	private void setSauceLabs() {
		try {
			DesiredCapabilities caps = DesiredCapabilities.chrome();
			caps.setCapability("platform", "Windows XP");
			caps.setCapability("version", "43.0");
			driver = new RemoteWebDriver(new URL(SLURL), caps);

			driver.get(URL);

		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	private void setChromeLocal() {
		System.setProperty("webdriver.chrome.driver",
				"/Users/arifsyed/Documents/JarLib/chromedriver");
		driver = new ChromeDriver();
	}

	private void setFirefoxLocal() {
		System.setProperty("webdriver.gecko.driver",
				"/Users/arifsyed/Documents/JarLib/geckodriver");
		driver = new FirefoxDriver();
	}

	@BeforeClass
	public void initializeWebDriver() {
		setDriver(2);
	}

	@AfterClass
	public void tearDown() {
		if (driver != null)
			;
		driver.manage().deleteAllCookies();
		driver.quit();
	}

}
