package com.model.task;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class DataDrivenFB 
{
  public WebDriver driver;
  @Test(dataProvider ="getdata")
  public void loginwithValidds(String firstname, String surname,String mail_id,String C_mail_id,String pass,String day,String month,String year,String gender) throws InterruptedException 
  {
	 driver.findElement(By.name("firstname")).sendKeys(firstname);
	 driver.findElement(By.id("u_0_n")).sendKeys(surname);;
	 driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys(mail_id);
	 driver.findElement(By.name("reg_email_confirmation__")).sendKeys(C_mail_id);
	 driver.findElement(By.cssSelector("input[name='reg_passwd__']")).sendKeys(pass);
	 
	 WebElement obj=driver.findElement(By.id("day"));
     Select sel=new Select(obj);
     sel.selectByValue(day);
     
     
     WebElement month1= driver.findElement(By.id("month"));  
     Select sel1=new Select(month1);
     sel1.selectByValue(month);
     
     WebElement year1=driver.findElement(By.id("year"));
     Select sel2=new Select(year1);
     sel2.selectByValue(year);
     
     driver.findElement(By.xpath("//input[@type='radio']")).click();
     
     driver.findElement(By.xpath("//button[@type='submit']")).click();
     //Thread.sleep(2000);
     //driver.switchTo().alert().accept();
     /*driver.findElement(By.className("_w0d _w0d")).click();
     driver.findElement(By.className("_42ft _4jy0 layerConfirm uiOverlayButton _4jy3 _4jy1 selected _51sy")).click();
     driver.findElement(By.linkText("Log Out")).click();
     driver.findElement(By.className("_42ft _4jy0 layerConfirm uiOverlayButton _4jy3 _4jy1 selected _51sy"));*/
     
     driver.navigate().to("https://www.facebook.com/");
     
     //driver.findElement(By.cssSelector("a[title='Go to Facebook home']"));
  }
  @BeforeMethod
  public void getAllCookies() 
  {
	  System.out.println("In getAllCookies under BeforeMethod");
	  Set<Cookie> cookies=driver.manage().getCookies();
	  for(Cookie cookie:cookies)
	  {
		  System.out.println(cookie.getName());
	  }
  }

  @AfterMethod
  public void captureScreenshot() throws IOException 
  {
	  System.out.println("In captureScreenshot method under AfterMethod");
	  File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFileToDirectory(src, new File("E:\\selnium\\TestNG_DataDriven_Testing\\FB_sc2\\"));
	  System.out.println("Screenshot is captured successfully");
  }


  @DataProvider
  public Object[][] getdata() 
  {
	  System.out.println("Eclipse data drivern in git hub ");
	  
	  Object[][] data=new Object[10][9];
	  data[0][0]="KamalllJan";
	  data[0][1]="kanhee";

	  data[0][2]="sandip_agale@yahoo.co.in";
	  data[0][3]="sandip_agale@yahoo.co.in";
	  data[0][4]="Rupali@123456";

      data[0][5]="1";
      data[0][6]="1";
      data[0][7]="2001";
      data[0][8]="Female";
      
      
      data[1][0]="SonalllRani";
	  data[1][1]="Zintaa";

	  data[1][2]="rupalikhule92@rediffmail.com";
	  data[1][3]="rupalikhule92@rediffmail.com";
	  data[1][4]="Rupali@123456";

      data[1][5]="2";
      data[1][6]="2";
      data[1][7]="2002";
      data[1][8]="Female";
      
      
      
      data[2][0]="RekhaaRani";
	  data[2][1]="Pawsee";

	  data[2][2]="sandipagale03@gmail.com";
	  data[2][3]="sandipagale03@gmail.com";
	  data[2][4]="Rupali@1234";

      data[2][5]="3";
      data[2][6]="3";
      data[2][7]="2003";
      data[2][8]="Male";
      
      
      data[3][0]="SandipRaje";
	  data[3][1]="khulee";

	  data[3][2]="rupalideveloper16@gmail.com";
	  data[3][3]="rupalideveloper16@gmail.com";
	  data[3][4]="Rupali@123434";

      data[3][5]="4";
      data[3][6]="4";
      data[3][7]="2004";
      data[3][8]="Female";
      
      
      data[4][0]="PankajjRaja";
	  data[4][1]="dubee";

	  data[4][2]="sandipagale03@gmail.com";
	  data[4][3]="sandipagale03@gmail.com";
	  data[4][4]="Rupali@123456";
	  
      data[4][5]="5";
      data[4][6]="5";
      data[4][7]="2005";
      data[4][8]="Female";
      
      
      
      data[5][0]="RamojiiiRana";
	  data[5][1]="Maharajaa";

	  data[5][2]="sandipagale03@gmail.com";
	  data[5][3]="sandipagale03@gmail.com";
	  data[5][4]="Rupali@12345";

      data[5][5]="6";
      data[5][6]="6";
      data[5][7]="2006";
      data[5][8]="Female";
      
      
      data[6][0]="Ujwalaa";
	  data[6][1]="Agalee";

	  data[6][2]="rupalikhulee92@rediffmail.com";
	  data[6][3]="rupalikhulee92@rediffmail.com";
	  data[6][4]="Rupali@1234";

      data[6][5]="7";
      data[6][6]="7";
      data[6][7]="2007";
      data[6][8]="Male";
      
      
      
      
      data[7][0]="Shardaa";
	  data[7][1]="bendree";

	  data[7][2]="rupalideveloperr16@gmail.com";
	  data[7][3]="rupalideveloperr16@gmail.com";
	  data[7][4]="Rupali@1234";

      data[7][5]="8";
      data[7][6]="8";
      data[7][7]="2008";
      data[7][8]="Male";
      
      
      data[8][0]="Pramilaa";
	  data[8][1]="Khulee";

	  data[8][2]="sandip_agale@yahoo.co.in";
	  data[8][3]="sandip_agale@yahoo.co.in";
	  data[8][4]="Rupali@123";

      data[8][5]="9";
      data[8][6]="9";
      data[8][7]="2009";
      data[8][8]="Female";
      
      data[9][0]="Kanchanna";
	  data[9][1]="varpeee";

	  data[9][2]="sandip_agale@yahoo.co.in";
	  data[9][3]="sandip_agale@yahoo.co.in";
	  data[9][4]="Rupali@12891";

      data[9][5]="10";
      data[9][6]="10";
      data[9][7]="2010";
      data[9][8]="Female";

      return data;
  }
  @BeforeClass
  public void maximizeBrowser() 
  {
	  System.out.println("In maximizeBrowser method under BeforeClass");
	  driver.manage().window().maximize();
	  
  }

  @AfterClass
  public void deleteAllCookies() 
  {
	  System.out.println("In deleteAllCookies method under AfterClass");
	  driver.manage().deleteAllCookies();
  }
  
  @BeforeTest
  public void enterApplicationURL() 
  {
	  System.out.println("In enterApplicationURL method under BeforeTest");
	  driver.get("https://www.facebook.com/");
	  System.out.println("Git hub changesurl  open sucessfully");
  }

  @AfterTest
  public void dbConnectionClosed() 
  {
	  System.out.println("In dbConnectionClosed under AfterTest");
	  
  }

  @BeforeSuite
  public void openBrowser() 
  {
	  System.out.println("In openBrowser method under BeforeSuite");
	  System.setProperty("webdriver.chrome.driver", "E:\\soft\\chromedriver.exe");
      driver= new ChromeDriver();
      System.out.println("Chrome browser is opened successfully");

  }

  @AfterSuite
  public void closeBrowser() 
  {
	  System.out.println("In closeBrowser method under AfterSuite");
	  driver.close();
	  System.out.println("In git hub changes closeBrowser method under AfterSuite");
	  System.out.println("In opensBrowser method under AfterSuite");
	  
  }
}
/*
 Output
 [TestNG] Running:
  C:\Users\Sandeep\AppData\Local\Temp\testng-eclipse--1364099194\testng-customsuite.xml

In openBrowser method under BeforeSuite
Starting ChromeDriver 74.0.3729.6 (255758eccf3d244491b8a1317aa76e1ce10d57e9-refs/branch-heads/3729@{#29}) on port 42481
Only local connections are allowed.
Please protect ports used by ChromeDriver and related test frameworks to prevent access by malicious code.
Jun 15, 2019 11:18:06 PM org.openqa.selenium.remote.ProtocolHandshake createSession
INFO: Detected dialect: OSS
Chrome browser is opened successfully
In enterApplicationURL method under BeforeTest
In maximizeBrowser method under BeforeClass
In getAllCookies under BeforeMethod
datr
fr
wd
sb
In captureScreenshot method under AfterMethod
Screenshot is captured successfully
In getAllCookies under BeforeMethod
datr
fr
wd
sb
In captureScreenshot method under AfterMethod
Screenshot is captured successfully
In getAllCookies under BeforeMethod
datr
fr
wd
sb
In captureScreenshot method under AfterMethod
Screenshot is captured successfully
In getAllCookies under BeforeMethod
datr
fr
wd
sb
In captureScreenshot method under AfterMethod
Screenshot is captured successfully
In getAllCookies under BeforeMethod
datr
fr
wd
sb
In captureScreenshot method under AfterMethod
Screenshot is captured successfully
In getAllCookies under BeforeMethod
datr
fr
wd
sb
In captureScreenshot method under AfterMethod
Screenshot is captured successfully
In getAllCookies under BeforeMethod
datr
fr
wd
sb
In captureScreenshot method under AfterMethod
Screenshot is captured successfully
In getAllCookies under BeforeMethod
datr
av
fr
wd
sb
In captureScreenshot method under AfterMethod
Screenshot is captured successfully
In getAllCookies under BeforeMethod
datr
av
fr
wd
sb
In captureScreenshot method under AfterMethod
Screenshot is captured successfully
In getAllCookies under BeforeMethod
datr
av
fr
wd
sb
In captureScreenshot method under AfterMethod
Screenshot is captured successfully
In deleteAllCookies method under AfterClass
In dbConnectionClosed under AfterTest
PASSED: loginwithValidds("KamalllJan", "kanhee", "sandip_agale@yahoo.co.in", "sandip_agale@yahoo.co.in", "Rupali@123456", "1", "1", "2001", "Female")
PASSED: loginwithValidds("SonalllRani", "Zintaa", "rupalikhule92@rediffmail.com", "rupalikhule92@rediffmail.com", "Rupali@123456", "2", "2", "2002", "Female")
PASSED: loginwithValidds("RekhaaRani", "Pawsee", "sandipagale03@gmail.com", "sandipagale03@gmail.com", "Rupali@1234", "3", "3", "2003", "Male")
PASSED: loginwithValidds("SandipRaje", "khulee", "rupalideveloper16@gmail.com", "rupalideveloper16@gmail.com", "Rupali@123434", "4", "4", "2004", "Female")
PASSED: loginwithValidds("PankajjRaja", "dubee", "sandipagale03@gmail.com", "sandipagale03@gmail.com", "Rupali@123456", "5", "5", "2005", "Female")
PASSED: loginwithValidds("RamojiiiRana", "Maharajaa", "sandipagale03@gmail.com", "sandipagale03@gmail.com", "Rupali@12345", "6", "6", "2006", "Female")
PASSED: loginwithValidds("Ujwalaa", "Agalee", "rupalikhulee92@rediffmail.com", "rupalikhulee92@rediffmail.com", "Rupali@1234", "7", "7", "2007", "Male")
PASSED: loginwithValidds("Shardaa", "bendree", "rupalideveloperr16@gmail.com", "rupalideveloperr16@gmail.com", "Rupali@1234", "8", "8", "2008", "Male")
PASSED: loginwithValidds("Pramilaa", "Khulee", "sandip_agale@yahoo.co.in", "sandip_agale@yahoo.co.in", "Rupali@123", "9", "9", "2009", "Female")
PASSED: loginwithValidds("Kanchanna", "varpeee", "sandip_agale@yahoo.co.in", "sandip_agale@yahoo.co.in", "Rupali@12891", "10", "10", "2010", "Female")

===============================================
    Default test
    Tests run: 10, Failures: 0, Skips: 0
===============================================

In closeBrowser method under AfterSuite

===============================================
Default suite
Total tests run: 10, Failures: 0, Skips: 0
===============================================

[TestNG] Time taken by org.testng.reporters.SuiteHTMLReporter@626b2d4a: 125 ms
[TestNG] Time taken by org.testng.reporters.XMLReporter@53bd815b: 106 ms
[TestNG] Time taken by [FailedReporter passed=0 failed=0 skipped=0]: 15 ms
[TestNG] Time taken by org.testng.reporters.EmailableReporter2@41a4555e: 47 ms
[TestNG] Time taken by org.testng.reporters.jq.Main@379619aa: 177 ms
[TestNG] Time taken by org.testng.reporters.JUnitReportReporter@71dac704: 16 ms
*/
