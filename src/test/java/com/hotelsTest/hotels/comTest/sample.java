package com.hotelsTest.hotels.comTest;

import org.testng.annotations.Test;

import utils.DataProviders;
import utils.WebDriverFactory;

public class sample {
//extends WebDriverFactory {

	@Test(dataProviderClass = DataProviders.class, dataProvider = "test")
	public void testMe(String a, String b, String c, String d,String  e,String  f,String  g,String  h,String  i ,String  j ,String  k, String l) throws Exception{
		System.out.println(a+b+c+d+e+f+g+h+i+j+k+l);
		
		
	}
}
