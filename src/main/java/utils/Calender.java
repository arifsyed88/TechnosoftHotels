package utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.openqa.selenium.By;

public class Calender extends WebDriverFactory{
	private static Calendar calendar = Calendar.getInstance();
	private static SimpleDateFormat timeFormat = new SimpleDateFormat("MM/dd/yy");
	
	public static void travelDate(boolean Tomorrow, By locater){
		if(Tomorrow=true){
			String tomorrow = addDaysToCurrentDate(1);
			getDriver().findElement(locater).click();
			getDriver().findElement(By.cssSelector("a[aria-label='"+ tomorrow+ "']")).click();//static
			
		}else{
			String dayAfterTomorrow = addDaysToCurrentDate(2);
			getDriver().findElement(locater).click();// locater needed here
			getDriver().findElement(By.cssSelector("a[aria-label='"+ dayAfterTomorrow+ "']")).click();
		}
	}
	
	private static String addDaysToCurrentDate(int days) {
        calendar.add(Calendar.DATE, days); 
        String currentTime = timeFormat.format(calendar.getTime());
        return currentTime;
	}
	
	public static void chooseSpecificDate(int month, int day, int year){
		month = month -1;
		calendar.set(year, month, day);
		String chosenDate = timeFormat.format(calendar.getTime());
	}
	
	
}
