package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyWishListPage {
	
	WebDriver driver;
	WebElement wishListNameInputField;
	WebElement wishListNameInTable;
	WebElement saveWishListButton;
	WebElement wishListTable;

	public MyWishListPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	

	public WebElement getWishListNameInputField() {
		return driver.findElement(By.id("name"));
	}
	public WebElement getWishListNameInTable() {
		return driver.findElement(By.xpath("//*[@id=\"wishlist_35352\"]/td[1]/a"));
	}
	public WebElement getSaveWishListButton() {
		return driver.findElement(By.id("submitWishlist"));
	}
	
	public WebElement getWishListTable() {
		return driver.findElement(By.tagName("table"));
	}


	public void insertNameOfWishlist(String name) {
		this.getWishListNameInputField().sendKeys(name);
	}
	
	public String textWishListName() {
		return this.getWishListNameInTable().getText();
		
	}
	
	public void clickOnSaveWishList() {
		this.getSaveWishListButton().click();
		
	}

}
