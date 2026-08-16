package com.saucelab.test.in;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.saucelab.base.in.Base;
import com.saucelab.base.in.DriverManager;
import com.saucelab.pages.in.HomePage;
import com.saucelab.pages.in.LoginPage;
import com.saucelab.property.in.Configprop;

public class HomeTest extends Base{
	Configprop con;
	LoginPage log;
	HomePage home;
	
	    @Test
	    public void sorttheproductlowestprice() throws InterruptedException, IOException {
	    	con=new Configprop();
	    	log = new LoginPage(DriverManager.getDriver());
	    	home = new HomePage(DriverManager.getDriver());
	    	con.getUrl();
	    	log.loginCredential("visual_user", "secret_sauce");
	    	log.clickOnLoginButton();
	    	System.out.println("Input given");
			
	    System.out.println(home.getproductTitile());
	    	Thread.sleep(3000);
	    	home.sort("Price (low to high)");
	    	Thread.sleep(3000);
	    	home.price();
	   
	    	
	    }
	    @Test
	    public void sorttheproductwithHighestprice() throws InterruptedException, IOException {
	    	con=new Configprop();
	    	log = new LoginPage(DriverManager.getDriver());
	    	home = new HomePage(DriverManager.getDriver());
	    	con.getUrl();
	    	log.loginCredential("visual_user", "secret_sauce");
	    	log.clickOnLoginButton();
	    	System.out.println("Input given");
			
	    	home.sort("Price (high to low)");
	    	Thread.sleep(4000);
	    	home.price();
	    	
	    	
	    }
	    @Test
	    public void Selecttheproduct() throws IOException, InterruptedException {
	    	con=new Configprop();
	    	log = new LoginPage(DriverManager.getDriver());
	    	home = new HomePage(DriverManager.getDriver());
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
			
	    }
	    
	    @Test
	    public void sortByAlphabetAtoZ() throws IOException, InterruptedException {
	    	con=new Configprop();
	    	log = new LoginPage(DriverManager.getDriver());
	    	home = new HomePage(DriverManager.getDriver());
	    	con.getUrl();
	    	log.loginCredential("visual_user", "secret_sauce");
	    	log.clickOnLoginButton();
	    	System.out.println("Input given");
			Thread.sleep(4000);
	    	home.sort("Name (A to Z)");
	    	Thread.sleep(3000);
	    	
	    	home.sortbyalphAtoZ();
	    	
	    	
	    }
	    @Test
	    public void sortByAlphabetZtoA() throws IOException, InterruptedException {
	    	con=new Configprop();
	    	log = new LoginPage(DriverManager.getDriver());
	    	home = new HomePage(DriverManager.getDriver());
	    	con.getUrl();
	    	log.loginCredential("visual_user", "secret_sauce");
	    	log.clickOnLoginButton();
	    	System.out.println("Input given");
			Thread.sleep(4000);
	    	home.sort("Name (Z to A)");
	    	Thread.sleep(3000);
	    	home.sortalphaZtoA();
	    }
	    
	    
	    
	    
	    

}
