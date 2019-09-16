package com.model;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Facebook_Demo 
{
	public WebDriver driver;
  @Parameters({"username1","password1"})	
  @Test
  public void loginwithvalidds(String username,String password)
  {
	  driver.findElement(By.xpath("//input[@data-testid='royal_email']")).sendKeys(username);
	  driver.findElement(By.xpath("//input[@data-testid='royal_pass']")).sendKeys(password);
	  driver.findElement(By.xpath("//input[@data-testid='royal_login_button']")).click();
	  System.out.println("Facebook page has login successfully by username and password");
	  driver.findElement(By.xpath("//li[@class='_54ni navSubmenu _6398 _64kz __MenuItem']")).click();
	  System.out.println("Facebook page has logout successfully");
  }
  
  @BeforeMethod
  public void getCookie()
  {
	  Set<Cookie> cookies=driver.manage().getCookies();
	  for(Cookie cookie:cookies)
	  {
		  System.out.println(cookie.getName());
		  System.out.println(cookie.getDomain());
		  System.out.println("cooke got successfully"); 
	  }
	  
  }

  @AfterMethod
  public void getScreenshot() throws IOException 
  {
	  File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE );
	  FileUtils.copyDirectoryToDirectory(src, new File("P:\\selenium_testing\\ParameterizationFacebook\\FacebbookScreenshot"));
	  System.out.println("Screenshot has taken successfully");
  }

  @BeforeClass
  public void maximizeBrowser() 
  {
	  driver.manage().window().maximize();
	  System.out.println("webpage has maximize successfully");
  }

  @AfterClass
  public void deleteCookies() 
  {
	  driver.manage().deleteAllCookies();
	  System.out.println("cookies has been deleted successfully");
  }
  
  @Parameters({"url"})
  @BeforeTest
  public void applicationURL(String urlname)
  {
	  driver.get(urlname);
  }

  @AfterTest
  public void afterTest()
  {
	  System.out.println("Database connection closed successfully");
  }
  @Parameters({"browser"})
  @BeforeSuite
  public void openBrowser(String browsername) 
  {
	  if(browsername.equalsIgnoreCase("Chrome"))
	  {
		  System.setProperty("webdriver.chrome.driver", "E:\\Automation\\29062019\\chromedriver_win32\\chromedriver.exe");
		  driver=new ChromeDriver();
		  System.out.println("webdriver has open successfully");
	  }
  }

  @AfterSuite
  public void afterSuite() 
  {
	  driver.close();
  }

}
