package com.cs.qa.cucumber.stepDefinitions;

import java.io.IOException;

import com.cs.qa.util.RestAssuredExtension;
import com.cs.qa.base.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.testng.CucumberOptions;


public class CucumberHooks extends TestBase{
	
	@Before("@UI") // Cucumber annotation
	public void SetUp() throws IOException{
		System.out.println("*---> Start of Cucumber @Before in CucumberHooks.java for UI Tests");
		initialization();
	}

	@After("@UI") // Cucumber annotation
	public void tearDown() {
		System.out.println("*---> Start of Cucumber @After in CucumberHooks.java for UI Tests");
		driver.quit();
	}
	
	@Before("@Rest-Assured")
	public void TestSetup()
	{
		System.out.println("**---> Start of Cucumber @Before in CucumberHooks.java for API Tests");
		RestAssuredExtension restAssuredExtension = new RestAssuredExtension();
	}
}
