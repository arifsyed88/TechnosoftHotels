package pages;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utils.Calender;
import utils.WebDriverFactory;

public class SearchResultsHotels extends BaseClass{

	private static SearchResultsHotels srchRslts = new SearchResultsHotels();
	
	private WebElement searchResultsElements(String key){
		HashMap<String, By> elementLocations = new HashMap<String, By>();
		elementLocations.put("enterDates", By.xpath("//li[1]//a/span"));
		elementLocations.put("checkIn", By.cssSelector("#overlay-q-localised-check-in"));
		elementLocations.put("checkOut", By.cssSelector("#overlay-q-localised-check-out"));
		elementLocations.put("numOfNights", By.xpath(".//*[@id='overlay-q-nights']//span[contains(@class,'num-nights')]"));
		elementLocations.put("calendarContinue",By.cssSelector(".cta.widget-overlay-ok"));
		return findElmt(elementLocations.get(key));
	}
	
	public static void verifyButton(String element, String expectedText){
		srchRslts.verifyMessage(srchRslts.searchResultsElements(element), expectedText);
	}
	
	public static void clickButton(String buttonName){
		srchRslts.actionClick(srchRslts.searchResultsElements(buttonName));
	}
	
	public static void checkIn(){
		Calender.travelDate(true, srchRslts.searchResultsElements("checkIn"));
	}
	
	public static void checkOut(){
		Calender.travelDate(false, srchRslts.searchResultsElements("checkOut"));
	}

}
