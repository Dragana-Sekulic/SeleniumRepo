package tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pages.MainNavigation;
import pages.PersonalInformationPage;
import pages.SignInPage;

public class BaseTests {

	WebDriver driver;
	WebDriverWait wait;
	ExcelReader excelReader;
	String homeUrl;
	SignInPage signInPage;
	MainNavigation mainNavigation;
	PersonalInformationPage personalInfo;

	@BeforeClass
	public void setUp() throws IOException {
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 10);
		excelReader = new ExcelReader("data/AutomationTestPlan.xlsx");
		homeUrl = excelReader.getStringData("TSu1", 4 , 3);
		signInPage = new SignInPage(driver);
		mainNavigation = new MainNavigation(driver);
		personalInfo = new PersonalInformationPage(driver);

	}

	@AfterClass
	public void closeDriver() {
		driver.close();
	}
}