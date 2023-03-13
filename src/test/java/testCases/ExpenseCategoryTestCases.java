package testCases;

import java.io.IOException;
import java.time.LocalDateTime;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import constants.Constants;
import elementRepository.ExpenseCategory;
import elementRepository.HomePage;
import elementRepository.LoginPage;

public class ExpenseCategoryTestCases extends BaseClass {

	LoginPage lp;
	HomePage hp;
	ExpenseCategory ec;

	@Test(enabled = true, priority = 1)
	public void verifyExpenseCategoryPageIsLoaded() throws IOException {
		lp = new LoginPage(driver);
		ec = new ExpenseCategory(driver);
		lp.performLogin(Constants.userName, Constants.password);
		ec.clickmanageExpense();
		ec.clickExpenseCategory();
		String actual = ec.expenseCateogryPageHeading();
		String expected = "Expense Category";
		Assert.assertEquals(actual, expected, "Expense category page is loaded");

	}

	@Test(enabled = true)
	public void addNewExpenseCategory() throws IOException {
		lp = new LoginPage(driver);
		ec = new ExpenseCategory(driver);
		lp.performLogin(Constants.userName, Constants.password);
		ec.clickmanageExpense();
		ec.clickExpenseCategory();
		ec.clickNewButton();
		ec.enterTitle("Grocery99871");
		ec.createNewExpenseCategory();
		String addedItemText = ec.addedItemCheck();
		Assert.assertEquals("Grocery99871", addedItemText);
	}

	@Test(enabled = true)
	public void searchExpenseCategory() throws IOException {
		lp = new LoginPage(driver);
		ec = new ExpenseCategory(driver);
		lp.performLogin(Constants.userName, Constants.password);
		ec.clickmanageExpense();
		ec.clickExpenseCategory();
		ec.clickSearchButton();
		ec.inputSearchItem("petrol");
		ec.clickItemSearch();
		String actual = ec.addedItemCheck();
		Assert.assertEquals(actual, "petrol", "::Search is working");
	}

	@Test(enabled = true)
	public void deleteExpenseCategory() throws IOException {
		lp = new LoginPage(driver);
		ec = new ExpenseCategory(driver);
		lp.performLogin(Constants.userName, Constants.password);
		ec.clickmanageExpense();
		ec.clickExpenseCategory();
		ec.deleteItem("Grocery99871");
		String actual = ec.successAlert();
		String expected = "×\n"
				+ "Alert!\n"
				+ "Expense Category Deleted Successfully";
		Assert.assertEquals(actual, expected, "::Item deleted");
	}

	@Test(enabled = true)
	public void EditExpenseCategory() {
		lp = new LoginPage(driver);
		ec = new ExpenseCategory(driver);
		lp.performLogin(Constants.userName, Constants.password);
		ec.clickmanageExpense();
		ec.clickExpenseCategory();
		ec.clickEditIcon();
		ec.clearSearchField();
		ec.inputItemToUpdate("Apple123"+LocalDateTime.now().getSecond());
		ec.clickUpdateItem();
		String actual = ec.updateSuccessAlert();
		String expected ="×\n"
				+ "Alert!\n"
				+ "Category Updated Successfully";
		Assert.assertEquals(actual, expected, "::Item not updated");	
	
	}

	@Test(enabled = true)
	public void verifyNewSearchResetButtonColors() throws IOException {
		lp = new LoginPage(driver);
		ec = new ExpenseCategory(driver);
		lp.performLogin(Constants.userName, Constants.password);
		ec.clickmanageExpense();
		ec.clickExpenseCategory();

		SoftAssert softAssertNew = new SoftAssert();
		softAssertNew.assertEquals(ec.getNewButtonColor(), "rgba(220, 53, 69, 1)",
				"New Button color is as expected");

		SoftAssert softAssertSearch = new SoftAssert();
		softAssertSearch.assertEquals(ec.getSearchButtonColor(), "rgba(0, 123, 255, 1)",
				"Search Button color is as expected");

		SoftAssert softassertReset = new SoftAssert();
		softassertReset.assertEquals(ec.getResetButtonColor(), "rgba(255, 193, 7, 1)",
				"Reset button color is as expected");

	}

}
