package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyWishListsTests extends BaseTests {
	
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
	
	@Test(priority = 0)
	public void createWishList() {
		String wishListName = excelReader.getStringData("TSu6", 8, 3);
		myAccount.clickOnMyWishLists();
		wishList.insertNameOfWishlist(wishListName);
		wishList.clickOnSaveWishList();
		
		assertEquals(wishList.textWishListName(), wishListName);
	}
	
	
	
	@AfterMethod
	public void deleteCookies() {
		
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}

}
