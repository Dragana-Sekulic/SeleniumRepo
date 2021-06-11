package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainNavigation {
	
	WebDriver driver;
	WebElement signInButton;
	WebElement signOutButton;


	public MainNavigation(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public WebElement getSignInButton() {
		return driver.findElement(By.className("login"));
	}
	
	public WebElement getSignOutButton() {
		return driver.findElement(By.className("logout"));
	}

	public void clickOnSignInButton() {
		this.getSignInButton().click();
	}
	
	public boolean isSignOutDisplayed() {
		return this.getSignOutButton().isDisplayed();
	}

}
