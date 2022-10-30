package com.cs.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;

import java.time.Duration;

import com.cs.qa.util.MyWebDriverListener;
import com.cs.qa.util.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.webdriver.*;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static WebDriver e_driver;
	
	public TestBase()
	{
		System.out.println("**--> Start of TestBase constructor");
		try {
			String ProjectPath = System.getProperty("user.dir");
			System.out.println("*->ProjectPath: "+ ProjectPath);
			prop = new Properties();
			FileInputStream ip = new FileInputStream(ProjectPath+"/src/main/java/com/cs/qa/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("**--> End of TestBase constructor");
	}
	
	public static void initialization() {
		System.out.println("**--> Start of initialization in TestBase");
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome"))			
			driver = WebDriverManager.chromedriver().create();//in WebDriverManager 5.x
		else if(browserName.equals("FF"))
			driver = WebDriverManager.firefoxdriver().create();//in WebDriverManager 5.x

		
		//Event Listener For WebDriver
		WebDriverListener listener = new MyWebDriverListener();
		e_driver = new EventFiringDecorator<WebDriver>(listener).decorate(driver);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
		
		driver.get(prop.getProperty("url"));
		System.out.println("**--> End of initialization in TestBase");
	}
}
