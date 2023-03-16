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

public class HomePage  extends TestBase{
	Alert alert;
    WebDriverWait wait;
    
//    @FindBy(xpath="//a[contains(text(),'Home')]")
//	public WebElement home;

	@FindBy(id="login2")
	WebElement loginBtn;
	
	
	
	@FindBy(id="cartur")
	WebElement cart;
	
	@FindBy(xpath="//a[contains(text(),'Add to cart')]")
	public WebElement addtocartbtn;
	
	@FindBy(xpath="//a[contains(text(),'Home')]")
	public WebElement home;
	 
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public LoginPage login() {
		
		loginBtn.click();
		return new LoginPage();
	}
	
	public void selectItems(String data) throws InterruptedException {
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		Thread.sleep(3000);
		driver.findElement(By.linkText(data)).click();
		Thread.sleep(3000);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(addtocartbtn));
		addtocartbtn.click();		
		wait.until(ExpectedConditions.alertIsPresent());
		alert = driver.switchTo().alert();
		alert.accept();
		home.click();
}
	public void cart() {
		cart.click();
		
	}
}
