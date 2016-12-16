package pages;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
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
		elementLocations.put("changeSearchCheckIn", By.cssSelector("#q-localised-check-in"));
		elementLocations.put("changeSearchCheckOut", By.cssSelector("#q-localised-check-out"));
		elementLocations.put("numOfNights", By.xpath(".//*[@id='overlay-q-nights']//span[contains(@class,'num-nights')]"));
		elementLocations.put("calendarContinue",By.cssSelector(".cta.widget-overlay-ok"));
		elementLocations.put("header", By.cssSelector(".summary>h1"));
		elementLocations.put("occupants", By.cssSelector(".search-rooms"));
		elementLocations.put("showRecentSearches", By.cssSelector(".recent-search-toggle"));
		elementLocations.put("search", By.cssSelector(".cta.cta-strong"));
		elementLocations.put("starRating", By.cssSelector(".active [name='f-star-rating']"));
		elementLocations.put("neighborhood", By.xpath(".//*[@id='applied-filters']//li[2]/strong"));
		elementLocations.put("noHotelsMessage", By.cssSelector(".info.unavailable-info"));
		elementLocations.put("changeSearch", By.xpath("//button[text()='Change search']"));
		elementLocations.put("destination", By.cssSelector("#q-destination"));
		return findElmt(elementLocations.get(key));
	}
	
	private By elmtListLocations(String key){
		HashMap<String, By> elmntList = new HashMap<String, By>();
		elmntList.put("searchPageReviews", By.cssSelector(".full-view"));
		elmntList.put("searchCities", By.cssSelector(".autosuggest-city .autosuggest-category-result"));
		elmntList.put("searchHotels", By.cssSelector(".autosuggest-hotel .autosuggest-category-result"));
		elmntList.put("starRating", By.cssSelector("[name='f-star-rating'][type='checkbox']"));
		elmntList.put("neighborhood", By.xpath("//*[@id='filter-neighbourhood']//label"));
		elmntList.put("recentSearches", By.cssSelector(".recent-search"));
		elmntList.put("recentSearchOccupants", By.cssSelector(".recent-search>p"));
		elmntList.put("recentSearchData", By.cssSelector(".recent-search a"));
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
	
	public static void chooseStarRating(int rating){
		rating = rating-1;
		srchRslts.listSelectByIndex(srchRslts.elmtListLocations("starRating"), rating);
	}
	
	public static void chooseNeighborhood(String neighborhood){
		List<WebElement> neighborhoods = WebDriverFactory.getDriver().findElements(By.cssSelector("[name='f-nid']"));
		List<WebElement> neighborhoodNames = WebDriverFactory.getDriver().findElements(srchRslts.elmtListLocations("neighborhood"));
		for(WebElement nhoodName :neighborhoodNames){
			if(nhoodName.getText().equalsIgnoreCase(neighborhood)){
				int name = neighborhoodNames.indexOf(nhoodName);
				neighborhoods.get(name).click();
			}
		}
	}
	
	public static void verifyFilters(String chosenFilter, String expected){
		String filter;
		if(chosenFilter.equalsIgnoreCase("starRating")){
			//filter = srchRslts.searchResultsElements("starRating").getAttribute("value");
			srchRslts.hoverOver(srchRslts.findElmt(By.cssSelector(".icon.icon-star")));
			WebDriverFactory.WaitImplicit(6000);
			filter = srchRslts.findElmt(By.xpath(".//*[@class='star-rating widget-tooltip widget-tooltip-tr widget-star-rating-overlay']//descendant::span[2]")).getText();
			
			System.out.println(filter);
		}else if(chosenFilter.equalsIgnoreCase("neiborhood")){
			filter = srchRslts.searchResultsElements("neighborhood").getText();
			System.out.println(filter);
		}
		else{
			filter = srchRslts.searchResultsElements(chosenFilter).getText();
			System.out.println(filter);
		}
		Assert.assertEquals(filter, expected);
	}
	
	public static void searchDestination(String state, String city){
		CommonActions.clearTextField(srchRslts.searchResultsElements("destination"));
		srchRslts.enterData(srchRslts.searchResultsElements("destination"), state);
		CommonActions.autoComplete(srchRslts.elmtListLocations("searchCities"), city);
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
	
	public static void checkIn(boolean changingSearch){
		if(changingSearch=false){
		CommonActions.checkInTom(srchRslts.searchResultsElements("checkIn"));
		}else{
		CommonActions.checkInTom(srchRslts.searchResultsElements("changeSearchCheckIn"));
		}
	}
	
	public static void checkOut(boolean changingSearch){
		if(changingSearch=false){
			CommonActions.checkInTom(srchRslts.searchResultsElements("checkOut"));
			}else{
			CommonActions.checkInTom(srchRslts.searchResultsElements("changeSearchCheckOut"));
		}
	}
	
	public static void clearField(String field){
		CommonActions.clearTextField(srchRslts.searchResultsElements(field));
	}
	
	public static void verifyRecentSearches(int searchesToBeDisplayed){
		List<WebElement> recentSearches = WebDriverFactory.getDriver().findElements(
				srchRslts.elmtListLocations("recentSearches"));
		int searchesDisplayed = recentSearches.size();
		Assert.assertEquals(searchesDisplayed, searchesToBeDisplayed);
	}
	
	public static void verifyRecentSearchText(int searchNum, String expectedLocation, String expectedOccupants){
		WebElement recentSearchData =srchRslts.listSelectByIndex(srchRslts.elmtListLocations("recentSearchData"), searchNum);
		WebElement recentSearchOccupants =srchRslts.listSelectByIndex(srchRslts.elmtListLocations("recentSearchOccupants"), searchNum);
		String[] allData =recentSearchOccupants.getText().split(", ");
		String acutalOccupants = allData[0]+", "+allData[1];
		srchRslts.verifyMessage(recentSearchData, expectedLocation);
		Assert.assertEquals(acutalOccupants, expectedOccupants);
	}
	
	public static void selectMinimumPrice(){
		//Select 
	}
}
