
package elementRepository;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ExpenseCategory {

	WebDriver driver;
	GeneralUtilities generalUtility;

	public ExpenseCategory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		generalUtility = new GeneralUtilities();
	}

	// web elements

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/expense-category']//p[text()='Expense Category']")
	private WebElement expenseCtgy;

	@FindBy(xpath = "//h1[text()='Expense Category']") 
	private WebElement expenseCtgyPageheading;

	@FindBy(xpath = "//li[2]//p[contains(text(), 'Manage Expense')]") 
	private WebElement manageExpense;

	@FindBy(xpath = "//a[@onclick='click_button(1)']") 
	private WebElement newButton;

	@FindBy(xpath = "//a[@onclick='click_button(2)']") 
	private WebElement searchButton;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']") 
	private WebElement resetButton;

	@FindBy(xpath = "//button[@name='Search' and @type='submit']") 
	private WebElement searchItem;

	@FindBy(xpath = "//input[@id='name']") 
	private WebElement expenseCategoryTitle;

	@FindBy(xpath = "//input[@id='un']") 
	private WebElement searchTitle;
	
	
	@FindBy(xpath = "//input[@id='name']") 
	private WebElement editField;
	

	@FindBy(xpath = "//button[@name='Create']") 
	private WebElement createNewExpenseCategoryButton;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//td[1]") 
	private WebElement addedItem;
	
	@FindBy(xpath = "//button[@name='Update']") 
	private WebElement updateItemBtn;
	

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//td[2]//i[@class='fas fa-trash-alt']") 
	private WebElement deleteIcon;
	
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//td[2]//i[@class='fas fa-edit']") 
	private WebElement editIcon;
	

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") 
	private WebElement deleteSuccessAlert;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") 
	private WebElement updateSuccessAlert;
	
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//td[1]") 
	private List<WebElement> itemList = new ArrayList <WebElement>();

	String dynamicpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[\" + i + \"]//td[2]//a[@class='btn btn-sm btn btn-danger btncss']";

	public void clickmanageExpense() {
		generalUtility.buttonClick(manageExpense);
	}

	public void clickExpenseCategory() {
		generalUtility.buttonClick(expenseCtgy);
	}

	public String getExpenseCateogryPageHeading() {
		return generalUtility.getElementText(expenseCtgyPageheading);
	}

	public void clickNewButton() {
		generalUtility.buttonClick(newButton);
	}

	public void clickSearchButton() {
		generalUtility.buttonClick(searchButton);
	}

	public void clickItemSearch(String title) {
		generalUtility.inputText(searchTitle, title);
		generalUtility.buttonClick(searchItem);
	}

//	public void enterTitle(String title) {
//		gnrlUtl.inputText(expenseCategoryTitle, title);
//	}

//	public void inputSearchItem(String title) {
//		gnrlUtl.inputText(searchTitle, title);
//	}

	public void createNewExpenseCategory(String title) {
		generalUtility.inputText(expenseCategoryTitle, title);
		generalUtility.buttonClick(createNewExpenseCategoryButton);
	}

	public String getAddedItemCheck() {
		String val = generalUtility.getElementText(addedItem);
		return val;
	}

	public void acceptDeleteAlert() {
		generalUtility.acceptAlert(driver);
	}

	public String getSuccessAlert() {
		return deleteSuccessAlert.getText();
	}
	
	public String getUpdateSuccessAlert() {
		return updateSuccessAlert.getText();
	}

	public String getNewButtonColor() {
		return generalUtility.getBackgroundColor(newButton);
	}

	public String getSearchButtonColor() {
		return generalUtility.getBackgroundColor(searchButton);
	}

	public String getResetButtonColor() {
		return generalUtility.getBackgroundColor(resetButton);
	}
	
	public void clickEditIcon() {
		editIcon.click();
	}
	

	public void clearSearchField() {
		generalUtility.clearField(editField);
	}
	
//	public void inputItemToUpdate(String newItem) {
//		gnrlUtl.inputText(editField, newItem);
//				
//	}			
	public void clickUpdateItem(String newItem) {
		generalUtility.inputText(editField, newItem);
		updateItemBtn.click();
	}
	
	public void selectItemToUpdate(String item) {
		String dynamicPath = generalUtility.selectDynamicItem(itemList, item, dynamicpath);
		WebElement cellElement = driver.findElement(By.xpath(dynamicPath));
		cellElement.click();
	}

	public void deleteItem(String itemName) {
		String dynamicItemXpath = generalUtility.selectDynamicItem(itemList, itemName, dynamicpath);
		WebElement cellElement = driver.findElement(By.xpath(dynamicItemXpath));
		
		cellElement.click();
		driver.switchTo().alert().accept();
	}
}
