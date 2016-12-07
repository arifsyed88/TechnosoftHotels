package com.hotelsTest.hotels.comTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import utils.Calender;
import utils.DataProviders;
import utils.WebDriverFactory;

public class sample{
//extends WebDriverFactory {
	
	@Test
	public void testMe() throws InterruptedException{
		Calender.chooseSpecificDate(11, 28, 17);
		
		
		
		
	}
}
