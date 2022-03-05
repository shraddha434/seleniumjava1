import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;





public class Login {
	
	public static WebDriver driver;
	
	 
	 
	@Test (dataProvider="Add__Deatils")
		
  public void Login_details(String name, String Organization,String MAILid) {
	 
	  driver.findElement(By.xpath("//div[@name='language']")).click();
	  driver.findElement(By.xpath("//div[@class='ng-binding ng-scope'][text()=\"English\"]")).click();
	  driver.findElement(By.xpath("//input[@placeholder='Full Name']")).sendKeys(name);
	  driver.findElement(By.xpath("//input[@placeholder='Organization Name']")).sendKeys(Organization);
	  driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys(MAILid);
	  driver.findElement(By.xpath("//span[@class='black-color ng-binding'] ")).click();
	  driver.findElement(By.xpath("//button[text()=\"Get Started\"]")).click();
	  
	  try {
	 driver.findElement(By.xpath("//span[text()=' A welcome email has been sent. Please check your email. ']")).isDisplayed();
				System.out.println("Mail sent");
		  
	  } catch ( Exception e) {
		  System.out.println("mail sent fail");
		  
	  }
	 
		  
  }
  @SuppressWarnings("deprecation")
@BeforeMethod
  public void beforeMethod() {
	  WebDriverManager.chromedriver().setup();
	  driver= new ChromeDriver();
	
	  driver.get("https://jt-dev.azurewebsites.net/#/SignUp");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }


  @DataProvider
  public Object[][] Add__Deatils() {
    return new Object[][]{
    	{"Shraddha","QA","shraddhaw4@gmail.com"},
     
    };
  }


}
