package CommonActions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;

import utils.WebDriverFactory;

public class BaseClass {
	public void clickButton(By locator){
		try {
			WebDriverFactory.getDriver().findElement(locator).click();
					
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			//Take Screenshot
			e.printStackTrace();
			throw new NoSuchElementException("Element is not present");
	}
	}
	public void enterData(By locator, String inputData) {
		try {
			WebDriverFactory.getDriver().findElement(locator).sendKeys(inputData);
					
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			//Take Screenshot
			e.printStackTrace();
			throw new NoSuchElementException("Element is not present");
			
		}	
		}
  public void verifyMessage(By locator, String expectedText ){
	  String actualText = WebDriverFactory.getDriver().findElement(locator).getText();
	  Assert.assertEquals(actualText,expectedText,"Warning: Error message is wrong");
	  
  }

}
