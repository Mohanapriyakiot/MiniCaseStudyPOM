package testScripts;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import base.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.CartListPage;
import pages.HomePage;
import pages.LoginPage;


public class DemoBlazeRunTest extends TestBase{
	
	HomePage homepage;
	LoginPage loginpage;
	WebDriverWait wait;
	LoginPage login;
    CartListPage cart;
   

	@BeforeTest
	public void setup() {
		initialize();
	}
  @Test(priority=1)
  public void Homepage() throws InterruptedException {
	  homepage = new HomePage();
//	  homepage.login();  
//	  loginpage=homepage.login();
	  loginpage=homepage.login();
	  homepage=loginpage.login();
	  
  }
  @Test(priority=2,dataProvider="data")
  public void multiItems(String data) throws InterruptedException {
	  homepage=new HomePage();
	  homepage.selectItems(data);
	//  homepage.cart();
  }
  
  
  @Test(priority=3)
  public void CartList() throws InterruptedException {
	  cart = new CartListPage();
	  cart.delete();
	  cart.Placeorder();	
	  WebElement msg = cart.message;
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

