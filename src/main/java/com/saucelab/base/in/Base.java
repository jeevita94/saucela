package com.saucelab.base.in;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.saucelab.property.in.Configprop;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	 @BeforeMethod
	    
	 public void setup() throws IOException {
		 
		 WebDriverManager.chromedriver().setup();
		 //driver = new ChromeDriver();
			//System.setProperty("webdriver.chrome.driver", "D:\\chromedriver0406265\\chromedriver-win64\\gv.exe");
		 
		  //  WebDriver driver = new ChromeDriver();
		    ChromeOptions options = new ChromeOptions();

	        // Disable Chrome password manager
	        options.addArguments("--disable-save-password-bubble");

	        // Disable password manager services
	        options.setExperimentalOption("prefs", 
	            java.util.Map.of(
	                "credentials_enable_service", false,
	                "profile.password_manager_enabled", false,
	                "profile.password_manager_leak_detection", false
	            )
	        );

	        WebDriver driver = new ChromeDriver(options);
	        DriverManager.setDriver(driver);
	        driver.manage().window().maximize();
		   
			Configprop con= new Configprop();
		   // DriverManager.getDriver().get("https://www.saucedemo.com");
			
			DriverManager.getDriver().get(con.getUrl());
		}
	 
	 
	 @AfterMethod
	 public void tearDown() {
	     DriverManager.getDriver().quit();
	     DriverManager.removeDriver();
	 }

}
