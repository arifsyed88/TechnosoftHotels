package pages;

import java.util.HashMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends BaseClass{
	private static HomePage hotels = new HomePage();
	
	private WebElement hotelSearchPageElements(String key){
		HashMap<String, By> elementLocations = new HashMap<String, By>();
		elementLocations.put("searchDestinationTextBox", By.cssSelector("#qf-0q-destination"));
		elementLocations.put("search", By.cssSelector("[type='submit']"));
		return findElmt(elementLocations.get(key));
	}

	
	public static void searchDestination(String inputData){
		hotels.hotelSearchPageElements("searchDestinationTextBox").sendKeys(inputData);;
		hotels.autoComplete(By.cssSelector(".autosuggest-city .autosuggest-category-result"), inputData);
	}
	
	public static void clickButton(String buttonName){
		hotels.hotelSearchPageElements(buttonName).click();
	}
    
	
	
  
}
