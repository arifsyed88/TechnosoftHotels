package utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class TestListener extends TestListenerAdapter{

	public void onTestFailure(ITestResult result) {
		Attachments.createAttachment();
		System.out.println("Test Failed: "+ result.getName());
		System.out.println(result.getThrowable());
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Skipped : "+result.getName());
		
	}

}
