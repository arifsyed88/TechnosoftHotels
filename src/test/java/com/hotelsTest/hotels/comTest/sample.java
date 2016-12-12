package com.hotelsTest.hotels.comTest;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.HotelDeals;
import pages.SearchResultsHotels;
import utils.Calender;
import utils.WebDriverFactory;


public class sample extends WebDriverFactory {
	
	@Parameters("browserName")
	@BeforeMethod
		public void NavigateToHotelDeals(String browserName){
		HomePage.goToPage("hotelDeals", browserName);
	}
	
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
	
	//@Test(testName = "TS02")
		public void TS02(){
		HotelDeals.searchDestination("New York");	
		HotelDeals.checkInTom();;
		HotelDeals.checkOutDayAfterTom();
		HotelDeals.clickButton("search");
		HotelDeals.AssertNumOfReviews(1);
	}
	
	@Test(testName = "TS03")
		public void TS03(){
		HotelDeals.searchSpecificHotel("New York", "Hilton");
		HotelDeals.checkInTom();
		HotelDeals.checkOutDayAfterTom();
		HotelDeals.clickButton("search");
		
	}
}
