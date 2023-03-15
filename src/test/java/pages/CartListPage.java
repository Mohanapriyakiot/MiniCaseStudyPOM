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
		@FindBy(id ="totalp")
		WebElement price;
		
		@FindBy(xpath="(//a[text()='Delete'])[1]")
		WebElement deletebtn;
		
		public CartListPage() {
			PageFactory.initElements(driver, this);
		}

		public void delete() throws InterruptedException {
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));;
			wait.until(ExpectedConditions.visibilityOf(price));
			//Thread.sleep(3000);
			String valueBefore = price.getText();
			int iBefore=Integer.parseInt(valueBefore);
			deletebtn.click();
			String valueAfter = price.getText();
			int iAfter=Integer.parseInt(valueAfter);
			Assert.assertNotEquals("iBefore", "iafter");						
		}
		
	}


