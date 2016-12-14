package com.hotelsTest.hotels.comTest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.PackagesAndFlights;
import pages.SearchResultsHotels;
import utils.WebDriverFactory;

public class PackageAndFlightTest extends WebDriverFactory {
	
	@Parameters("browserName")
	@BeforeMethod
		public void NavigateToHotelDeals(String browserName){
		HomePage.goToPage("PackagesAndFlights", browserName);
	}
		
		@Test(testName = "TA110")
		public void TA110() throws InterruptedException {
			
			PackagesAndFlights.clickButton("Flight");
			PackagesAndFlights.clickButton("RoundTrip");
			PackagesAndFlights.flightFrom("JFK");
			PackagesAndFlights.flightTo("LAX");
			PackagesAndFlights.checkInTom();
			PackagesAndFlights.checkOutDayAfterTom();
			Thread.sleep(1000);
			PackagesAndFlights.noOfAdults(1);
			PackagesAndFlights.noOfChildren(1);
			PackagesAndFlights.verifyCheckBox("AddHotel");
			PackagesAndFlights.clickButton("Search");
			Thread.sleep(4000);
			PackagesAndFlights.verifyHeadLine("Select you  r departure to Los Angeles");
	}

}
