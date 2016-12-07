package pages;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.WebDriverFactory;

public class HotelSearchPage extends BaseClass{
	private static HotelSearchPage hotels = new HotelSearchPage();
	
	private static WebElement hotelSearchPageElements(String key){
		HashMap<String, WebElement> elementLocations = new HashMap<String, WebElement>();
		elementLocations.put("searchDestinationTextBox", hotels.findElmt(By.cssSelector("#qf-0q-destination")));
		
		WebElement element = elementLocations.get(key);
		return element;
	}
	
	public static void searchDestination(String key, String inputData){
		hotelSearchPageElements(key);
		hotels.enterData(inputData);
	}
}
