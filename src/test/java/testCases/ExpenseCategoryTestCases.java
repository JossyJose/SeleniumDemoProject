package testCases;

import java.io.IOException;
import java.time.LocalDateTime;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import BaseClass.BaseClass;
import constants.Constants;
import elementRepository.ExpenseCategory;
import elementRepository.HomePage;
import elementRepository.LoginPage;

public class ExpenseCategoryTestCases extends BaseClass {

	LoginPage loginPage;
	HomePage homePge;
	ExpenseCategory expenseCategory;

	@Test(enabled = true, priority = 1)
	public void verifyExpenseCategoryPageIsLoaded() throws IOException {
		loginPage = new LoginPage(driver);
		expenseCategory = new ExpenseCategory(driver);
		loginPage.performLogin(Constants.USERNAME, Constants.PASSWORD);
		expenseCategory.clickmanageExpense();
		expenseCategory.clickExpenseCategory();
		String actualPageHeading = expenseCategory.getExpenseCateogryPageHeading();
		String expectedPageHeading = "Expense Category";
		Assert.assertEquals(actualPageHeading, expectedPageHeading, "Expense category page is loaded");

	}

	@Test(enabled = true)
	public void addNewExpenseCategory() throws IOException {
		loginPage = new LoginPage(driver);
		expenseCategory = new ExpenseCategory(driver);
		loginPage.performLogin(Constants.USERNAME, Constants.PASSWORD);
		expenseCategory.clickmanageExpense();
		expenseCategory.clickExpenseCategory();
		expenseCategory.clickNewButton();
		expenseCategory.createNewExpenseCategory("Grocery99871");
		String addedItemText = expenseCategory.getAddedItemCheck();
		Assert.assertEquals("Grocery99871", addedItemText);
	}

	@Test(enabled = true)
	public void searchExpenseCategory() throws IOException {
		loginPage = new LoginPage(driver);
		expenseCategory = new ExpenseCategory(driver);
		loginPage.performLogin(Constants.USERNAME, Constants.PASSWORD);
		expenseCategory.clickmanageExpense();
		expenseCategory.clickExpenseCategory();
		expenseCategory.clickSearchButton();
		expenseCategory.clickItemSearch("petrol");
		String actualItem = expenseCategory.getAddedItemCheck();
		Assert.assertEquals(actualItem, "petrol", "::Search is working");
	}

	@Test(enabled = true)
	public void deleteExpenseCategory() throws IOException {
		loginPage = new LoginPage(driver);
		expenseCategory = new ExpenseCategory(driver);
		loginPage.performLogin(Constants.USERNAME, Constants.PASSWORD);
		expenseCategory.clickmanageExpense();
		expenseCategory.clickExpenseCategory();
		expenseCategory.deleteItem("Grocery99871");
		String actualAlertMessage = expenseCategory.getSuccessAlert();
		String expectedAlertMessage = "×\n"
				+ "Alert!\n"
				+ "Expense Category Deleted Successfully";
		Assert.assertEquals(actualAlertMessage, expectedAlertMessage, "::Item deleted");
	}

	@Test(enabled = true)
	public void EditExpenseCategory() {
		loginPage = new LoginPage(driver);
		expenseCategory = new ExpenseCategory(driver);
		loginPage.performLogin(Constants.USERNAME, Constants.PASSWORD);
		expenseCategory.clickmanageExpense();
		expenseCategory.clickExpenseCategory();
		expenseCategory.clickEditIcon();
		expenseCategory.clearSearchField();
		expenseCategory.clickUpdateItem("Apple123"+LocalDateTime.now().getSecond());
		String actualAlertMessage = expenseCategory.getUpdateSuccessAlert();
		String expectedAlertMessage ="×\n"
				+ "Alert!\n"
				+ "Category Updated Successfully";
		Assert.assertEquals(actualAlertMessage, expectedAlertMessage, "::Item not updated");	
	
	}

	@Test(enabled = true)
	public void verifyNewSearchResetButtonColors() throws IOException {
		loginPage = new LoginPage(driver);
		expenseCategory = new ExpenseCategory(driver);
		loginPage.performLogin(Constants.USERNAME, Constants.PASSWORD);
		expenseCategory.clickmanageExpense();
		expenseCategory.clickExpenseCategory();

		SoftAssert softAssertNew = new SoftAssert();
		softAssertNew.assertEquals(expenseCategory.getNewButtonColor(), "rgba(220, 53, 69, 1)",
				"New Button color is as expected");

		SoftAssert softAssertSearch = new SoftAssert();
		softAssertSearch.assertEquals(expenseCategory.getSearchButtonColor(), "rgba(0, 123, 255, 1)",
				"Search Button color is as expected");

		SoftAssert softassertReset = new SoftAssert();
		softassertReset.assertEquals(expenseCategory.getResetButtonColor(), "rgba(255, 193, 7, 1)",
				"Reset button color is as expected");

	}

}
