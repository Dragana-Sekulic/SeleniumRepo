package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPage {

	WebDriver driver;
	WebElement personalInfoTab;
	WebElement myAddressesTab;
	WebElement mrRadioButton;
	WebElement mrsRadioButton;
	WebElement curentPassswordInputField;
	WebElement newPasswordInputField;
	WebElement confirmationInputField;
	WebElement saveButton;
	WebElement updateAddressButton;
	WebElement newAddressCheck;
	WebElement newCityCheck;
	WebElement newStateCheck;
	WebElement newPostalCodeCheck;
	WebElement addNewAddressButton;

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

	public WebElement getMyAddressesTab() {
		return driver.findElement(By.linkText("My addresses"));
	}

	public WebElement getUpdateAddressButton() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/div/div/ul/li[9]/a[1]"));
	}

	public WebElement getNewAddressCheck() {
		return driver.findElement(By.className("address_address1"));
	}

	public WebElement getNewCityCheck() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/div/div/ul/li[5]/span[1]"));
	}

	public WebElement getNewStateCheck() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/div/div/ul/li[5]/span[2]"));
	}

	public WebElement getNewPostalCodeCheck() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/div/div/ul/li[5]/span[3]"));
	}
	

	public WebElement getAddNewAddressButton() {
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[2]/a/span"));
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

	public void clickOnMyAddressesTab() {
		this.getMyAddressesTab().click();
	}

	public void clickOnUpdateAddressButton() {
		this.getUpdateAddressButton().click();
	}

	public String checkNewAddress() {
		return this.getNewAddressCheck().getText();

	}

	public String checkNewCity() {
		return this.getNewCityCheck().getText();
	}
	
	public String checkNewState() {
		return this.getNewStateCheck().getText();
	}
	
	public String checkNewPostalCode() {
		return this.getNewPostalCodeCheck().getText();
	}
	
	public void clickOnAddNewAddress() {
		this.getAddNewAddressButton().click();
		
	}
}
