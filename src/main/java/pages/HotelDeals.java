package pages;

import java.util.HashMap;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import generalActions.BaseClass;
import generalActions.CommonActions;
import utils.Calender;
import utils.WebDriverFactory;

public class HotelDeals extends CommonActions{
	private static HotelDeals deals = new HotelDeals();
	private static int adultAmt,roomAmt,kidAmt;
	
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
		elmntList.put("searchCities", By.cssSelector(".autosuggest-city .autosuggest-category-result"));
		elmntList.put("searchHotels", By.cssSelector(".autosuggest-hotel .autosuggest-category-result"));
		elmntList.put("childSelect", By.cssSelector("#qf-1q-room-0-children"));
		elmntList.put("roomSelect", By.cssSelector("#qf-1q-rooms"));
		return elmntList.get(key);
	}
	
	public static void searchDestination(String city){
		deals.enterData(deals.hDealsElements("searchDestinationTextBox"), city);
		CommonActions.autoComplete(deals.elmtListLocations("searchCities"), city);
	}
	
	public static void searchSpecificHotel(String city, String hotel){
		deals.enterData(deals.hDealsElements("searchDestinationTextBox"), city);
		CommonActions.autoComplete(deals.elmtListLocations("searchHotels"), hotel);
	}
	
	public static void checkInTom(){
		CommonActions.checkInTom(deals.hDealsElements("checkIn"));
	}
	
	public static void checkOutDayAfterTom(){
		CommonActions.checkOutDayAfterTom(deals.hDealsElements("checkOut"));
	}
	
	public static void verifyAutoUpdateOfDate(){
		deals.click(deals.hDealsElements("checkIn"));
		int checkInDate = Integer.parseInt(deals.findElmt(By.cssSelector
							(".widget-datepicker-selected.widget-datepicker-highlight>a")).getText());
		deals.click(deals.hDealsElements("checkOut"));
		int checkOutDate = Integer.parseInt(deals.findElmt(By.cssSelector
							(".widget-datepicker-highlight.widget-datepicker-range-end>a")).getText());
		checkOutDayAfterTom();
		if(checkOutDate-checkInDate!=1){
			Assert.fail();
		}
	}
	
	public static void selectAmtOfRooms(int numOfRooms){
		CommonActions.selectAmtOfRooms(numOfRooms, deals.findElmt(deals.elmtListLocations("roomSelect")));
	}
	
	public static void selectAmtOfKids(int index){
		Random rdm = new Random();
		for(int i=0; i<index; i++){
			Select childAge = new Select(deals.findElmt(By.cssSelector("#qf-1q-room-0-child-"+ i+ "-age")));
			int random = rdm.nextInt((19-1)+1)+1;
			childAge.selectByIndex(random);
		}
		
	}
	
	public static void selectAmtOfAdults(int numOfAdults){
		if(roomAmt>0 && roomAmt<9){
			for(int i=1; i<roomAmt; i++){
				
			Select adults = new Select(deals.findElmt(By.cssSelector("#qf-1q-room-" +i + "-adults")));
			
			}
		}
	}
	
	public static void clickButton(String buttonName){
		deals.hDealsElements(buttonName).click();
	}
}
