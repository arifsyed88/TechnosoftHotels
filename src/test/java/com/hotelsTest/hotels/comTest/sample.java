package com.hotelsTest.hotels.comTest;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.HotelDeals;
import pages.SearchResultsHotels;
import utils.Calender;
import utils.WebDriverFactory;


public class sample extends WebDriverFactory {

	
	//@Test(testName = "TS01")
	public void TS01() {
		HomePage.searchDestination("New York");
		HomePage.clickButton("search");
		SearchResultsHotels.verifyButton("enterDates", "Enter Dates");
		SearchResultsHotels.clickButton("enterDates");
		SearchResultsHotels.checkIn();
		SearchResultsHotels.checkOut();
		SearchResultsHotels.verifyButton("numOfNights", "1");
	}
	
	@Test(testName = "TS02")
		public void TS02(){
//		HomePage.clickButton("hotelDeals");
//		HotelDeals.searchDestination("New York");	
//		HotelDeals.checkIn();
//		HotelDeals.checkOut();
//		HotelDeals.clickButton("search");
		getDriver().navigate().to("https://www.hotels.com/search.do?resolved-location=CITY%3A1506246%3AUNKNOWN%3AUNKNOWN&destination-id=1506246&q-destination=New%20York,%20New%20York,%20United%20States%20of%20America&q-check-in=2016-12-12&q-check-out=2016-12-13&q-rooms=1&q-room-0-adults=2&q-room-0-children=0");
		HotelDeals.verifyReviewsRemainConstant("1");

		
	}
}
