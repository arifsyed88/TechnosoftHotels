package pages;

import java.util.HashMap;

import org.openqa.selenium.By;

import utils.WebDriverFactory;

public class PackagesAndFlights extends BaseClass {
	
	private By elementLocations(String key){
		HashMap<String, By> location= new HashMap<String, By>(); 
		location.put("Flight", By.id("tab-flight-tab"));
		location.put("FlightAndHotel", By.id("tab-flightHotel-tab"));
		location.put("ThingsToDo", By.id("tab-activity-tab"));
		location.put("RoundTrip", By.id("flight-type-roundtrip-label"));
		location.put("MultipleDestination", By.id("flight-type-multi-dest-label"));
		location.put("FlyFrom", By.id("flight-origin"));
		location.put("FlyFrom2", By.id("flight-2-origin"));
		location.put("FlyTo", By.id("flight-destination"));
		location.put("FlyTo2", By.id("flight-2-destination"));
		location.put("Departing", By.id("flight-departing"));
		location.put("Departing2", By.id("flight-2-departing"));
		location.put("Returning", By.id("flight-returning"));
		location.put("Adults", By.id("flight-adults"));
		location.put("Children", By.id("flight-children"));
		location.put("AddHotel", By.id("flight-add-hotel-checkbox"));
		location.put("Search", By.id("search-button"));
		location.put("PageHeader", By.cssSelector("span.title-city-text"));
		
	
		
		return location.get(key);
	}
	
	private String UserInfo(String key){
			HashMap<String, String> info= new HashMap<String, String>();
//			clickButton(elementLocations("Flight"));
//			clickButton(elementLocations("FlightAndHotel"));
//			clickButton(elementLocations("ThingsToDo"));
//			clickButton(elementLocations("RoundTrip"));
//			clickButton(elementLocations("MultipleDestination"));
//			clickButton(elementLocations("FlyFrom"));
//			clickButton(elementLocations("FlyFrom2"));
//			clickButton(elementLocations("Departing"));
//			clickButton(elementLocations("Departing2"));
//			clickButton(elementLocations("Returning"));
//			clickButton(elementLocations("Adults"));
//			clickButton(elementLocations("Children"));
//			clickButton(elementLocations("AddHotel"));
//			clickButton(elementLocations("Search"));
//			clickButton(elementLocations("PageHeader"));
		
		
		return info.get(key);
		
	}

	
}
