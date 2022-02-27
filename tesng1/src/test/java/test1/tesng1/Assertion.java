package test1.tesng1;


import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.google.common.base.Verify;

import io.github.bonigarcia.wdm.WebDriverManager;


@Test
public class Assertion {
	public static WebDriver driver;
	@Test (enabled=false)
	 public void connect() {
		WebDriverManager.edgedriver().setup();
		 driver = new EdgeDriver();
	
		driver.get("https://secure.icicidirect.com/customer/login");
	}
	
	@Test (priority=1)
	public  void assertion1() {
	SoftAssert Softassert= new SoftAssert();
	connect();
		String expectedtitle="ICICI Direct";
		
		String expectedname="Login";
		
		String actualtitle=driver.getTitle();
		Assert.assertEquals(actualtitle, expectedtitle);
		
		String actualname=driver.findElement(By.xpath("//*[@id=\"btnlogin\"]")).getAttribute("Value");
		
		Softassert.assertEquals(actualname, expectedname, "button value verified");
		System.out.println(actualname);
		Softassert.assertAll();
		//driver.close();
		}
	@Test (priority=2)
	public  void Login () {
		//connect ();
		driver.findElement(By.xpath("//*[@id=\"txtuid\"]")).sendKeys("w1221695");
		driver.findElement(By.xpath("//*[@id=\"txtPass\"]")).sendKeys("Jan2022@123");
		driver.findElement(By.xpath("//*[@id=\"txtDOB\"]")).sendKeys("13011995");
		driver.findElement(By.xpath("//*[@id=\"btnlogin\"]")).click();
		
		
	
		
		
		
	}
	
	
	
}


