package elementRepository;

import java.awt.AWTException;

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
	GeneralUtilities generalUtility;
	ExplicitWait explicitWait;
	Actions actionObject;

	public ManageExpenses(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		generalUtility = new GeneralUtilities();
		explicitWait = new ExplicitWait();
		actionObject = new Actions(driver);
	}


	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-expense']//p[text()='Manage Expense']")
	private WebElement ListExpenses;

	@FindBy(xpath = "//li[2]//a[@class='nav-link']//i[@class='nav-icon fas fa-money-bill-alt']") 
	private WebElement manageExpense;

	@FindBy(xpath = "//a[@class='nav-link']//p[text()='Create Merchant']") 
	private WebElement createMerchant;

	@FindBy(xpath = "//h1[text()='List Expense']") 
	private WebElement ListExpensePageHeading;

	@FindBy(xpath = "//h1[text()='Create Merchant']") 
	private WebElement createMerchantPageHeading;

	@FindBy(xpath = "//a[@class ='btn btn-rounded btn-danger']") 
	private WebElement newButton;

	@FindBy(xpath = "//a[@class ='btn btn-rounded btn-primary']") 
	private WebElement searchButton;

	@FindBy(xpath = "//a[@class ='btn btn-rounded btn-warning']") 
	private WebElement resetButton;

	@FindBy(xpath = "//select[@id ='user_id']") 
	private WebElement userIdField;

	@FindBy(xpath = "//input[@id='ex_date']") 
	private WebElement dateField;

	@FindBy(xpath = "//select[@id='ex_type']") 
	private WebElement expenseTypeField;

	@FindBy(xpath = "//input[@id='amount']") 
	private WebElement amountField;

	@FindBy(xpath = "//button[@name='create']") 
	private WebElement createBtn;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") 
	private WebElement CreateSuccessAlert;

	@FindBy(xpath = "//input[@name='userfile']")
	private WebElement chooseFileBtn;

	String filePath =System.getProperty("user.dir") + "\\src\\test\\resources\\Files\\SampleFile.docx";

	public void loadManageExpense() {
		generalUtility.buttonClick(manageExpense);
	}

	public void loadListExpenses() {
		generalUtility.buttonClick(ListExpenses);
	}

	public void loadCreateExpense() {
		generalUtility.buttonClick(createMerchant);
	}

	public String getManageExpensesPageLoad() {
		return generalUtility.getElementText(ListExpensePageHeading);
	}

	public String getCreateMerchantPageLoad() {
		return generalUtility.getElementText(ListExpensePageHeading);
	}

	public String getNewBtnFontColor() {
		return generalUtility.getBackgroundColor(newButton);
	}

	public String getSearchBtnFontColor() {
		return generalUtility.getBackgroundColor(searchButton);
	}

	public String getResetBtnFontColor() {
		return generalUtility.getBackgroundColor(resetButton);
	}

	public String getNewBtnFontSize() {
		return generalUtility.getFontSize(newButton);
	}

	public String getSearchBtnFontSize() {
		return generalUtility.getFontSize(searchButton);
	}

	public String getResetBtnFontsize() {
		return generalUtility.getFontSize(resetButton);
	}

	public void loadAddExpensePage() {
		generalUtility.buttonClick(newButton);
	}

	public boolean isVerifyUserNameFieldPresence() {
		return generalUtility.elementPresence(userIdField);
	}

	public boolean isVerifyDateFieldPresence() {
		return generalUtility.elementPresence(dateField);
	}

	public boolean isVerifyExpenseTypeFieldPresence() {
		return generalUtility.elementPresence(expenseTypeField);
	}

	public boolean isVerifyAmountFieldPresence() {
		return generalUtility.elementPresence(amountField);
	}

	public void addUser(String user) {
		generalUtility.selectDropDownValue(userIdField, user);
	}

	public void addDate(String date) {
		generalUtility.inputText(dateField, date);
	}

	public void addAmount(String amt) {
		generalUtility.inputText(amountField, amt);
	}

	public void addExpenseCategory(String expenseCtgryt) {
		generalUtility.selectDropDownValue(expenseTypeField, expenseCtgryt);
	}

//	public void AddDetails(String user, String expenseCtgry, String amt) {
//		addUser(user);
//		addExpenseCategory(expenseCtgry);
//		addAmount(amt);
//
//	}

	public void FileUpload(String user, String expenseCtgry, String amt) throws AWTException, InterruptedException {

		addUser(user);
		addExpenseCategory(expenseCtgry);
		addAmount(amt);
		generalUtility.performFileUpload(chooseFileBtn, driver, filePath);
		
		JavascriptExecutor js = (JavascriptExecutor) driver; // Scrolling using JavascriptExecutor
		js.executeScript("window.scrollBy(0,380)");
	
		explicitWait.presenceOfWebElementLocated(driver, "//button[@name='create']");

	}

	public void createExpenseRecord() {
		generalUtility.buttonClick(createBtn);
	}

	public String getSuccessAlert() {
		return CreateSuccessAlert.getText();
	}

}
