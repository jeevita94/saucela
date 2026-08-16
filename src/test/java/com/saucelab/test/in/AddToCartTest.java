package com.saucelab.test.in;

import java.io.IOException;

import org.testng.annotations.Test;

import com.saucelab.base.in.Base;
import com.saucelab.base.in.DriverManager;
import com.saucelab.pages.in.AddToCartPage;
import com.saucelab.pages.in.HomePage;
import com.saucelab.pages.in.LoginPage;
import com.saucelab.property.in.Configprop;

public class AddToCartTest extends Base {
	Configprop con;
	LoginPage log;
	HomePage home;
	AddToCartPage add;

	@Test
	public void CheckItemincart() throws IOException, InterruptedException {
		con=new Configprop();
    	log = new LoginPage(DriverManager.getDriver());
    	home = new HomePage(DriverManager.getDriver());
    	add = new AddToCartPage(DriverManager.getDriver());
    	con.getUrl();
    	log.loginCredential("visual_user", "secret_sauce");
    	log.clickOnLoginButton();
    	System.out.println("Input given");
    	Thread.sleep(4000);
		//home.productList("Sauce Labs Backpack");
    	home.selectTheProduct("Sauce Labs Backpack");
    	home.cartcontainer();
    	//home.AddtocartButton();
		Thread.sleep(4000);
		add.checktheAddedItemInCart("Sauce Labs Backpack");
		
	}
	@Test
	public void CheckAfterRemove() throws IOException, InterruptedException {
		con=new Configprop();
    	log = new LoginPage(DriverManager.getDriver());
    	home = new HomePage(DriverManager.getDriver());
    	add = new AddToCartPage(DriverManager.getDriver());
    	con.getUrl();
    	log.loginCredential("visual_user", "secret_sauce");
    	log.clickOnLoginButton();
    	System.out.println("Input given");
    	Thread.sleep(4000);
		//home.productList("Sauce Labs Backpack");
    	home.selectTheProduct("Sauce Labs Backpack");
    	Thread.sleep(3000);
    	home.removebutton();
    	home.cartcontainer();
    	add.checktheAddedItemInCart("Sauce Labs Backpack");
    	Thread.sleep(3000);
    	
		
	}
}
