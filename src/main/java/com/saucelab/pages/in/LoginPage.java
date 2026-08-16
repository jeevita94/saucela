package com.saucelab.pages.in;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
	this.driver=driver;
	}
	
	private By Username = By.id("user-ame");
	private By password = By.id("password");
	private By login = By.id("login-button");
	
	
	
	
	
	
	
	public void loginCredential(String Usrname,String pwd) {
		driver.findElement(Username).sendKeys(Usrname);
		driver.findElement(password).sendKeys(pwd);
				
	}
	public void clickOnLoginButton() {
		driver.findElement(login).click();
	}
	
	public String title() {
		return driver.getTitle();
		
	}
}
