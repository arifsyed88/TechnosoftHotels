package CommonActions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pages.BaseClass;
import utils.WebDriverFactory;

public class GeneralActions extends BaseClass{
	
	public static void autoComplete(List<WebElement> list, String inputData) throws InterruptedException{
		WebDriverFactory.WaitImplicit(5000);
		List<WebElement> elementList = list;
		System.out.println(elementList.size());
		int indexNum = autoCompleteListIndex(elementList, inputData);
		List<WebElement> elementList2 = list;
		WebDriverFactory.WaitImplicit(5000);
		elementList2.get(indexNum).click();
	}
	
	private static int autoCompleteListIndex(List<WebElement> list, String input){
        
        for(WebElement element : list){
            if(element.getText().equals(input)){
                return list.indexOf(element);
            }
        }
        return 0;
    }
    

}
