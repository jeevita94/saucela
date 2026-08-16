package com.saucelab.pages.in;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class HomePage {
	
	WebDriver driver;
	public HomePage(WebDriver driver) {
	this.driver=driver;	
	}
	
	private By HomeProduct =By.xpath("//div//span[@class='title']");
	private By openMenu = By.xpath("//div//button[@id='react-burger-menu-btn']");
	private By Productlist =By.xpath("//div[@data-test='inventory-item-name']");
	private By sort = By.xpath("//select[@class='product_sort_container']");
	private By Pricelist = By.xpath("//div[@class='inventory_item_price']");
	private By Allmenu= By.xpath("//a[@id='inventory_sidebar_link']");
	private By aboutsidemenu = By.xpath("//a[@id='about_sidebar_link']");
	private By logout = By.xpath("//a[@id='logout_sidebar_link']");
	private By crossbtn = By.xpath("//button[@id='react-burger-cross-btn']");
	private  By addtoacrt= By.id("add-to-cart");
	private By cartButton = By.id("shopping_cart_container");
	private By remove = By.id("remove");
	
	public String getproductTitile() {
		return driver.getTitle();
	}
	
	public  void ClickOnopenMenu() {
		driver.findElement(openMenu).click();
	}
	public void removebutton() {
		driver.findElement(remove).click();
	}
	public void productList() {
		List<WebElement> list = driver.findElements(Productlist);
		int count = list.size();
		System.out.print(count);
		for(int i=0;i<=count;i++) {
			String Productname= list.get(i).getText();
			System.out.println(Productname);
		

			}
	}
	
	public void selectTheProduct(String Selectproduct ) throws InterruptedException {
		List<WebElement> list = driver.findElements(Productlist);
		
		int count = list.size();
		System.out.print(count);
		for(int i=0;i<=count;i++) {
			String Productname= list.get(i).getText();
			System.out.println(Productname);
		if(Productname.contains(Selectproduct)) {
		list.get(i).click();
		Thread.sleep(3000);
		AddtocartButton();
		
		
		
		}
		else {
			System.out.print("No Product Found");
		}
		break;
		}
		
		
	}
	public void AddtocartButton() {
		driver.findElement(addtoacrt).click();
	}
	public void cartcontainer() {
		driver.findElement(cartButton).click();
	}
	
	
	public void price() {
		List<WebElement> list = driver.findElements(Pricelist);
		list.sort(Comparator.comparingDouble(
			    e -> Double.parseDouble(e.getText().replace("$", "").replace(",", ""))
			));

			System.out.println("Sortedprice: " + list.get(0).getText());
			for(WebElement a:list) {
				System.out.println(a.getText());
				
			}
	//System.out.print(list.get(0).getText());
	
	//return list.get(0).getText();
		

	}	
	
	
	public void sort(String value) {
		
		
		Select s = new Select(driver.findElement(sort));
		//s.selectByValue(value);
		s.selectByVisibleText(value);
		
		
		
	}
	public void sortbyalphAtoZ() {
		List<WebElement> Plist = driver.findElements(Productlist);
		List<String> actualList = Plist.stream()
		        .map(WebElement::getText)
		        .map(String::trim)
		        .collect(Collectors.toList());

		List<String> sortedList = new ArrayList<>(actualList);

		Collections.sort(sortedList, String.CASE_INSENSITIVE_ORDER);

		if (actualList.equals(sortedList)) {
		    System.out.println("Items are displayed in A to Z order" );
		    System.out.println(actualList);
		} else {
		    System.out.println("Items are NOT displayed in A to Z order");
		    System.out.println("Actual: " + actualList);
		    System.out.println("Expected: " + sortedList);
		}
		
	}
	 public void sortalphaZtoA() {
		 List<WebElement> Plist = driver.findElements(Productlist);

		 List<String> actualList = Plist.stream()
			        .map(WebElement::getText)
			        .map(String::trim)
			        .collect(Collectors.toList());

			List<String> sortedList = new ArrayList<>(actualList);

			Collections.sort(sortedList, Collections.reverseOrder(String.CASE_INSENSITIVE_ORDER));

			if (actualList.equals(sortedList)) {
			    System.out.println("Items are displayed in Z to A order: " );
			    System.out.println(actualList);
			} else {
			    System.out.println("Items are NOT displayed in Z to A order");
			    System.out.println("Actual: " + actualList);
			    System.out.println("Expected: " + sortedList);
			}
	 }
    
	}
	
	
	

	

