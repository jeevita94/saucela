package com.saucelab.pages.in;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutOverwiewPage {
	
	WebDriver driver;
	
	public CheckOutOverwiewPage(WebDriver driver) {
		this.driver=driver;
		
	}
	
	private By finish = By.id("finish");
	private By cancel = By.id("cancel");
	
	
	public void clickOnFinish() {
		driver.findElement(finish).click();
	}
	

}
