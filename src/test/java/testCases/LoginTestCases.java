package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import DataProviders.DataProviderClass;
import constants.Constants;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import utilities.ExcelRead;

public class LoginTestCases extends BaseClass {

	LoginPage loginPage;
	HomePage homePage;

	@Test(enabled = true)
	public void verifySignInButtonText() {
		loginPage = new LoginPage(driver);
		String actualText = loginPage.getSignInText();
		String expectedText = Constants.EXPECTED_LOGIN_BUTTON_TEXT;
		Assert.assertEquals(actualText, expectedText, "Sign In text is same as expected");
	}

	@Test(enabled = true, priority = 1, groups = { "Critical" })
	public void verifyLoginForValidUser() throws IOException {
		homePage = new HomePage(driver);
		loginPage = new LoginPage(driver);
		loginPage.performLogin(Constants.USERNAME, Constants.PASSWORD);
		String actualText = homePage.getHomePageText();
		String expectedText = "Home";
		Assert.assertEquals(actualText, expectedText, "Successful Login");
	}
	
	@Test(enabled = true, groups = { "Critical" })
	public void verifySignInButtonColor() {
		loginPage = new LoginPage(driver);
		String actualColor = loginPage.getSignInButtonColor();
		String expectedColor = "rgba(52, 58, 64, 1)";
		Assert.assertEquals(actualColor, expectedColor, Constants.BUTTON_COLOR_MESSAGE);
	}

	@Test(enabled = true, groups = { "Critical" })
	public void verifyLoginForInValidUser() throws IOException {
		loginPage = new LoginPage(driver);
		String user = ExcelRead.getReadStringData(1, 0);
		String pwd = ExcelRead.getReadStringData(1, 1);
		loginPage.performLogin(user, pwd);
		String actualAlert = loginPage.getAlertMsg();
		String expectedAlert = "×\n" + "Alert!\n" + "Invalid Username/Password";
		Assert.assertEquals(actualAlert, expectedAlert, Constants.ALERT_MESSAGE);
	}
	
	@Test
	public void verifyCheckBox() throws InterruptedException {
	loginPage = new LoginPage(driver);
	boolean actualResult = loginPage.getRememberMe();
	boolean expectedResult = false;
	Assert.assertEquals(actualResult, expectedResult, Constants.SELECTION_ERROR);
	}
	
	@Test(enabled = true, dataProvider="loginData", dataProviderClass = DataProviderClass.class)
	public void verifyLoginForInValidUserwithExcelDataProvider(String userName, String password ) {
		loginPage = new LoginPage(driver);
		loginPage.performLogin(userName, password);
		String actualAlert = loginPage.getAlertMsg();
		String expectedAlert = "×\n" + "Alert!\n" + "Invalid Username/Password";
		Assert.assertEquals(actualAlert, expectedAlert,Constants.ALERT_MESSAGE);
	}

}
