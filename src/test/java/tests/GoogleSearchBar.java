package tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class GoogleSearchBar {
	protected static final String URL = "https://www.google.com";
	protected WebDriver driver;
	
  @Test
  public void f() {
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");  
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get(URL);
  }

  @AfterTest
  public void afterTest() {
  }

}
