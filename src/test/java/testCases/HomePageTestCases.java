package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.ManageExpenses;

public class HomePageTestCases extends BaseClass {

	LoginPage lp;
	HomePage hp;
	ManageExpenses me;
	

	@Test(enabled = true)
	public void verifyUserLogout() {
		lp = new LoginPage(driver);
		hp = new HomePage(driver);
		lp.performLogin(Constants.userName, Constants.password);
		hp.performLogout();
		String actual = lp.getSignInText();
		String expected = Constants.expectedLogoutMsg;
		Assert.assertEquals(actual, expected, "Logout successful");
	}
	
	@Test(enabled = true)
	public void verifyHomePageURL() {
		lp = new LoginPage(driver);
		hp = new HomePage(driver);
		lp.performLogin(Constants.userName, Constants.password);
		String actual=hp.getHomePageURL();
		Assert.assertEquals(actual, Constants.homePageURL, "::Page URL is same as expected");	
	}
	
	@Test(enabled = true)
	public void verifyHomePageTitle() {
		lp = new LoginPage(driver);
		hp = new HomePage(driver);
		lp.performLogin(Constants.userName, Constants.password);	
		Assert.assertEquals(hp.getHomePageTitle(), Constants.expectedhomePageTitle, "::Page Title is same as expected");	
	}
}

