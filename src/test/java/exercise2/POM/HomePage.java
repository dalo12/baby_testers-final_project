package exercise2.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

public class HomePage {
	protected WebDriver driver;
	protected Wait<WebDriver> wait;
	
	protected By BUTTON_ADD_TO_CART = By.linkText("Add to cart");
	protected By BUTTON_PLACE_ORDER = By.xpath("//*[@id=\"page-wrapper\"]/div/div[2]/button");
	
	
	public HomePage(WebDriver driver, Wait<WebDriver> wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	public void clickIdProduct(int id) {
		String CSS_PRODUCT = "[href=\"prod.html?idp_="+ id +"\"]";
		By product = By.cssSelector(CSS_PRODUCT);
		wait.until(ExpectedConditions.visibilityOfElementLocated(product));
		driver.findElement(product).click();
	}	

	public void clickAddToCart() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(BUTTON_ADD_TO_CART));
		driver.findElement(BUTTON_ADD_TO_CART).click();
	}
	
	public void acceptAlert() {
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
	}
	
	public void goToHome() {
		driver.navigate().to("https://www.demoblaze.com/index.html");
	}
	
	public void goToCart() {
		driver.navigate().to("https://www.demoblaze.com/cart.html");
	}
	
	public void clickPlaceOrder() {
		driver.findElement(BUTTON_PLACE_ORDER).click();
	}
	
}
