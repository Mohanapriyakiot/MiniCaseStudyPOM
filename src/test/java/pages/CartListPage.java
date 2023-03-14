package pages;
	import java.time.Duration;
	import java.util.List;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;



	public class CartListPage extends TestBase{
		public String pval_del;
		public int del_cart_size;
		WebDriverWait wait;
		@FindBy(xpath="(//a[text()='Delete'])[1]")
		WebElement deletebtn;
		
		public CartListPage() {
			PageFactory.initElements(driver, this);
		}

		public void delete() {
			deletebtn.click();
			wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			pval_del = driver.findElement(By.id("totalp")).getText();
			del_cart_size = driver.findElements(By.xpath("//tbody//td[2]")).size();
		}
		
	}


