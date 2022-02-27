package test1.tesng1;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.internal.Utils;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.net.ConnectException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.slf4j.helpers.Util;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

public class Logintest {
	
	public static WebDriver driver;
	
	String actualTitle;
	String actualBoxMsg;
  @Test(dataProvider = "dp")
  
  public void login (String username, String password) {
	  SoftAssert Softassert= new SoftAssert();
	  System.out.println(username +"====="+password);
	  driver.findElement(By.xpath("//input[@type='text']")).sendKeys(username);
	  driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
	  driver.findElement(By.xpath("//input[@type='submit']")).click();
	  
	  try {
		  Alert alt=driver.switchTo().alert();
		  actualBoxMsg = alt.getText(); // get content of the Alter Message
		  System.out.println(actualBoxMsg);
			alt.accept();
		
			Softassert.assertEquals(actualBoxMsg,alt.getText());
			
		  
	  }
	 catch (NoAlertPresentException Ex){ 
	    	actualTitle = driver.getTitle();
			// On Successful login compare Actual Page Title with Expected Title
	    	assertEquals(actualTitle,driver.getTitle());
	    	
      } 
  }
  @Test (dataProvider="test1")
  public void login1 (String username, String password) {
	  
  }
  
  @BeforeMethod
    public void beforeMethod() {
	  WebDriverManager.edgedriver().setup();
	  driver= new EdgeDriver();
	 // driver.get("https://secure.icicidirect.com/customer/login");
	  driver.get("https://www.demo.guru99.com/V4/index.php");
	 
	 }

  @AfterMethod
  public void afterMethod() throws ConnectException {
	  driver.close();
	  }
	  
  

@DataProvider 

public Object[][] test1()
{
	return new Object [][] {{"u1","p1"},{"u2","p2"}};
	
	}

  @DataProvider 
  public Object [][]  dp() {
	  Object [][] dataset = new Object[4][2];
	  
	  dataset[0][0]="mngr388141";
	  dataset[0][1]="nemAhUs";
	  
	  
	  dataset[1][0]="invalidu";
	  dataset[1][1]="nemAhUs";
	  
	  dataset[2][0]="mngr388141";
	  dataset[2][1]="invalisp";
	  
	  dataset[3][0]="invalidu";
	  dataset[3][1]="invalidp";
	  
     return dataset;
    
  }
}
