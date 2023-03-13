package testCases;

import java.time.LocalDateTime;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import elementRepository.AdminUser;
import elementRepository.LoginPage;

public class AdminUserTestCases extends BaseClass {

	LoginPage lp;
	AdminUser au;


	@Test(enabled = true)
	public void verifyAdminUserPageURL() {
		lp = new LoginPage(driver);
		au = new AdminUser(driver);
		lp.performLogin("admin", "admin");
		au.clickAdminUser();
		Assert.assertEquals(au.getAdminUsersPageURL(), Constants.AdminUserPageURL, "::Page URL is  matching");
	}

	@Test(enabled = true)
	public void verifyAdminUserPageTitle() {
		lp = new LoginPage(driver);
		au = new AdminUser(driver);
		lp.performLogin("admin", "admin");
		au.clickAdminUser();
		Assert.assertEquals(au.getAdminUsersPageTitle(), Constants.AdminUserPageTitle, "Page Title is  matching");
	}
	
	@Test(enabled = true, groups = {"Critical"})
	public void verifyCreateNewUser() {
		lp = new LoginPage(driver);
		au = new AdminUser(driver);
		lp.performLogin("admin", "admin");
		au.clickAdminUser();
		au.clickNewButton();
		au.enterUserName("usename"+ LocalDateTime.now().getSecond());
		au.enterPassword("pword");
		au.selectUserType("Staff");
		au.clickSaveButton();
		String actual = au.getUserType();
		String expected = "staff";
		Assert.assertEquals(actual, expected, "New User created");
	}
}
