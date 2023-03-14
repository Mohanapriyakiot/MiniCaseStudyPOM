package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;

public class HomePage  extends TestBase{
	
    WebDriverWait wait;

	@FindBy(id="login2")
	WebElement loginBtn;
	
	@FindBy(id="loginusername")
	WebElement inputUsr;
	
	@FindBy(id="loginpassword")
	WebElement inputPwd;
	
	@FindBy(xpath="(//button[@class='btn btn-primary'])[3]")
	WebElement userLogin;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
public void login(){
	loginBtn.click();
	inputUsr.sendKeys("priya@13");
	inputPwd.sendKeys("123456789");
	userLogin.click();

	
}
}
