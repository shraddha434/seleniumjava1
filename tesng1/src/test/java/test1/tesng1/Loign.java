package test1.tesng1;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Loign {

	@BeforeTest
	
	@BeforeMethod
	public void connectdb(){
		
	System.out.println("connect to db");
	}
	@AfterMethod
	public void disconnectdb()
	
	{
		System.out.println("disconnect to db");
	}
	@Test
	public void Logintest () {
		System.out.println("login test");
	}
	@Test(priority=1, description="This is logout description")
	public void logout() {
		System.out.println("logout test");
	}
}
