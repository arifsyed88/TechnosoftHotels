package utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Calender {

	@Test
	public static void dateSetter() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\aurph\\Desktop\\Workspace\\selenium-java-3.0.0-beta4\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.hotel.com");
		Thread.sleep(1000);

		Calendar c = Calendar.getInstance();
		Calendar d = Calendar.getInstance();
		c.add(Calendar.DATE, 1);
		d.add(Calendar.DATE, 2);
		
		String tomorrow = new SimpleDateFormat("MM/dd/yy").format(c.getTime());
		String day_after_tomorrow = new SimpleDateFormat("MM/dd/yy").format(d.getTime());
		
		driver.findElement(By.xpath(".//*[@id='widget-query-label-1']")).click();
		driver.findElement(By.xpath(".//*[@aria-label='" + tomorrow + "']")).click();
		driver.findElement(By.xpath(".//*[@id='widget-query-label-3']")).click();
		driver.findElement(By.xpath(".//*[@aria-label='" + day_after_tomorrow + "']")).click();

	}

}
