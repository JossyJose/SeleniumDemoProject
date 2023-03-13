package testCases;

import java.time.LocalDateTime;

import org.testng.Assert;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import constants.Constants;
import elementRepository.AdminUser;
import elementRepository.LoginPage;

public class AdminUserTestCases extends BaseClass {

	LoginPage loginPage;
	AdminUser adminUser;


	@Test(enabled = true)
	public void verifyAdminUserPageURL() {
		loginPage = new LoginPage(driver);
		adminUser = new AdminUser(driver);
		loginPage.performLogin("admin", "admin");
		adminUser.clickAdminUser();
		Assert.assertEquals(adminUser.getAdminUsersPageURL(), Constants.ADMINUSERPAGE_URL, "::Page URL is  matching");
	}

	@Test(enabled = true)
	public void verifyAdminUserPageTitle() {
		loginPage = new LoginPage(driver);
		adminUser = new AdminUser(driver);
		loginPage.performLogin("admin", "admin");
		adminUser.clickAdminUser();
		Assert.assertEquals(adminUser.getAdminUsersPageTitle(), Constants.ADMINUSERPAGE_TITLE, "Page Title is  matching");
	}
	
	@Test(enabled = true, groups = {"Critical"})
	public void verifyCreateNewUser() {
		loginPage = new LoginPage(driver);
		adminUser = new AdminUser(driver);
		loginPage.performLogin("admin", "admin");
		adminUser.clickAdminUser();
		adminUser.clickNewButton();
		adminUser.clickSaveButton("usename"+ LocalDateTime.now().getSecond(),"pword", "Staff");
		String actualUserType = adminUser.getUserType();
		String expectedUserType = "staff";
		Assert.assertEquals(actualUserType, expectedUserType, "New User created");
	}
}
