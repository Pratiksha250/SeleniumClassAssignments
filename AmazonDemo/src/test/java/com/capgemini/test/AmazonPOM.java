package com.capgemini.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AmazonPOM {

	@FindBy(how=How.ID, using="twotabsearchtextbox")
	public WebElement searchText;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"nav-search\"]/form/div[2]/div/input")
	public WebElement searchButton;
	
	@FindBy(how=How.CSS, using="#result_0 > div > div.a-fixed-left-grid > div > div.a-fixed-left-grid-col.a-col-right > div.a-row.a-spacing-small > div:nth-child(1) > a > h2")
	public WebElement searchProduct;
	
	public static WebElement addToCart(WebDriver driver) {
		String currentTab = driver.getWindowHandle();
		for (String tab : driver.getWindowHandles()) {
		    if (!tab.equals(currentTab)) {
		        driver.switchTo().window(tab); 
		    }       
		}
		WebElement cart = driver.findElement(By.id("add-to-cart-button"));
		return cart;
	}
	
	@FindBy(how=How.XPATH, using="//*[@id=\"huc-v2-order-row-confirm-text\"]/h1")
	public WebElement finalCheck;
}
