package com.hotelsTest.hotels.comTest;
import org.openqa.selenium.By;
/*
 * 

1. Click on "Create an Account" button from drop down.

2. Enter following test data into required field

    Enter"techsoft.tester@gmail.com" in E mail address field.
    Enter "Test*1234" in password and confirm password field.
    Enter "Technosoft" in First name and "Tester" in Last name field.

(delete-->3. Uncheck the checkbox of "E mail me exclusive coupons" condition.

4. Check the checkbox of "Terms and privacy" condition. <--delete)

5. Click on "Create your account" button.

6. Verify popped up error message.

7. Click on "Click here" link of the error message.

8. Verify there is already being input your registered email address.

9. Click "Reset Password" button.

10. Which will redirect you to "Sign in" page and assert the page title.
*/
import org.testng.annotations.Test;


import utils.WebDriverFactory;

public class SignUpWithExistingAccount extends WebDriverFactory{
@Test
public void signUpWithExistingAccount() throws InterruptedException{
	pages.SignUp signUp = new pages.SignUp();
	
	signUp.clickButton(signUp.signUp("Sign in & Account"));
	signUp.clickButton(signUp.signUp("Create Account"));
	signUp.createAccount("techsoft.tester@gmail.com", "Test*1234", "Technosoft", "Tester");
    //verify message
	signUp.clickButton(signUp.signUp("forgottenPassword"));
	 //verify message
}

}
