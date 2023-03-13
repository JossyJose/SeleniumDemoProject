package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import constants.Constants;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.ManageExpenses;

public class HomePageTestCases extends BaseClass {

	LoginPage loginPage;
	HomePage homePage;
	ManageExpenses manageExpenses;
	

	@Test(enabled = true)
	public void verifyUserLogout() {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		loginPage.performLogin(Constants.USERNAME, Constants.PASSWORD);
		homePage.performLogout();
		String actualText = loginPage.getSignInText();
		String expectedText = Constants.EXPECTED_LOGO_MESSAGE;
		Assert.assertEquals(actualText, expectedText, "Logout successful");
	}
	
	@Test(enabled = true)
	public void verifyHomePageURL() {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		loginPage.performLogin(Constants.USERNAME, Constants.PASSWORD);
		String actualText=homePage.getHomePageURL();
		Assert.assertEquals(actualText, Constants.HOMEPAGE_URL, "::Page URL is same as expected");	
	}
	
	@Test(enabled = true)
	public void verifyHomePageTitle() {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		loginPage.performLogin(Constants.USERNAME, Constants.PASSWORD);	
		Assert.assertEquals(homePage.getHomePageTitle(), Constants.EXPECTED_HOMEPAGE_TITLE, "::Page Title is same as expected");	
	}
}

