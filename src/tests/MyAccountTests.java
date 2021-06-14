package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyAccountTests extends BaseTests {
	
	@BeforeMethod
	public void navigateToPage() {
		driver.navigate().to(homeUrl);
		driver.manage().window().maximize();
		signInForm();
		
	}
	public void signInForm() {
		mainNavigation.clickOnSignInButton();
		signInPage.insertEmailForSignIn(excelReader.getStringData("TSu2", 8, 3));
		signInPage.insertPassword(excelReader.getStringData("TSu2", 9, 3));
		signInPage.clickOnSignInButton();
		
	}	
	
	public void addressForm(String newAddress, String newCity,String newState, String newPostalCode) {
		personalInfo.insertAddress(newAddress);
		personalInfo.insertCity(newCity);
		personalInfo.selectState(newState);
		personalInfo.insertPostalCode(newPostalCode);
	}
	//Verify that only one radio button can be checked at the same time
	@Test(priority = 1)
	public void checkRadioButtons() {
		
		myAccount.clickOnPersonalInformation();
		myAccount.checkMrRadioButton();
		myAccount.checkMrsRadioButton();
		
		assertEquals(myAccount.isMrChecked(), false);
		
	}
	@Test(priority = 3)
	public void updateAddress() {
		String newAddress = excelReader.getStringData("TSu5", 11, 3);
		String newCity = excelReader.getStringData("TSu5", 13, 3);
		String newState = excelReader.getStringData("TSu5", 15, 3);
		String newPostalCode = String.valueOf(excelReader.getIntegerData("TSu5", 17, 3));
		
		myAccount.clickOnMyAddressesTab();
		myAccount.clickOnUpdateAddressButton();

		addressForm(newAddress, newCity, newState, newPostalCode);
		personalInfo.clickOnSaveAddressUpdateButton();
		
		assertEquals(myAccount.checkNewAddress(), newAddress, "New address isn't saved.");
		assertEquals(myAccount.checkNewCity(), newCity  + ",", "New city isn't saved.");
		assertEquals(myAccount.checkNewState(), newState, "New state isn't saved.");
		assertEquals(myAccount.checkNewPostalCode(), newPostalCode, "New postal code isn't saved.");
		
	}
	@Test
	public void addNewAddress() {
		String newAddress = excelReader.getStringData("TSu5", 31, 3);
		String newCity = excelReader.getStringData("TSu5", 32, 3);
		String newState = excelReader.getStringData("TSu5", 33, 3);
		String newPostalCode = String.valueOf(excelReader.getIntegerData("TSu5", 34, 3));
		String newMobilePhone = String.valueOf(excelReader.getIntegerData("TSu5", 35, 3));
		String newAlias = excelReader.getStringData("TSu5", 36, 3);
		myAccount.clickOnMyAddressesTab();
		myAccount.clickOnAddNewAddress();
		addressForm(newAddress, newCity, newState, newPostalCode);
		personalInfo.insertMobilePhone(newMobilePhone);
		personalInfo.insertAddressAlias(newAlias);
		myAccount.clickOnSaveButton();
		
		
		
	}
	
	
	@AfterMethod
	public void deleteCookies() {
		
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}

}
