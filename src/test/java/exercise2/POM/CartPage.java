package exercise2.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

public class CartPage {
	protected WebDriver driver;
	protected Wait<WebDriver> wait;
	
	protected By CONFIRMATION_MESSAGE = By.xpath("/html/body/div[10]");
	
	protected By BUTTON_PURCHASE = By.xpath("//*[@id=\"orderModal\"]/div/div/div[3]/button[2]");
	
	protected By FORM_NAME = By.id("name");
	protected By FORM_COUNTRY = By.id("country");
	protected By FORM_CITY = By.id("city");
	protected By FORM_CARD = By.id("card");
	protected By FORM_MONTH = By.id("month");
	protected By FORM_YEAR = By.id("year");
	
	public CartPage(WebDriver driver, Wait<WebDriver> wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	public void fillName(String name) {
		driver.findElement(FORM_NAME).sendKeys(name);
	}
	
	public void fillCountry(String country) {
		driver.findElement(FORM_COUNTRY).sendKeys(country);
	}
	
	public void fillCity(String city) {
		driver.findElement(FORM_CITY).sendKeys(city);
	}
	
	public void fillCreditCard(String creditCard) {
		driver.findElement(FORM_CARD).sendKeys(creditCard);
	}
	
	public void fillMonth(String month) {
		driver.findElement(FORM_MONTH).sendKeys(month);
	}
	
	public void fillYear(String year) {
		driver.findElement(FORM_MONTH).sendKeys(year);
	}
	
	public void checkConfirmationMessage() {
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(CONFIRMATION_MESSAGE)));
		Assert.assertTrue(driver.findElement(CONFIRMATION_MESSAGE).isDisplayed());
	}
}
