package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constants.Constants;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import utilities.ExcelRead;

public class LoginTestCases extends BaseClass {

	LoginPage lp;
	HomePage hp;

	@Test(enabled = true)
	public void verifySignInButtonText() {
		lp = new LoginPage(driver);
		String actualText = lp.getSignInText();
		String expectedText = Constants.expectedLoginBtnText;
		Assert.assertEquals(actualText, expectedText, "Sign In text is same as expected");
	}

	@Test(enabled = true, priority = 1, groups = { "Critical" })
	public void verifyLoginForValidUser() throws IOException {
		hp = new HomePage(driver);
		lp = new LoginPage(driver);
		lp.performLogin(Constants.userName, Constants.password);
		String actual = hp.getHomePageText();
		String expected = "Home";
		Assert.assertEquals(actual, expected, "Successful Login");
	}
	
	@Test(enabled = true)
	public void verifySignInButtonColor() {
		lp = new LoginPage(driver);
		String actual = lp.getSignInButtonColor();
		String expected = "rgba(52, 58, 64, 1)";
		Assert.assertEquals(actual, expected, "Sign In button color is same as expected");
	}

	@Test(enabled = true)
	public void verifyLoginForInValidUser() throws IOException {
		lp = new LoginPage(driver);
		String user = ExcelRead.readStringData(1, 0);
		String pwd = ExcelRead.readStringData(1, 1);
		lp.performLogin(user, pwd);
		String actual = lp.getAlertMsg();
		String expected = "×\n" + "Alert!\n" + "Invalid Username/Password";
		Assert.assertEquals(actual, expected, "Alert same as expected");
	}
	
	@Test
	public void verifyCheckBox() throws InterruptedException {
	lp = new LoginPage(driver);
	boolean actual = lp.getRememberMe();
	boolean expected = false;
	Assert.assertEquals(actual, expected, Constants.SelectionError);
	}
	
	@Test(enabled = true, dataProvider="loginData")
	public void verifyLoginForInValidUserwithExcelDataProvider(String userName, String password ) {
		lp = new LoginPage(driver);
		lp.performLogin(userName, password);
		String actual = lp.getAlertMsg();
		String expected = "×\n" + "Alert!\n" + "Invalid Username/Password";
		Assert.assertEquals(actual, expected, "Alert not as expected");
	}
	
   @DataProvider(name="loginData")
	public Object[][] loginData() throws Exception {
		Object[][] arrayObject = ExcelRead.getTableArray(System.getProperty("user.dir") + "\\src\\test\\resources\\ExcelRead\\userData.xlsx","Sheet1");
		return arrayObject;
	}


}
