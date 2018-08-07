package com.capgemini.test;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AmazonSteps {

	WebDriver driver;
	AmazonPOM pomPage;
	
	@Given("^user is on HomePage$")
	public void user_is_on_HomePage() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "D:\\Users\\pdhandar\\Desktop\\3\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();
		
		pomPage = PageFactory.initElements(driver, AmazonPOM.class);
		
	}
	
	@When("^user enters \"(.*?)\"$")
	public void user_enters(String arg1) throws Throwable {
	    //driver.findElement(By.id("twotabsearchtextbox")).sendKeys(arg1);
		pomPage.searchText.sendKeys(arg1);
		
	}

	@When("^user clicks on search$")
	public void user_clicks_on_search() throws Throwable {
		//driver.findElement(By.xpath("//*[@id=\"nav-search\"]/form/div[2]/div/input")).click();
		pomPage.searchButton.click();
	}

	@When("^user selects the product$")
	public void user_selects_the_product() throws Throwable {
	   //driver.findElement(By.cssSelector("#result_0 > div > div.a-fixed-left-grid > div > div.a-fixed-left-grid-col.a-col-right > div.a-row.a-spacing-small > div:nth-child(1) > a > h2")).click();
		pomPage.searchProduct.click();
	   Thread.sleep(3000);
	
	}

	@When("^user adds the product to the cart$")
	public void user_adds_the_product_to_the_cart() throws Throwable {
		
		AmazonPOM.addToCart(driver).click();
		
//		String currentTab = driver.getWindowHandle();
//		for (String tab : driver.getWindowHandles()) {
//		    if (!tab.equals(currentTab)) {
//		        driver.switchTo().window(tab); 
//		    }       
//		}
//		driver.findElement(By.id("add-to-cart-button")).click();
		
	}

	@Then("^product is added in the card$")
	public void product_is_added_in_the_card() throws Throwable {
	  //assertEquals("Added to Cart",driver.findElement(By.xpath("//*[@id=\"huc-v2-order-row-confirm-text\"]/h1")).getText());
		assertEquals("Added to Cart", pomPage.finalCheck.getText());
	}


	
	
}
