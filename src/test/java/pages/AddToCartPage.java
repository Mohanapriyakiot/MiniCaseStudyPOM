package pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;

public class AddToCartPage extends TestBase {
	Alert alert;
	WebDriverWait wait;
	@FindBy(xpath="//a[contains(text(),'Home')]")
	public WebElement home;
	
	@FindBy(xpath="//a[contains(text(),'Add to cart')]")
	public WebElement addtocartbtn; 
	
	public AddToCartPage() {
		PageFactory.initElements(driver, this);
	}
		
	public void selectItems(String data) throws InterruptedException {
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	//	driver.findElement(By.partialLinkText(Category));
	//	Category.click();
//		driver.findElement(By.partialLinkText(Product));
//		Product.click();
		
		driver.findElement(By.linkText(data)).click();
	//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(addtocartbtn));
		addtocartbtn.click();		
		wait.until(ExpectedConditions.alertIsPresent());
		alert = driver.switchTo().alert();
		alert.accept();
		home.click();
	}
}


