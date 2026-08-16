package com.saucelab.pages.in;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CheckoutInfoPage {
	WebDriver driver;
	
	public CheckoutInfoPage(WebDriver driver) {
		this.driver=driver;
	}
	
	private By firstname= By.id("first-name");
	private By lastname = By.id("last-name");
	private By postalcode= By.id("postal-code");
	private By continnue = By.id("continue");
	private By cancel = By.id("cancel");
	private By title = By.xpath("//span[@class='title']");
	public void firstName(String first) {
		driver.findElement(firstname).sendKeys(first);
	}
	public void lastname(String last) {
		driver.findElement(lastname).sendKeys(last);
	}
	public void postalCode(String code) {
		driver.findElement(postalcode).sendKeys(code);
	}
	 public void clickOnContinue() {
		 driver.findElement(continnue).click();
	 }
	 public void clickOnCancel() {
		 driver.findElement(cancel).click();
	 }
	 public void verifycheckoutPage() {

		    String actualTitle= driver.findElement(title).getText();
		    Assert.assertEquals(actualTitle, "Checkout: Your Information");
		    System.out.println("chechoutinfopage");
		}
	
}


