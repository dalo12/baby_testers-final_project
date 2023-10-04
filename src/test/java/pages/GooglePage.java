package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

public class GooglePage {
	protected WebDriver driver;
	protected Wait<WebDriver> wait;
	protected By SEARCH_BAR = By.cssSelector("[type=\"search\"]");
	protected By LIST_BOX = By.cssSelector("[role=\"listbox\"]");
	protected By LIST_RESULTS = By.cssSelector("[data-view-type=\"1\"]");
	
	public GooglePage(WebDriver driver, Wait<WebDriver> wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	public void clickSearchBar() {
		driver.findElement(SEARCH_BAR).click();
	}
	
	public void clearSearchBar() {
		driver.findElement(SEARCH_BAR).clear();
	}
	
	public List<String> getSuggestionList(String keyword) {
		
		driver.findElement(SEARCH_BAR).sendKeys(keyword);

		wait.until(ExpectedConditions.visibilityOfElementLocated(LIST_BOX));
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<String> resultList = new ArrayList<String>();
		for(WebElement result : driver.findElements(LIST_RESULTS)) {
			resultList.add(result.getText());
		}
		resultList.remove("");
		
		return resultList;
	}
}
