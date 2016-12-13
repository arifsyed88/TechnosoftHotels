package generalActions;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utils.Calender;
import utils.WebDriverFactory;

public class CommonActions extends BaseClass{

	private static int roomAmt;
	private static CommonActions common = new CommonActions();
	
	protected static void autoComplete(By locater, String inputData){
		WebDriverFactory.WaitImplicit(5000);
		List<WebElement> elementList = WebDriverFactory.getDriver().findElements(locater);
		int indexNum = autoCompleteListIndex(elementList, inputData);
		WebDriverFactory.WaitImplicit(5000);
		elementList.get(indexNum).click();
	}
	
	private static int autoCompleteListIndex(List<WebElement> list, String input){
      for(WebElement element : list){
          if(element.getText().contains(input)){
              return list.indexOf(element);
          }
      }
      return 0;
  }
	
	protected static void checkInTom(WebElement element){
		Calender.travelDate(true, element);
	}
	
	protected static void checkOutDayAfterTom(WebElement element){
		Calender.travelDate(true, element);
	}
	
	protected static void selectAmtOfRooms(int numOfRooms, WebElement element){
		Select rooms = new Select(element);
		if(numOfRooms>0 && numOfRooms<9){
			rooms.selectByValue(String.valueOf(numOfRooms));
		}else if(numOfRooms>9){
			rooms.selectByValue("9+");
		}else if(numOfRooms==0 || numOfRooms<0){
			rooms.selectByValue("1");
		}
	}
	
	private static void selectAmtOfKids(int index, int roomNum ,String page){
		Random rdm = new Random();
		Select childAge;
		Select child;
		if(page.equalsIgnoreCase("packagesAndFlights")){
			child = new Select(common.findElmt(By.cssSelector("#flight-children")));
		}else if(page.equalsIgnoreCase("hotelDeals")){
			child = new Select(common.findElmt(By.cssSelector("#qf-1q-room-"+roomNum+"-children")));
		}else{
			child = new Select(common.findElmt(By.cssSelector("#qf-0q-room-"+roomNum+"-children")));
		}
		child.selectByIndex(index);
		if(index>0){
		for(int i=0; i<index; i++){
			if(page.equalsIgnoreCase("packagesAndFlights")){
				childAge = new Select(common.findElmt(By.cssSelector("#flight-age-select-"+i)));
			}else if(page.equalsIgnoreCase("hotelDeals")){
				childAge = new Select(common.findElmt(By.cssSelector("#qf-1q-room-"+roomNum+"-child-"+ i+ "-age")));
			}else{
				childAge = new Select(common.findElmt(By.cssSelector("#qf-0q-room-"+roomNum+"-child-"+ i+ "-age")));
			}
			int random = rdm.nextInt((19-1)+1)+1;
			childAge.selectByIndex(random);
			}
		}
	}
	
	private static void selectAmtOfAdults(int numOfAdults,int roomNum, String page){
			Select adult;
			if(page.equalsIgnoreCase("packagesAndFlights")){
				adult = new Select(common.findElmt(By.cssSelector("#flight-adults")));
			}else if(page.equalsIgnoreCase("hotelDeals")){
				adult = new Select(common.findElmt(By.cssSelector("#qf-1q-room-"+roomNum+"-adults")));
			}else{
				adult = new Select(common.findElmt(By.cssSelector("#qf-0q-room-"+roomNum+"-adults")));
			}
			adult.selectByValue(String.valueOf(numOfAdults));
	}
	
	protected static void assignMembersToRooms(int roomNum, int adultNum, int kidNum, String page){
		selectAmtOfKids(kidNum, roomNum, page);
		selectAmtOfAdults(adultNum, roomNum, page);
	}
}
