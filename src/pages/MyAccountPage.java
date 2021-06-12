package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPage {

	WebDriver driver;
	WebElement personalInfoTab;
	WebElement mrRadioButton;
	WebElement mrsRadioButton;
	WebElement curentPassswordInputField;
	WebElement newPasswordInputField;
	WebElement confirmationInputField;
	WebElement saveButton;

	public MyAccountPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebElement getPersonalInfoTab() {
		return driver.findElement(By.linkText("MY PERSONAL INFORMATION"));
	}

	public WebElement getMrRadioButton() {
		return driver.findElement(By.id("id_gender1"));
	}

	public WebElement getMrsRadioButton() {
		return driver.findElement(By.id("id_gender2"));
	}

	public WebElement getCurentPassswordInputField() {
		return driver.findElement(By.id("old_passwd"));
	}

	public WebElement getNewPasswordInputField() {
		return driver.findElement(By.id("passwd"));
	}

	public WebElement getConfirmationInputField() {
		return driver.findElement(By.id("confirmation"));
	}
	

	public WebElement getSaveButton() {
		return driver.findElement(By.name("submitIdentity"));
	}

	public void clickOnPersonalInformation() {
		this.getPersonalInfoTab().click();
	}

	public void checkMrRadioButton() {
		this.getMrRadioButton().click();
	}

	public void checkMrsRadioButton() {
		this.getMrsRadioButton().click();
	}

	public boolean isMrChecked() {
		return this.getMrRadioButton().isSelected();

	}

	public boolean isMrsChecked() {
		return this.getMrsRadioButton().isSelected();

	}

	public void insertCurrentPassword(String password) {
		this.getCurentPassswordInputField().clear();
		this.getCurentPassswordInputField().sendKeys(password);

	}

	public void insertNewPassword(String password) {
		this.getNewPasswordInputField().clear();
		this.getNewPasswordInputField().sendKeys(password);

	}

	public void confirmNewPassword(String password) {
		this.getConfirmationInputField().clear();
		this.getConfirmationInputField().sendKeys(password);

	}
	
	public void clickOnSaveButton() {
		this.getSaveButton().click();
		
	}
}
