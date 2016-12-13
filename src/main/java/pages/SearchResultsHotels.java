package pages;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import generalActions.BaseClass;
import generalActions.CommonActions;
import utils.Calender;
import utils.WebDriverFactory;

public class SearchResultsHotels extends CommonActions{

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
	
	private By elmtListLocations(String key){
		HashMap<String, By> elmntList = new HashMap<String, By>();
		elmntList.put("searchPageReviews", By.cssSelector(".full-view"));
		elmntList.put("searchCities", By.cssSelector(".autosuggest-city .autosuggest-category-result"));
		elmntList.put("searchHotels", By.cssSelector(".autosuggest-hotel .autosuggest-category-result"));
		return elmntList.get(key);
	}
	
	public static void AssertNumOfReviews(int index){
		int reviewsSrchPg, reviewHtlPg;
		
		String searchPageReviews = srchRslts.listSelectByIndex(srchRslts.elmtListLocations("searchPageReviews"), index).getText();
		String[] split1 = searchPageReviews.split(" ");
		
		if(split1[0].length()>3){
			String[] split2 = split1[0].split(",");
			reviewsSrchPg = Integer.parseInt(split2[0]+split2[1]);
		}else{
			 reviewsSrchPg = Integer.parseInt(split1[0]);
		}
		
		checkoutGuestReviewsofSelection(index);
		srchRslts.switchToWidnow(1);
		WebDriverFactory.WaitImplicit(5000);
		
		String allReviewsforHotel = srchRslts.findElmt(By.cssSelector(".cat>span")).getText();
		reviewHtlPg = Integer.parseInt(allReviewsforHotel.replace("(", "").replace(")", ""));
		
		Assert.assertEquals(reviewsSrchPg, reviewHtlPg);
	}
	
	public static void checkoutGuestReviewsofSelection(int index){
		srchRslts.listSelectByIndex(srchRslts.elmtListLocations("searchPageReviews"), index).click();
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
