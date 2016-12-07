package com.hotelsTest.hotels.comTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import pages.HotelSearchPage;
import utils.Calender;
import utils.DataProviders;
import utils.WebDriverFactory;

public class sample extends WebDriverFactory {
	
	@Test
	public void testMe() throws InterruptedException{
		HotelSearchPage.searchDestination("searchDestinationTextBox", "search me");
		Thread.sleep(8000);
		
		
		
		
	}
}
