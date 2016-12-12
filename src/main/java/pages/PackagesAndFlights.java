package pages;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.WebDriverFactory;

public class PackagesAndFlights extends BaseClass {
	
	private WebElement PackageAndFlightsElements(String key){
		HashMap<String, By> elementLocation= new HashMap<String, By>(); 
		elementLocation.put("Flight", By.cssSelector("#tab-flight-tab"));
		elementLocation.put("FlightAndHotel", By.cssSelector("#tab-flightHotel-tab"));
		elementLocation.put("ThingsToDo", By.cssSelector("#tab-activity-tab"));
		elementLocation.put("RoundTrip", By.cssSelector("#flight-type-roundtrip-label"));
		elementLocation.put("MultipleDestination", By.cssSelector("#flight-type-multi-dest-label"));
		elementLocation.put("FlyFrom", By.cssSelector("#flight-origin"));
		elementLocation.put("FlyFrom2", By.cssSelector("#flight-2-origin"));
		elementLocation.put("FlyTo", By.cssSelector("#flight-destination"));
		elementLocation.put("FlyTo2", By.cssSelector("#flight-2-destination"));
		elementLocation.put("Departing", By.cssSelector("#flight-departing"));
		elementLocation.put("Departing2", By.cssSelector("#flight-2-departing"));
		elementLocation.put("Returning", By.cssSelector("#flight-returning"));
		elementLocation.put("Adults", By.cssSelector("#flight-adults"));
		elementLocation.put("Children", By.cssSelector("#flight-children"));
		elementLocation.put("AddHotel", By.cssSelector("#flight-add-hotel-checkbox"));
		elementLocation.put("Search", By.cssSelector("#search-button"));
		elementLocation.put("PageHeader", By.cssSelector("#span.title-city-text"));
		
	
		
		return findElmt(elementLocation.get(key));
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

	
	public static void autocompleteFlights(){
		WebDriverFactory.getDriver().navigate().to("https://travel.hotels.com/Packages-Flights?intlid=HOME+%253A%253A+header_main_section&");
		//.main-suggestion
		WebDriverFactory.getDriver().findElement(By.cssSelector("#package-origin")).sendKeys("new york");
		WebDriverFactory.WaitImplicit(5000);
		List<WebElement> list = WebDriverFactory.getDriver().findElements(By.cssSelector(".main-suggestion"));
		System.out.println(list.size());
		int indexNum = autoCompleteListIndex(list, "new york");
		List<WebElement> elementList2 = WebDriverFactory.getDriver().findElements(By.cssSelector(".main-suggestion"));
		WebDriverFactory.WaitImplicit(5000);
		elementList2.get(indexNum).click();
	}
	
public static int autoCompleteListIndex(List<WebElement> list, String input){
        
        for(WebElement element : list){
            if(element.getText().equals(input)){
                return list.indexOf(element);
            }
        }
        return 0;
    }
	
}
