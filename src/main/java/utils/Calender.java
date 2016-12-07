package utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.openqa.selenium.By;

public class Calender extends WebDriverFactory{
	


	
	
	public static void selectTomorrow(){
		String tomorrow = addDaysToCurrentDate(1);
		getDriver().findElement(By.cssSelector("#qf-0q-localised-check-in")).click();//locater needed here
		getDriver().findElement(By.cssSelector("a[aria-label='"+ tomorrow+ "']")).click();//static
	}
	
	public static void selectDayAfterTomorrow(){
		String dayAfterTomorrow = addDaysToCurrentDate(2);
		getDriver().findElement(By.cssSelector("#qf-0q-localised-check-out")).click();// locater needed here
		getDriver().findElement(By.cssSelector("a[aria-label='"+ dayAfterTomorrow+ "']")).click();
	}
	
	public static String addDaysToCurrentDate(int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, days); 
        
        SimpleDateFormat timeFormat = new SimpleDateFormat("MM/dd/yy");
        String currentTime = timeFormat.format(calendar.getTime());
        return currentTime;
	}
	
	
}
