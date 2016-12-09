package pages;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import CommonActions.GeneralActions;
import utils.WebDriverFactory;

public class HotelSearchPage extends BaseClass{
	private static HotelSearchPage hotels = new HotelSearchPage();
	
	private WebElement hotelSearchPageElements(String key){
		HashMap<String, WebElement> elementLocations = new HashMap<String, WebElement>();
		elementLocations.put("searchDestinationTextBox", flntWait(By.cssSelector("#qf-0q-destination")));
		
		WebElement element = elementLocations.get(key);
		return element;
	}
	
	private List<WebElement> elementLists(String key){
		HashMap<String, WebElement> elementLists = new HashMap<String, WebElement>();
		elementLists.put("hotelDestination", flntWait(By.cssSelector(".autosuggest-city .autosuggest-category-result")));
		List<WebElement> eList = elementLists(key);
		return eList;
	}
	
	public static void searchDestination(String key, String inputData) throws InterruptedException{
		hotels.hotelSearchPageElements(key).sendKeys(inputData);;
		hotels.autoComplete(By.cssSelector(".autosuggest-city .autosuggest-category-result"), inputData);
	}
	
    
	
	
  
}
