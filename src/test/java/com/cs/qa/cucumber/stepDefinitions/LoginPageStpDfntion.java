package com.cs.qa.cucumber.stepDefinitions;

import com.cs.qa.pages.LoginPage;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageStpDfntion extends PageCollectionForStpDfntions{

	public LoginPageStpDfntion() throws IOException{

		System.out.println("*** here in LoginPageStpDfntion constructor");
	}


	@Given("I am in login page")
	public void i_am_in_login_page() {
		
		loginPage = new LoginPage();
		
		Assert.assertEquals(driver.getTitle(), "The Internet", "Failed: HomePage title not matched!");
		Assert.assertEquals(driver.getCurrentUrl(), "http://the-internet.herokuapp.com/login", "Failed: Directed to wrong page!");

	}
	
	@Given("I am logged in to secure page")
	public void i_am_logged_in_to_secure_page() {

		loginPage = new LoginPage();
		loginPage.EnterUsername(prop.getProperty("username"));
		loginPage.EnterPassword(prop.getProperty("password"));
		securePage = loginPage.ClickLoginBtn();
		
		Assert.assertEquals(driver.getTitle(), "The Internet", "Failed: HomePage title not matched!");
		Assert.assertEquals(driver.getCurrentUrl(), "http://the-internet.herokuapp.com/secure", "Failed: Directed to wrong page!");
	}
	
	@When("I enter {string} as username and {string} as password")
	public void i_enter_and_for_login(String username, String password) {
		loginPage.EnterUsername(username);
		loginPage.EnterPassword(password);
		try {
			//Just to be able to see the process in the browser
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@When("I click on login button")
	public void i_click_on_login_button() {
		
		System.out.println(driver.getCurrentUrl());
		securePage = loginPage.ClickLoginBtn();
		System.out.println(driver.getCurrentUrl());
	}
	
	@When("I click on logout button")
	public void i_click_on_logout_button() {
		
		System.out.println(driver.getCurrentUrl());
		loginPage = securePage.ClickOnLogoutBtn();
		System.out.println(driver.getCurrentUrl());
	}
	
	@Then("I should be redirected to {string} page")
	public void i_should_be_logged_in_to_securepage(String page) {
		
		System.out.println("currentPageTitle: "+driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		Assert.assertEquals(driver.getTitle(), "The Internet", "Failed: HomePage title not matched!");
		Assert.assertEquals(driver.getCurrentUrl(), "http://the-internet.herokuapp.com/"+page, "Failed: Directed to wrong page!");
	}

	@Then("I should see the message {string}")
	public void i_should_see_error_message(String message) {
		
		String receivedMesg = loginPage.GetResultMsg();
		Assert.assertEquals(receivedMesg, message, "Failed: Error message mismatch! "+ message + "VS."+ receivedMesg);
	}
	
}
