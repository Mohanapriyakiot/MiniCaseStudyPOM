package testScripts;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import base.TestBase;
import pages.AddToCartPage;
import pages.CartListPage;
import pages.HomePage;
import pages.PlaceOrderPage;
import pages.ViewCartPage;

public class DemoBlazeRunTest extends TestBase{
	
	HomePage homepage;
	WebDriverWait wait;
    AddToCartPage selectItems;
    ViewCartPage cart;
    CartListPage delete;
    PlaceOrderPage order;
    String p_val;
    public int c_size;
    String del_p_val;
    public int del_c_size;
	
	@BeforeTest
	public void setup() {
		initialize();
	}
  @Test(priority=1)
  public void userloginTest() {
	  homepage = new HomePage();
	  homepage.login();  
	  wait = new WebDriverWait(driver,Duration.ofSeconds(10));
  }
  
  @Test(priority=2,dataProvider = "data")
  public void selectItems(String data) {
	   selectItems = new AddToCartPage();
	   selectItems.selectItems(data);
	  
  }
  
  @Test(priority=3)
  public void ViewCart() {
	  cart = new ViewCartPage();
	  cart.cart();
	  c_size = cart.cart_size;
	  p_val = cart.price;
	  
	  
  }
  
  @Test(priority=4,dependsOnMethods="ViewCart")
  public void delete() {
	  delete = new CartListPage();
	  delete.delete();
	  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
	  String price_before = cart.price;
	  int before_cart = c_size;
	  String price_after = delete.pval_del;
	  int after_cart = delete.del_cart_size;
	  boolean res = before_cart!=after_cart;
	  Assert.assertTrue(res);
  }
  
  @Test(priority=5)
  public void PlaceOrder() throws InterruptedException {
	  order = new PlaceOrderPage();
	  order.Placeorder();
	  WebElement msg = order.message;
	  Assert.assertTrue(msg.isDisplayed());
  }
  
  @DataProvider(name="data")
  public Object[][] getData1() throws CsvValidationException, IOException{
	  String path=System.getProperty("user.dir")+"//src//test//resources//testData//data.csv";
	  String[] cols;
	  CSVReader reader = new CSVReader(new FileReader(path));
	  ArrayList<Object> dataList=new ArrayList<Object>();
	  while((cols=reader.readNext())!=null)
	  {
		  Object[] record= {cols[0]};
		  dataList.add(record);
	  }
	  return dataList.toArray(new Object[dataList.size()][]);
	  
  }
}

