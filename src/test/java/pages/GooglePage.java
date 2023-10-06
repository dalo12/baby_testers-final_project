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
	protected final int QTY_RESULTS = 11;
	protected String TAG_RESULT_IMAGE = "data-src";
	protected String XPATH_FIRST_RESULT = "//*[@id=\"kp-wp-tab-overview\"]/div[1]/div/div/div/div/div/div[1]/div/div/span/a/div/div/div/cite";
	
	
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
	
	public void clickOnResult(WebElement result) {
		result.click();
	}
	
	public WebElement getFirstWithImage() {
		WebElement resultWithImage = null;
		WebElement result;
		String XPATH = "";
		boolean found = false;
		int i = 1;
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(LIST_BOX));
		
		while(i<QTY_RESULTS && !found) {
			XPATH = "//*[@role=\"presentation\"]/div[1]/div/ul/li["+ i + "]/div/div[1]";
			result = driver.findElement(By.xpath(XPATH));
			
			if(result.getAttribute(TAG_RESULT_IMAGE) != "") {
				resultWithImage = result;
				found = true;
			}
			
			i++;
		}
		
		return resultWithImage;
	}
	
	public boolean checkFirstResultPage(String page) {
		return driver.findElement(By.xpath(XPATH_FIRST_RESULT)).getText().contains(page);
	}
}
