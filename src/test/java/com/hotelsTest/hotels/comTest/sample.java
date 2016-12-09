package com.hotelsTest.hotels.comTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import pages.HotelSearchPage;
import pages.PackagesAndFlights;
import utils.Calender;
import utils.DataProviders;
import utils.RetryAnalyzer;
import utils.WebDriverFactory;


public class sample extends WebDriverFactory {
	
	@Test(dataProviderClass = DataProviders.class, dataProvider = "test")
	public void testMe(String a, String b) throws InterruptedException{
		System.out.println(a + b );
	}
}
