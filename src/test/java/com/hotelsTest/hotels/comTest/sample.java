package com.hotelsTest.hotels.comTest;

import java.awt.print.Book;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.BookingPage;
import pages.HomePage;
import pages.HotelDeals;
import pages.SearchResultsHotels;
import utils.Calender;
import utils.WebDriverFactory;


public class sample extends WebDriverFactory {
	
	
	@Test(testName = "TS01")
		public void TS01() {
		HotelDeals.searchDestination("New York","New York");
		HotelDeals.clickButton("search");
		SearchResultsHotels.verifyButton("enterDates", "Enter Dates");
		SearchResultsHotels.clickButton("enterDates");
		SearchResultsHotels.checkIn();
		SearchResultsHotels.checkOut();
		SearchResultsHotels.verifyButton("numOfNights", "1");
	}
	
	@Test(testName = "TS02")
		public void TS02(){
		HotelDeals.searchDestination("New York","New York");	
		HotelDeals.checkInTom();;
		HotelDeals.checkOutDayAfterTom();
		HotelDeals.clickButton("search");
		SearchResultsHotels.AssertNumOfReviews(1);
	}
	
	@Test(testName = "TS03")
		public void TS03(){
		HotelDeals.searchSpecificHotel("New York", "Hilton");
		HotelDeals.checkInTom();
		HotelDeals.checkOutDayAfterTom();
		HotelDeals.clickButton("search");
		BookingPage.getPriceofHotel();
		BookingPage.clickButton("priceWatch");
		BookingPage.verifyAndMatchPrice();
		BookingPage.enterEmail("Techsoft@gmail.com");
		BookingPage.clickButton("subscribe");
		BookingPage.ConfirmMessage("We’ll watch the rate on these dates:");
	}
		
	@Test(testName = "TS04")
		public void TS04(){
		HotelDeals.searchSpecificHotel("New York", "Marriot");
		HotelDeals.checkInTom();
		HotelDeals.verifyAutoUpdateOfDate();
		HotelDeals.clickButton("search");
		BookingPage.verifyOtherSitesAreDisplayed();
		}
		
	 @Test(testName = "TS05")
	 	public void TS05(){
		 HotelDeals.searchDestination("New York", "New York");
		 HotelDeals.checkInTom();
		 HotelDeals.checkOutDayAfterTom();
		 HotelDeals.selectAmtOfRooms(1);
		 HotelDeals.assignMembersToRooms(1, 3, 1);
		 HotelDeals.clickButton("search");
		 SearchResultsHotels.verifyButton("header", "New York, New York, USA");
	 }
	 	
	 @Test(testName = "TS06")
	 	public void TS06(){
	 	 HotelDeals.searchDestination("California", "Los Angeles");
	 	 HotelDeals.clickButton("search");
	 	 SearchResultsHotels.chooseStarRating(1);
	 	 SearchResultsHotels.chooseNeighborhood("Los Angeles");
	 	 SearchResultsHotels.verifyFilters("starRating", "1");
	 	 SearchResultsHotels.verifyButton("nieghborhood", "Downtown Los Angeles");
	 	 SearchResultsHotels.verifyButton("noHotelsMessage", "Sorry, there are no hotels that match your search");
	 	}
}
