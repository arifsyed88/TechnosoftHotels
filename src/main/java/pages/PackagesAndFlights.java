package pages;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import utils.Calender;
import utils.WebDriverFactory;

public class PackagesAndFlights extends BaseClass {
	private static PackagesAndFlights pnf = new PackagesAndFlights();
	
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
		elementLocation.put("PageHeader", By.xpath(".//*[@class='title-city-text'][contains(text(),'Select your departure to')]"));
			
		return findElmt(elementLocation.get(key));
	}
	
	private By elmtListLocations(String key){
		HashMap<String, By> elmntList = new HashMap<String, By>();
		elmntList.put("searchPageReviews", By.cssSelector(".full-view"));
		elmntList.put("searchFlights", By.cssSelector(".results>div>li>a"));
		elmntList.put("searchHotels", By.cssSelector(".autosuggest-hotel .autosuggest-category-result"));
		return elmntList.get(key);
	}
	
	public static void flightFrom(String city){
		pnf.enterData(pnf.PackageAndFlightsElements("FlyFrom"), city);
		pnf.autoComplete(pnf.elmtListLocations("searchFlights"), city);
	}
	
	public static void flightTo(String city){
		pnf.enterData(pnf.PackageAndFlightsElements("FlyTo"), city);
		pnf.autoComplete(pnf.elmtListLocations("searchFlights"), city);
	}
	
	public static void checkInTom(){
		Calender.chooseDatePackagesAndFlights(true, pnf.PackageAndFlightsElements("Departing"));
	}
	
	public static void checkOutDayAfterTom(){
		Calender.chooseDatePackagesAndFlights(false, pnf.PackageAndFlightsElements("Returning"));
	}
	public static void noOfAdults(int input){
		pnf.dropDownFindAndSelect(pnf.PackageAndFlightsElements("Adults"), input);
	}
	public static void noOfChildren(int input){
		pnf.dropDownFindAndSelect(pnf.PackageAndFlightsElements("Children"), input);
	}
	
	public static void verifyCheckBox(String locator){
		pnf.radioButtonCheckAndSelect(pnf.elmtListLocations(locator));
	}
	
	
	public static void verifyHeadLine(String expectedText){
		pnf.verifyMessage(pnf.PackageAndFlightsElements("PageHeader"), expectedText);
	}
	
	
	public static void clickButton(String buttonName){
		pnf.PackageAndFlightsElements(buttonName).click();
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
