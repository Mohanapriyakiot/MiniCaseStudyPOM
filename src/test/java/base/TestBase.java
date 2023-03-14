package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;



public class TestBase {
    public static Properties prop=null;
    public static WebDriver driver=null;
   
    public TestBase() {
    String path=System.getProperty("user.dir")+"//src//test//resources//configFiles//config.properties";
    prop=new Properties();
    FileInputStream fin;
    try {
    fin=new FileInputStream(path);
    prop.load(fin);
    }
    catch(FileNotFoundException e) {
    e.printStackTrace();
    }
    catch(IOException e) {
    e.printStackTrace();
    }
    catch(NullPointerException e) {
    	e.printStackTrace();
    }
    }
    public static void initialize() {
    String Browser=prop.getProperty("browser");    
    if(Browser.equalsIgnoreCase("Edge")) {
    WebDriverManager.edgedriver().setup();
    driver=new EdgeDriver();    
    }
    driver.manage().window().maximize();
   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    driver.get("https://www.demoblaze.com/index.html");
   
    }


}
