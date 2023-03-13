package elementRepository;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExplicitWait;
import utilities.GeneralUtilities;

public class ManageExpenses {

	WebDriver driver;
	GeneralUtilities gnrlUtl;
	ExplicitWait ew;
	Actions obj;

	public ManageExpenses(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		gnrlUtl = new GeneralUtilities();
		ew = new ExplicitWait();
		obj = new Actions(driver);
	}


	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-expense']//p[text()='Manage Expense']")
	WebElement ListExpenses;

	@FindBy(xpath = "//li[2]//a[@class='nav-link']//i[@class='nav-icon fas fa-money-bill-alt']") 
	WebElement manageExpense;

	@FindBy(xpath = "//a[@class='nav-link']//p[text()='Create Merchant']") 
	WebElement createMerchant;

	@FindBy(xpath = "//h1[text()='List Expense']") 
	WebElement ListExpensePageHeading;

	@FindBy(xpath = "//h1[text()='Create Merchant']") 
	WebElement createMerchantPageHeading;

	@FindBy(xpath = "//a[@class ='btn btn-rounded btn-danger']") 
	WebElement newButton;

	@FindBy(xpath = "//a[@class ='btn btn-rounded btn-primary']") 
	WebElement searchButton;

	@FindBy(xpath = "//a[@class ='btn btn-rounded btn-warning']") 
	WebElement resetButton;

	@FindBy(xpath = "//select[@id ='user_id']") 
	WebElement userIdField;

	@FindBy(xpath = "//input[@id='ex_date']") 
	WebElement dateField;

	@FindBy(xpath = "//select[@id='ex_type']") 
	WebElement expenseTypeField;

	@FindBy(xpath = "//input[@id='amount']") 
	WebElement amountField;

	@FindBy(xpath = "//button[@name='create']") 
	WebElement createBtn;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") 
	WebElement CreateSuccessAlert;

	@FindBy(xpath = "//input[@name='userfile']")
	WebElement chooseFileBtn;

	String filePath =System.getProperty("user.dir") + "\\src\\test\\resources\\Files\\SampleFile.docx";

	public void loadManageExpense() {
		gnrlUtl.buttonClick(manageExpense);
	}

	public void loadListExpenses() {
		gnrlUtl.buttonClick(ListExpenses);
	}

	public void loadCreateExpense() {
		gnrlUtl.buttonClick(createMerchant);
	}

	public String manageExpensesPageLoad() {
		return gnrlUtl.getElementText(ListExpensePageHeading);
	}

	public String createMerchantPageLoad() {
		return gnrlUtl.getElementText(ListExpensePageHeading);
	}

	public String getNewBtnFontColor() {
		return gnrlUtl.getBackgroundColor(newButton);
	}

	public String getSearchBtnFontColor() {
		return gnrlUtl.getBackgroundColor(searchButton);
	}

	public String getResetBtnFontColor() {
		return gnrlUtl.getBackgroundColor(resetButton);
	}

	public String getNewBtnFontSize() {
		return gnrlUtl.getFontSize(newButton);
	}

	public String getSearchBtnFontSize() {
		return gnrlUtl.getFontSize(searchButton);
	}

	public String getResetBtnFontsize() {
		return gnrlUtl.getFontSize(resetButton);
	}

	public void loadAddExpensePage() {
		gnrlUtl.buttonClick(newButton);
	}

	public boolean verifyUserNameFieldPresence() {
		return gnrlUtl.elementPresence(userIdField);
	}

	public boolean verifyDateFieldPresence() {
		return gnrlUtl.elementPresence(dateField);
	}

	public boolean verifyExpenseTypeFieldPresence() {
		return gnrlUtl.elementPresence(expenseTypeField);
	}

	public boolean verifyAmountFieldPresence() {
		return gnrlUtl.elementPresence(amountField);
	}

	public void addUser(String user) {
		gnrlUtl.selectDropDownValue(userIdField, user);
	}

	public void addDate(String date) {
		gnrlUtl.inputText(dateField, date);
	}

	public void addAmount(String amt) {
		gnrlUtl.inputText(amountField, amt);
	}

	public void addExpenseCategory(String expenseCtgryt) {
		gnrlUtl.selectDropDownValue(expenseTypeField, expenseCtgryt);
	}

	public void AddDetails(String user, String expenseCtgry, String amt) {
		addUser(user);
		addExpenseCategory(expenseCtgry);
		addAmount(amt);

	}

	public void FileUpload() throws AWTException, InterruptedException {

		gnrlUtl.performFileUpload(chooseFileBtn, driver, filePath);
		
		JavascriptExecutor js = (JavascriptExecutor) driver; // Scrolling using JavascriptExecutor
		js.executeScript("window.scrollBy(0,380)");
	
		ew.presenceOfWebElementLocated(driver, "//button[@name='create']");

	}

	public void createExpenseRecord() {
		gnrlUtl.buttonClick(createBtn);
	}

	public String successAlert() {
		return CreateSuccessAlert.getText();
	}

}
