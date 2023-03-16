package pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;

public class LoginPage extends TestBase {
	WebDriverWait wait;
//	@FindBy(id="login2")
//	WebElement loginBtn;
	
	@FindBy(id="loginusername")
	WebElement inputUsr;
	
	@FindBy(id="loginpassword")
	WebElement inputPwd;
	
	@FindBy(xpath="(//button[@class='btn btn-primary'])[3]")
	WebElement userLogin;
	

	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public HomePage login() throws InterruptedException{
		wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(inputUsr));
		inputUsr.sendKeys("priya@13");
		inputPwd.sendKeys("123456789");
		Thread.sleep(2000);
		userLogin.click();	
		return new HomePage();
	}

//	
//}
	
	}

