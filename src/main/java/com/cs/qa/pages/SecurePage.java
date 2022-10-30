package com.cs.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.cs.qa.base.TestBase;

public class SecurePage extends TestBase{


	@FindBy(css = ".icon-2x.icon-signout")
	WebElement logoutBtn;
	
	//"You logged into a secure area!"
	@FindBy(id= "flash")
	WebElement successMsg;
	
	//" Secure Area"
	@FindBy(xpath = "//i[@class='icon-lock']")
	WebElement headerTxt;
	
	//"Welcome to the Secure Area. When you are done click logout below."
	@FindBy(xpath = "//h4[@class='subheader']")
	WebElement subheaderTxt;

	//initializing the page objects
	public SecurePage() {
		PageFactory.initElements(driver,this);
	}

	//"The Internet"
	public String GetPageTitle() {
		return driver.getTitle();
	}
	
	public LoginPage ClickOnLogoutBtn() {
		logoutBtn.click();
		return new LoginPage();	
	}
	
}
