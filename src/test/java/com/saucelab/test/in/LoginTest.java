package com.saucelab.test.in;

import java.io.IOException;

import org.testng.annotations.Test;

import com.saucelab.base.in.Base;
import com.saucelab.base.in.DriverManager;
import com.saucelab.pages.in.HomePage;
import com.saucelab.pages.in.LoginPage;
import com.saucelab.property.in.Configprop;

public class LoginTest extends Base {
	Configprop con;
LoginPage log;
HomePage home;

//    @Test
//    public void launchGoogle() {
//        System.out.println("Thread ID: " + Thread.currentThread().getId());
//        System.out.println("Title: " + DriverManager.getDriver().getTitle());
//    }
    @Test
    public void loginthepage() throws InterruptedException, IOException {
    	con=new Configprop();
    	log = new LoginPage(DriverManager.getDriver());
    	home = new HomePage(DriverManager.getDriver());
    	con.getUrl();
    	log.loginCredential("visual_user", "secret_sauce");
    	log.clickOnLoginButton();
    	
    	
    	
    	
    }
    
}
