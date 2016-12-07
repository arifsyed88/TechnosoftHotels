package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import utils.Attachments;
import utils.WebDriverFactory;

public class BaseClass {
	private WebElement element;
	
	protected WebElement findElmt(By locator){
		try {
			element = WebDriverFactory.webDriverFluentWait(locator);
			return element;
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			throw new NoSuchElementException("Element is not present");
		}
	}
	
	protected void clickButton(){
		element.click();
	}
	
	protected void enterData(String inputData) {
		element.sendKeys(inputData);
	}
	
  protected void verifyMessage(String expectedText ){
	  String actualText = element.getText();
	  Assert.assertEquals(actualText,expectedText);
  	}
}
