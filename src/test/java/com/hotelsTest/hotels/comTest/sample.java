package com.hotelsTest.hotels.comTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import utils.Calender;
import utils.DataProviders;
import utils.WebDriverFactory;

public class sample{
//extends WebDriverFactory {
	
	@Test(dataProvider = "test", dataProviderClass = utils.DataProviders.class)
	public void testMe(String a, String b) throws InterruptedException{
		System.out.println(a + b);
		
		
		
		
	}
}
