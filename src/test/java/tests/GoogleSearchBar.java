package tests;

import org.testng.annotations.Test;

import helpers.GoogleHelper;
import helpers.GoogleHelperImpl;
import pages.GooglePage;

import org.testng.annotations.BeforeTest;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class GoogleSearchBar {
	protected static final String URL = "https://www.google.com";
	protected WebDriver driver;
	protected Wait<WebDriver> wait;
	protected GooglePage googlePage;
	protected GoogleHelper googleHelper;
	
  @Test
  public void f() {
	  List<String> resultListAuto = googlePage.getSuggestionList("auto"); 
	  
	  googlePage.clearSearchBar();
	  List<String> resultListAutomation = googlePage.getSuggestionList("automation");
	  
	  googleHelper.printResults(resultListAuto, "AUTO");
	  googleHelper.printResults(resultListAutomation, "AUTOMATION");
	  
	  getAnswerCoincidence(googleHelper.checkCoincidences(resultListAuto, resultListAutomation));
	  googlePage.clickOnResult(googlePage.getFirstWithImage());
	  
  }
  
  protected void getAnswerCoincidence(boolean condition) {
	  String coincidence = "There is no coincidence between lists";
	  
	  if(condition) {
		  coincidence = "There is coincidence between lists";
	  }
	  
	  System.out.println(coincidence);
  }
  
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "./src/main/resources/resources/chromedriver/chromedriver.exe");  
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get(URL);
	  
	  wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  
	  googlePage = new GooglePage(driver, wait);
	  googleHelper = new GoogleHelperImpl();
  }

  @AfterTest
  public void afterTest() {
  }

}
