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
		
	}
	public void signInForm(String email, String password) {
		mainNavigation.clickOnSignInButton();
		signInPage.insertEmailForSignIn(email);
		signInPage.insertPassword(password);
		signInPage.clickOnSignInButton();
		
	}
	
	
	//Verify that only one radio button can be checked at the same time
	@Test(priority = 4)
	public void checkRadioButtons() {
		String email = excelReader.getStringData("TSu3", 8, 3);
		String password = excelReader.getStringData("TSu3", 9, 3);
		signInForm(email,password);
		myAccount.clickOnPersonalInformation();
		myAccount.checkMrRadioButton();
		myAccount.checkMrsRadioButton();
		
		assertEquals(myAccount.isMrChecked(), false);
		
	}
	
	
	@AfterMethod
	public void deleteCookies() {
		
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}

}
