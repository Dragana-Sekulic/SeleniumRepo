package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShopPage {
	
	WebDriver driver;
	WebElement searchButton;

	public ShopPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebElement getSearchButton() {
		return driver.findElement(By.name("submit_search"));
	}
	
	
	
	

}
