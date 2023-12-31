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
	
	protected By BUTTON_PURCHASE = By.cssSelector("[onclick=\"purchaseOrder()\"]");
	
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
		wait.until(ExpectedConditions.visibilityOfElementLocated(FORM_NAME));
		driver.findElement(FORM_NAME).sendKeys(name);
	}
	
	public void fillCountry(String country) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(FORM_COUNTRY));
		driver.findElement(FORM_COUNTRY).sendKeys(country);
	}
	
	public void fillCity(String city) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(FORM_CITY));
		driver.findElement(FORM_CITY).sendKeys(city);
	}
	
	public void fillCreditCard(String creditCard) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(FORM_CARD));
		driver.findElement(FORM_CARD).sendKeys(creditCard);
	}
	
	public void fillMonth(String month) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(FORM_MONTH));
		driver.findElement(FORM_MONTH).sendKeys(month);
	}
	
	public void fillYear(String year) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(FORM_YEAR));
		driver.findElement(FORM_YEAR).sendKeys(year);
	}
	
	public void clickPurchase() {
		driver.findElement(BUTTON_PURCHASE).click();
	}
	
	public void checkConfirmationMessage() {
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(CONFIRMATION_MESSAGE)));
		Assert.assertTrue(driver.findElement(CONFIRMATION_MESSAGE).isDisplayed());
	}
}
