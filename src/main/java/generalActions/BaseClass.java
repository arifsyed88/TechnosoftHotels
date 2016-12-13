package generalActions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import utils.WebDriverFactory;

public class BaseClass {
	Actions actions = new Actions(WebDriverFactory.getDriver());
	
	protected WebElement findElmt(By locator){
		return WebDriverFactory.getDriver().findElement(locator);
	}
	
	protected void click(WebElement element){
		element.click();
	}
	
	protected void actionClick(WebElement element){
		actions.moveToElement(element).click().build().perform();
	}
	
	protected void enterData(WebElement element, String inputData) {
		element.sendKeys(inputData);
	}
	
	protected void verifyMessage(WebElement element, String expectedText ){
	  String actualText = element.getText();
	  Assert.assertEquals(actualText,expectedText);
  	}
  
	protected void switchToWidnow(int index) {
		List<String> listOfWindows = new ArrayList<String>(WebDriverFactory.getDriver().getWindowHandles());
		WebDriverFactory.getDriver().switchTo().window(listOfWindows.get(index));
	}
	
	protected WebElement listSelectByIndex(By locater, int index){
		List<WebElement> elmtList = WebDriverFactory.getDriver().findElements(locater);
		return elmtList.get(index);
	}
	
}
