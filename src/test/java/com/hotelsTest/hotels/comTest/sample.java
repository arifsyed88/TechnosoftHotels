package com.hotelsTest.hotels.comTest;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.SearchResultsHotels;
import utils.Calender;
import utils.WebDriverFactory;


public class sample extends WebDriverFactory {
	
	@Test(testName = "TS01")
	public void TS01() {
		HomePage.searchDestination("New York");
		HomePage.clickButton("search");
		SearchResultsHotels.verifyButton("enterDates", "Enter Dates");
		SearchResultsHotels.clickButton("enterDates");
		SearchResultsHotels.checkIn();
		SearchResultsHotels.checkOut();
		SearchResultsHotels.verifyButton("numOfNights", "1");
	}
}
