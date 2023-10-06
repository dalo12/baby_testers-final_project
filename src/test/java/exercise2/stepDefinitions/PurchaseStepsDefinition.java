package exercise2.stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import exercise2.POM.CartPage;
import exercise2.POM.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class PurchaseStepsDefinition {
	protected HomePage homePage;
	protected CartPage cartPage;
	protected WebDriver driver;
	protected Wait<WebDriver> wait;
	protected String URL = "https://www.demoblaze.com/index.html";
	
  @Given("^I have the home page opened$")
  public void i_have_the_home_page_opened(){
	  System.setProperty("webdriver.chrome.driver", "./src/main/resources/resources/chromedriver/chromedriver.exe");  
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get(URL);
		
	  wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  
	  homePage = new HomePage(driver, wait);
  }
  
  @Given("^I add to products to the cart$")
  public void i_add_to_products_to_the_cart() {
	  homePage.clickIdProduct(2);
	  homePage.clickAddToCart();
	  homePage.acceptAlert();
	  
	  homePage.goToHome();
	  
	  homePage.clickIdProduct(5);
	  homePage.clickAddToCart();
	  homePage.acceptAlert();
  }
  
  @Given("^I go to the Cart page$")
  public void i_go_to_the_cart_page() {
	  homePage.goToCart();
	  cartPage = new CartPage(driver, wait);
  }
  
  @When("^I click on Place Order$")
  public void i_click_on_place_order(){
	  homePage.clickPlaceOrder();
  }
  
  @When("^fill the form$")
  public void fill_the_form(){
	  cartPage.fillName("Baby Tester");
	  cartPage.fillCity("La Boca");
	  cartPage.fillCountry("Argentina");
	  cartPage.fillCreditCard("4012888888881881");
	  cartPage.fillMonth("12");
	  cartPage.fillYear("2023");
  }

  @Then("^there is a confirmation message$")
  public void there_is_a_confirmation_message(){
	  cartPage.checkConfirmationMessage();
  }

}
