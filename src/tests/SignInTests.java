package tests;

import static org.testng.Assert.assertEquals;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignInTests extends BaseTests {
	
	@BeforeMethod
	public void navigateToPage() {
		driver.navigate().to(homeUrl);
		driver.manage().window().maximize();
	}
	
	//insert email into Email field and click on Register button 
	public void fillInEmailAndSubmit(String sheetName, int rowNum, int colNum) {
		mainNavigation.clickOnSignInButton();
		signInPage.insertEmail(excelReader.getStringData(sheetName, rowNum, colNum));
		signInPage.clickOnCreateAnAccount();
	}
	//sign in form
		public void signInForm(String email, String password) {
			mainNavigation.clickOnSignInButton();
			signInPage.insertEmailForSignIn(email);
			signInPage.insertPassword(password);
			signInPage.clickOnSignInButton();
			
		}
		
	@Test(priority = 0)
	public void createAccountAndRegister() {				
		fillInEmailAndSubmit("TSu1", 8, 3);
				
		personalInfo.insertFirstName(excelReader.getStringData("TSu1", 10, 3));
		personalInfo.insertLastName(excelReader.getStringData("TSu1", 11, 3));
		personalInfo.insertPassword(excelReader.getStringData("TSu1", 12, 3));
		personalInfo.insertAddress(excelReader.getStringData("TSu1", 13, 3));
		personalInfo.insertCity(excelReader.getStringData("TSu1", 14, 3));
		personalInfo.selectState(excelReader.getStringData("TSu1", 15, 3));
		personalInfo.insertPostalCode(String.valueOf(excelReader.getIntegerData("TSu1", 16, 3)));
		personalInfo.insertMobilePhone(String.valueOf(excelReader.getIntegerData("TSu1", 17, 3)));
		personalInfo.insertAddressAlias(excelReader.getStringData("TSu1", 18, 3));
		personalInfo.clickOnRegisterButton();
		
		assertEquals(mainNavigation.isSignOutDisplayed(), true);
		
	}
	@Test(priority = 1)
	public void createAccountWithAlreadyRegisteredEmail() {
		fillInEmailAndSubmit("TSu1", 30 , 3);
		wait.until(ExpectedConditions.visibilityOf(signInPage.getCreateAcountErrorAlert()));
		assertEquals(signInPage.isErrorAlertDisplayed(), true);
	}
	@Test(priority = 3)
	public void createAccountWithInvalidEmail() {
		fillInEmailAndSubmit("TSu1", 42 , 3);
		
		assertEquals(signInPage.isInvalidEmailAlertDisplayed(), true);
	}
	
	@Test(priority = 5)
	public void signInWithValidCredentials() {
		String email = excelReader.getStringData("TSu2", 7, 3);
		String password = excelReader.getStringData("TSu2", 8, 3);
		signInForm(email, password);
		wait.until(ExpectedConditions.visibilityOf(mainNavigation.getSignOutButton()));
		assertEquals(mainNavigation.isSignOutDisplayed(), true);

	}
	@Test(priority = 6)
	public void signInWithInvalidEmail() {
		String email = excelReader.getStringData("TSu2", 19, 3);
		String password = excelReader.getStringData("TSu2", 20, 3);
		signInForm(email, password);
		String expected = excelReader.getStringData("TSu2", 23, 3);
		assertEquals(signInPage.emailSignInAlert(), expected);

	}
	@Test(priority = 7)
	public void signInWithInvalidPassword() {
		String email = excelReader.getStringData("TSu2", 31, 3);
		String password = excelReader.getStringData("TSu2", 32, 3);
		String expected = excelReader.getStringData("TSu2", 35, 3);

		signInForm(email, password);
		assertEquals(signInPage.passwordAlert(), expected);

	}
	
	@AfterMethod
	public void deleteCookies() {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}

}
