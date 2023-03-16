package pages;
	import java.time.Duration;
	import java.util.List;

	import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.TestBase;



	public class CartListPage extends TestBase{
		
		WebDriverWait wait;
	//	public String price;
		
		@FindBy(id="cartur")
		WebElement cart;
		
		
		@FindBy(xpath="//tbody//td[2]")
		public List<WebElement> items_in_cart;
		
		@FindBy(id ="totalp")
		WebElement price;
		
		@FindBy(xpath="(//a[text()='Delete'])[1]")
		WebElement deletebtn;
		
		@FindBy(xpath="//button[@class='btn btn-success']")
		WebElement placeorder;
		
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
		
		public CartListPage() {
			PageFactory.initElements(driver, this);
		}
		
		public void delete() throws InterruptedException {
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(cart)).click();
			wait.until(ExpectedConditions.visibilityOf(price));
			
			String valueBefore = price.getText();
		//	int iBefore=Integer.parseInt(valueBefore);
			wait.until(ExpectedConditions.elementToBeClickable(deletebtn)).click();
			Thread.sleep(2000);
			String valueAfter = price.getText();
		//	int iAfter=Integer.parseInt(valueAfter);
			Assert.assertNotEquals("valueBefore", "valueAfter");						
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


