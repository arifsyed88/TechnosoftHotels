package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import utils.Attachments;
import utils.WebDriverFactory;

public class BaseClass {
	
	
	protected WebElement flntWait(By locator){
		return WebDriverFactory.webDriverFluentWait(locator);
	}
	
	protected void clickButton(By locator){
		flntWait(locator).click();
	}
	
	protected void enterData(By locator, String inputData) {
		flntWait(locator).sendKeys(inputData);
	}
	
	protected void verifyMessage(By locator, String expectedText ){
	  String actualText = flntWait(locator).getText();
	  Assert.assertEquals(actualText,expectedText);
  	}
  
	public void autoComplete(By locater, String inputData) throws InterruptedException{
		WebDriverFactory.WaitImplicit(10000);
		List<WebElement> elementList = WebDriverFactory.getDriver().findElements(locater);
		//System.out.println(elementList.size());
		int indexNum = autoCompleteListIndex(elementList, inputData);
		//List<WebElement> elementList2 = WebDriverFactory.getDriver().findElements(locater);
		WebDriverFactory.WaitImplicit(10000);
		elementList.get(indexNum).click();
	}
	
	private int autoCompleteListIndex(List<WebElement> list, String input){
      
      for(WebElement element : list){
          if(element.getText().contains(input)){
              return list.indexOf(element);
          }
      }
      return 0;
  }
}
