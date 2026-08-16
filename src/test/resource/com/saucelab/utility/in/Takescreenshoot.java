package com.saucelab.utility.in;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Takescreenshoot {
	
	WebDriver driver;
	
	public Takescreenshoot(WebDriver driver) {
		this.driver=driver;
		
	}
	public void takeScreenshot(String fileName) throws IOException {

        TakesScreenshot ts = (TakesScreenshot) driver;
       

        File source = ts.getScreenshotAs(OutputType.FILE);

        File destination = new File("./screenshots/" + fileName + ".png");

        FileUtils.copyFile(source, destination);

        System.out.println("Screenshot saved: " + destination.getAbsolutePath());
    }
	

}
