package com.saucelab.test.in;

import java.io.IOException;

import org.testng.annotations.Test;

import com.saucelab.base.in.Base;
import com.saucelab.base.in.DriverManager;
import com.saucelab.pages.in.AddToCartPage;
import com.saucelab.pages.in.CheckOutOverwiewPage;
import com.saucelab.pages.in.CheckoutInfoPage;
import com.saucelab.pages.in.HomePage;
import com.saucelab.pages.in.LoginPage;
import com.saucelab.property.in.Configprop;
import com.saucelab.utility.in.Takescreenshoot;

public class CheckOutInfoTest extends Base {
	Configprop con;
	LoginPage log;
	HomePage home;
	AddToCartPage add;
	CheckoutInfoPage checkoutinfo;
	Takescreenshoot shottt;
	
	
	@Test
	public void ProductCheckout() throws IOException, InterruptedException {
		con=new Configprop();
    	log = new LoginPage(DriverManager.getDriver());
    	home = new HomePage(DriverManager.getDriver());
    	add = new AddToCartPage(DriverManager.getDriver());
    	checkoutinfo = new CheckoutInfoPage(DriverManager.getDriver());
    	shottt= new Takescreenshoot(DriverManager.getDriver());
    	
    	con.getUrl();
    	log.loginCredential("visual_user", "secret_sauce");
    	log.clickOnLoginButton();
    	Thread.sleep(4000);
    	home.getproductTitile();
    	home.selectTheProduct("Sauce Labs Backpack");
    	home.cartcontainer();
		Thread.sleep(4000);
		add.verifyCartPage();
		add.checktheAddedItemInCart("Sauce Labs Backpack");
		Thread.sleep(4000);
		shottt.takeScreenshot("jeevi");
		Thread.sleep(3000);
		add.clickOnCheckout();
		Thread.sleep(3000);
		checkoutinfo.verifycheckoutPage();
		checkoutinfo.firstName("jeevi");
		checkoutinfo.lastname("S");
		checkoutinfo.postalCode("djjkjlj");
		Thread.sleep(2000);
		checkoutinfo.clickOnContinue();
		Thread.sleep(3000);
		shottt.takeScreenshot("jeevita");
		
		
	}
	
	@Test
	public void ProductCancel() throws IOException, InterruptedException {
		con=new Configprop();
    	log = new LoginPage(DriverManager.getDriver());
    	home = new HomePage(DriverManager.getDriver());
    	add = new AddToCartPage(DriverManager.getDriver());
    	checkoutinfo = new CheckoutInfoPage(DriverManager.getDriver());
    	con.getUrl();
    	log.loginCredential("visual_user", "secret_sauce");
    	log.clickOnLoginButton();
    	Thread.sleep(4000);
    	home.selectTheProduct("Sauce Labs Backpack");
    	home.cartcontainer();
		Thread.sleep(4000);
		add.verifyCartPage();
		add.checktheAddedItemInCart("Sauce Labs Backpack");
		add.clickOnCheckout();
		Thread.sleep(3000);
		checkoutinfo.verifycheckoutPage();
		checkoutinfo.firstName("jeevi");
		checkoutinfo.lastname("S");
		checkoutinfo.postalCode("djjkjlj");
		Thread.sleep(2000);
		checkoutinfo.clickOnCancel();
		Thread.sleep(3000);
		add.verifyCartPage();
		
	}
	

}
