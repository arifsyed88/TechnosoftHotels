package pages;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import utils.Calender;
import utils.WebDriverFactory;

public class HotelDeals extends BaseClass{
	private static HotelDeals deals = new HotelDeals();
	
	private WebElement hDealsElements(String key){
		HashMap<String, By> elementLocations = new HashMap<String, By>();
		elementLocations.put("searchDestinationTextBox", By.cssSelector("#qf-1q-destination"));
		elementLocations.put("search", By.cssSelector("[type='submit']"));
		elementLocations.put("checkIn", By.cssSelector("#qf-1q-localised-check-in"));
		elementLocations.put("checkOut", By.cssSelector("#qf-1q-localised-check-out"));
		return findElmt(elementLocations.get(key));
	}
	
	private By elmtListLocations(String key){
		HashMap<String, By> elmntList = new HashMap<String, By>();
		elmntList.put("searchPageReviews", By.cssSelector(".full-view"));
		elmntList.put("searchCities", By.cssSelector(".autosuggest-city .autosuggest-category-result"));
		elmntList.put("searchHotels", By.cssSelector(".autosuggest-hotel .autosuggest-category-result"));
		return elmntList.get(key);
	}
	
	public static void searchDestination(String city){
		deals.enterData(deals.hDealsElements("searchDestinationTextBox"), city);
		deals.autoComplete(deals.elmtListLocations("searchCities"), city);
	}
	
	public static void searchSpecificHotel(String city, String hotel){
		deals.enterData(deals.hDealsElements("searchDestinationTextBox"), city);
		deals.autoComplete(deals.elmtListLocations("searchHotels"), hotel);
	}
	
	public static void checkInTom(){
		Calender.travelDate(true, deals.hDealsElements("checkIn"));
	}
	
	public static void checkOutDayAfterTom(){
		Calender.travelDate(true, deals.hDealsElements("checkOut"));
	}
	
	public static void checkoutGuestReviewsofSelection(int index){
		deals.listSelectByIndex(deals.elmtListLocations("searchPageReviews"), index).click();
	}
	
	public static void AssertNumOfReviews(int index){
		int reviewsSrchPg, reviewHtlPg;
		
		String searchPageReviews = deals.listSelectByIndex(deals.elmtListLocations("searchPageReviews"), index).getText();
		String[] split1 = searchPageReviews.split(" ");
		
		if(split1[0].length()>3){
			String[] split2 = split1[0].split(",");
			reviewsSrchPg = Integer.parseInt(split2[0]+split2[1]);
		}else{
			 reviewsSrchPg = Integer.parseInt(split1[0]);
		}
		
		checkoutGuestReviewsofSelection(index);
		deals.switchToWidnow(1);
		WebDriverFactory.WaitImplicit(5000);
		
		String allReviewsforHotel = deals.findElmt(By.cssSelector(".cat>span")).getText();
		reviewHtlPg = Integer.parseInt(allReviewsforHotel.replace("(", "").replace(")", ""));
		
		Assert.assertEquals(reviewsSrchPg, reviewHtlPg);
	}
	
	public static void clickButton(String buttonName){
		deals.hDealsElements(buttonName).click();
	}
}
