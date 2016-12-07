package pages;

import java.util.HashMap;

import org.openqa.selenium.By;

public class SignUp extends BaseClass{

 public By signUp(String key){	
	HashMap<String, By> signUpElement = new HashMap<String, By>();
    signUpElement.put("email", By.id("sign-up-email"));
    signUpElement.put("password", By.id("sign-up-password"));
    signUpElement.put("FirstName", By.id("sign-up-first-name"));
    signUpElement.put("LastName", By.id("sign-up-last-name"));
    signUpElement.put("signUpButton", By.id("signup-button"));
    signUpElement.put("Sign in & Account", By.id("hdr-account"));
    signUpElement.put("Create Account", By.id("hdr-create"));
    signUpElement.put("signUpErrorMessage", By.xpath("//*[@class='msg-error-icon msg-big']"));
    signUpElement.put("forgottenPassword", By.xpath("//a[text()='forgotten your password']"));
    
    By locator= signUpElement.get(key);
    return locator;
 }
 public void createAccount(String email, String password, String FirstName, String LastName){
     
//		enterData(signUp("email"), email);
//		enterData(signUp("password"), password);
//		enterData(signUp("FirstName"), FirstName);
//		enterData(signUp("LastName"), LastName);
//		clickButton(signUp("signUpButton"));
	}

}
