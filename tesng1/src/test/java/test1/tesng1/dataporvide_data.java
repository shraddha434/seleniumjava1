package test1.tesng1;

import org.testng.annotations.Test;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class dataporvide_data {
  @Test(dataProvider = "sh")
  public void f(String n, String s) {
	   System.out.println(n+"========+"+s);
	  
  }
  @Test(dataProvider = "sh")
  public void f2(String n, String s,String sts) {
	   System.out.println(n+"========+"+s+"========="+sts);
	  
  }


  @DataProvider (name="sh")
  public Object[][] dp(Method m) {
	  
	  Object [][] test = null;
	  
	  
	  if(m.getName().equalsIgnoreCase("f"))
	  {
		  test= new Object[][]
		  
		  { {"u1","p1"} ,
			  {"u2","p2"}};
			  
	  }
	  else if (m.getName().equalsIgnoreCase("f2"))
	  {
		  test= new Object[][]
				  
		  { {"u1","pas","fail"} ,{"u1","pas","pass"}};
		  
	  }
	 
    return test;
    		
    		
  }
}
