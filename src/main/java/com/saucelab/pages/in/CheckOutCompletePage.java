package com.saucelab.pages.in;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutCompletePage {
	
	WebDriver driver; 
	public CheckOutCompletePage(WebDriver driver ) {
		this.driver=driver;
		
	}
	
	private By backtohome = By.id("back-to-products");
	private By generatepdforder = By.id("generate-pdf-order");
	private By ThanksMessage = By.xpath("//div//h2[text()='Thank you for your order!']");
	
	public void ClickOnBackToHome() {
		driver.findElement(backtohome).click();
	}
	
	public void ClickOnGeneratepdgButton() {
		driver.findElement(generatepdforder).click();
	}

	public void ThanksOrderMessage() {
		String message = driver.findElement(ThanksMessage).getText();
		System.out.println(message);
	}
	

}
