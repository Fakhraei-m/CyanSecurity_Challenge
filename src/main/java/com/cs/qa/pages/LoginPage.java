package com.cs.qa.pages;

import com.cs.qa.base.TestBase;
import com.cs.qa.util.TestUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.eclips.jetty.

public class LoginPage extends TestBase{

	@FindBy(name= "username")
	WebElement username;
	
	@FindBy(name= "password")
	WebElement password;
	
	@FindBy(css= ".fa.fa-2x.fa-sign-in")
	WebElement loginBtn;
	
	//"You logged out of the secure area!"
	//"Your username is invalid!"
	//"You must login to view the secure area!"
	@FindBy(id= "flash")
	WebElement resultMsg;
	
	//Initializing the page objects
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	//The Internet
	public String GetPageTitle() {
		return driver.getTitle();
	}
	
	public void EnterUsername(String un) {
		username.sendKeys(un);
	}
	
	public void EnterPassword(String pwd) {
		password.sendKeys(pwd);
	}
	
	public SecurePage ClickLoginBtn() {
		loginBtn.click();
		return new SecurePage();
	}
	
	public SecurePage Login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new SecurePage();
	}
	
	public String GetResultMsg() {
		
		return TestUtil.StringPurifying(resultMsg.getText());
	}
}
