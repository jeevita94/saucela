package com.saucelab.pages.in;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import junit.framework.Assert;

public class AddToCartPage {

WebDriver driver;
	
	public AddToCartPage(WebDriver driver) {
	this.driver=driver;
	}
	
	private By cartlistitems = By.xpath("//div[@class='inventory_item_name']");
	private By remove = By.id("remove-sauce-labs-backpack");
	private By continueShopping = By.id("continue-shopping");
	private By checkout = By.id("checkout");
	private By title = By.xpath("//span[@class='title']");


	public void checktheAddedItemInCart(String Addeditem) {
	List<WebElement> cartlist= driver.findElements(cartlistitems);
    boolean itemFound = false;
	for(WebElement cart:cartlist) {
		String carttext=cart.getText();
		if(carttext.contains(Addeditem)) {
			 itemFound = true;
			 break;
			
		}
	}
		if (itemFound) {
	        System.out.println("Added item is displayed in the cart: " + Addeditem);
	        Assert.assertTrue(itemFound);
	    } 
	    else {
	        System.out.println("Added item is NOT displayed in the cart: " + Addeditem);
	        Assert.assertFalse(itemFound);
	    }
		
		
	}
	
	


	public void removeFromCart() {
	driver.findElement(remove).click();;
}
	
	public void ClickOnContinueShopping() {
		driver.findElement(continueShopping).click();
	}
	
	public void clickOnCheckout() {
		driver.findElement(checkout).click();
	}
	
	public void verifyCartPage() {

	  Boolean b= driver.findElement(title).isDisplayed();
	    

	  
	    System.out.println("Successfully navigated back to Cart page");
	}
	
	
	
	
	
	
	
	
}