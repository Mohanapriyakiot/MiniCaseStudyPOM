package pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;

public class PlaceOrderPage extends TestBase {
	WebDriverWait wait;
	@FindBy(xpath="//button[@class='btn btn-success']")
	WebElement placeorder;
	
	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
	@FindBy(id="name")
	WebElement name;
	
	@FindBy(id="country")
	WebElement country;
	
	@FindBy(id="city")
	WebElement city;
	
	@FindBy(id="card")
	WebElement card;
	
	@FindBy(id="month")
	WebElement month;
	
	@FindBy(id="year")
	WebElement year;
	
	@FindBy(xpath="//button[text()='Purchase']")
	public WebElement purchase;
	
	
	@FindBy(xpath="//h2[text()='Thank you for your purchase!']")
	
	public WebElement message;
	public PlaceOrderPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void Placeorder() throws InterruptedException{
		
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		Thread.sleep(3000);
		placeorder.click();		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		name.sendKeys("Mohanapriya");
		country.sendKeys("India");
		city.sendKeys("Salem");
		card.sendKeys("123456");
		month.sendKeys("3");
		year.sendKeys("2023");
	    wait.until(ExpectedConditions.visibilityOf(purchase));
		wait.until(ExpectedConditions.elementToBeClickable(purchase));
		purchase.click();
		Thread.sleep(3000);
		
	}
	

}
