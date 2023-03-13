package testCases;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import constants.Constants;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.ManageExpenses;



public class ManageExpensesTestCases extends BaseClass {

	LoginPage loginPage;
	HomePage homePage;
	ManageExpenses manageExpenses;

	@Test(enabled = true)
	public void verifyManageExpensePageLoad() {
		loginPage = new LoginPage(driver);
		manageExpenses = new ManageExpenses(driver);
		loginPage.performLogin(Constants.USERNAME, Constants.PASSWORD);
		manageExpenses.loadManageExpense();
		manageExpenses.loadListExpenses();
		String actualpageheader = manageExpenses.getManageExpensesPageLoad();
		String expectedpageHeader = Constants.EXPECTEDPAGEHEADER;
		Assert.assertEquals(actualpageheader, expectedpageHeader, " Page is loaded");
	}

	@Test(enabled = true)
	public void verifyNewSearchResetButtonFontSize() {
		loginPage = new LoginPage(driver);
		manageExpenses = new ManageExpenses(driver);
		loginPage.performLogin(Constants.USERNAME, Constants.PASSWORD);
		manageExpenses.loadManageExpense();
		manageExpenses.loadListExpenses();
		Assert.assertEquals(manageExpenses.getNewBtnFontSize(), "16px", " font size is as expected");
		Assert.assertEquals(manageExpenses.getSearchBtnFontSize(), "16px", " font size is as expected");
		Assert.assertEquals(manageExpenses.getResetBtnFontsize(), "16px", " font size is as expected");
	}

	@Test(enabled = true)
	public void verifyNewSearchResetButtonFontColor() {
		loginPage = new LoginPage(driver);
		manageExpenses = new ManageExpenses(driver);
		loginPage.performLogin(Constants.USERNAME, Constants.PASSWORD);
		manageExpenses.loadManageExpense();
		manageExpenses.loadListExpenses();
		Assert.assertEquals(manageExpenses.getNewBtnFontColor(), "rgba(220, 53, 69, 1)", " New btn font color is as expected");
		Assert.assertEquals(manageExpenses.getSearchBtnFontColor(), "rgba(0, 123, 255, 1)",
				" Search btn font color is as expected");
		Assert.assertEquals(manageExpenses.getResetBtnFontColor(), "rgba(255, 193, 7, 1)", " Reset btn font color is as expected");

	}

	@Test(enabled = true)
	public void verifyAddExpenseFieldsPresence() {
		loginPage = new LoginPage(driver);
		manageExpenses = new ManageExpenses(driver);
		loginPage.performLogin(Constants.USERNAME, Constants.PASSWORD);
		manageExpenses.loadManageExpense();
		manageExpenses.loadListExpenses();
		manageExpenses.loadAddExpensePage();
		Assert.assertTrue(manageExpenses.isVerifyUserNameFieldPresence());
		Assert.assertTrue(manageExpenses.isVerifyExpenseTypeFieldPresence());
		Assert.assertTrue(manageExpenses.isVerifyDateFieldPresence());
		Assert.assertTrue(manageExpenses.isVerifyAmountFieldPresence());
	}

	@Test(enabled = true)
	public void verifyAddNewExpenseRecord() throws AWTException, InterruptedException {
		loginPage = new LoginPage(driver);
		manageExpenses = new ManageExpenses(driver);
		loginPage.performLogin(Constants.USERNAME, Constants.PASSWORD);
		manageExpenses.loadManageExpense();
		manageExpenses.loadListExpenses();
		manageExpenses.loadAddExpensePage();
		manageExpenses.FileUpload("User(DB)", "Debit Bank", "500");
		manageExpenses.createExpenseRecord();
		String actualAlert = manageExpenses.getSuccessAlert();
		String expectedAlert = "×\n"
				+ "Alert!\n"
				+ "Expense Record Created Successfully";
		Assert.assertEquals(actualAlert, expectedAlert, "::Expense record created");
	}
}
