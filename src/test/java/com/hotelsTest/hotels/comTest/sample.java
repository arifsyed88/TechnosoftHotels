package com.hotelsTest.hotels.comTest;

import org.testng.annotations.Test;

import utils.WebDriverFactory;

public class sample extends WebDriverFactory {

	@Test
	public void testMe(){
		System.out.println("Im tested");
		WebDriverFactory.getDriver().quit();
	}
}
