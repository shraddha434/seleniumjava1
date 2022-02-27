package test1.tesng1;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import static org.testng.Assert.assertEquals;

import java.awt.Desktop.Action;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Parameters;


@Parameters ({"browser"})
@Test


public class myntra {
	
	public static WebDriver driver;
	 
	
  public void addtocart() {
	  Actions action =new Actions(driver);
	  driver.findElement(By.xpath("//input[@class='desktop-searchBar']")).sendKeys("tops");
	 WebElement   f= driver.findElement(By.xpath("//ul[@class='desktop-group']"));
	 action.moveToElement(f).build().perform();
	 WebElement sel= driver.findElement(By.xpath("//li[@data-index='1']"));
	
		 sel.click();
		 try {
		Alert alt =driver.switchTo().alert();
			alt.dismiss();
		 }
		catch( NoAlertPresentException e) {
	driver.findElement(By.xpath("//Li[@class='product-base'][2]")).click();
		}
	Set<String> windownew=driver.getWindowHandles();
	System.out.println(windownew);
	Iterator<String> iterator =windownew.iterator();
	
	String parentwindow=iterator.next();
	System.out.println(parentwindow);
	String childwindow=iterator.next();
	System.out.println(childwindow);
	driver.switchTo().window(childwindow);
	System.out.println(driver.getTitle());
  }
	  public void addtocart2() {
		  Actions action =new Actions(driver);
	try {
		Alert alt =driver.switchTo().alert();
		alt.accept();
		
	}
	catch(NoAlertPresentException Ex){ 
	
		// On Successful login compare Actual Page Title with Expected Title
		WebElement add=	driver.findElement(By.xpath("//div[text()='ADD TO BAG']"));
		action.moveToElement(add).doubleClick().build().perform();
		boolean msg= driver.findElement(By.xpath("//span[@class='size-buttons-size-error-message']")).isEnabled();
		System.out.println("select size"+ msg);
		
		
    	
  } 
	  }
	  @Parameters ({"browser"})
	
@SuppressWarnings("deprecation")
@BeforeSuite
  public void beforeMethod( String browser) {
	  
	  if( browser.equalsIgnoreCase("chrome"))
	  {
		  WebDriverManager.chromedriver().setup();
		  driver = new ChromeDriver();
	  }
	  else if 
	  ( browser.equalsIgnoreCase("edge")) {
		  WebDriverManager.edgedriver().setup();
		  driver = new EdgeDriver();
	  }
	
	  driver.get("https://www.myntra.com/shop/men");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
	  
	  
	  
  }

  @AfterSuite
  public void afterMethod() {
  }

}
