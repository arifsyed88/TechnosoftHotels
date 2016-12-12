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
	
	public static void searchDestination(String city){
		deals.enterData(deals.hDealsElements("searchDestinationTextBox"), city);
		deals.autoComplete(By.cssSelector(".autosuggest-city .autosuggest-category-result"), city);
	}
	
	public static void checkIn(){
		Calender.travelDate(true, deals.hDealsElements("checkIn"));
	}
	
	public static void checkOut(){
		Calender.travelDate(true, deals.hDealsElements("checkOut"));
	}
	
	public static void verifyTotalReviewsofSelection(String index, String expectedText){
		deals.verifyMessage(deals.findElmt(By.xpath("//li[" + index + "]//span[@class='ta-total-reviews']")), expectedText);
	}
	
	public static void checkoutGuestReviewsofSelection(String index){
		deals.actionClick(deals.findElmt(By.xpath("//li[" + index + "]//a[@class='full-view']")));
	}
	
	public static void verifyReviewsRemainConstant(String index){
		String searchPageReviews = deals.findElmt(By.xpath("//li[" + index + "]//a[@class='full-view']")).getText();
		String[] split1 = searchPageReviews.split(" ");
		String[] split2 = split1[0].split(",");
		int reviewSrchPg = Integer.parseInt(split2[0]+split2[1]);
		deals.findElmt(By.xpath("//li[" + index + "]//a[@class='full-view']")).click();
		deals.switchToWidnow(1);
		WebDriverFactory.WaitImplicit(5000);
		String detailedPageReviews = deals.findElmt(By.cssSelector(".cat>span")).getText();
		int reviewHtlPg = Integer.parseInt(detailedPageReviews.replace("(", "").replace(")", ""));
		Assert.assertEquals(reviewSrchPg, reviewHtlPg);
	}
	
	public static void clickButton(String buttonName){
		deals.hDealsElements(buttonName).click();
	}
}
