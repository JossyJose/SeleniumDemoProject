
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
	GeneralUtilities gnrlUtl;

	public ExpenseCategory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		gnrlUtl = new GeneralUtilities();
	}

	// web elements

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/expense-category']//p[text()='Expense Category']")
	WebElement expenseCtgy;

	@FindBy(xpath = "//h1[text()='Expense Category']") 
	WebElement expenseCtgyPageheading;

	@FindBy(xpath = "//li[2]//p[contains(text(), 'Manage Expense')]") 
	WebElement manageExpense;

	@FindBy(xpath = "//a[@onclick='click_button(1)']") 
	WebElement newButton;

	@FindBy(xpath = "//a[@onclick='click_button(2)']") 
	WebElement searchButton;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']") 
	WebElement resetButton;

	@FindBy(xpath = "//button[@name='Search' and @type='submit']") 
	WebElement searchItem;

	@FindBy(xpath = "//input[@id='name']") 
	WebElement expenseCategoryTitle;

	@FindBy(xpath = "//input[@id='un']") 
	WebElement searchTitle;
	
	
	@FindBy(xpath = "//input[@id='name']") 
	WebElement editField;
	

	@FindBy(xpath = "//button[@name='Create']") 
	WebElement createNewExpenseCategoryButton;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//td[1]") 
	WebElement addedItem;
	
	@FindBy(xpath = "//button[@name='Update']") 
	WebElement updateItemBtn;
	

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//td[2]//i[@class='fas fa-trash-alt']") 
	WebElement deleteIcon;
	
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//td[2]//i[@class='fas fa-edit']") 
	WebElement editIcon;
	

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") 
	WebElement deleteSuccessAlert;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") 
	WebElement updateSuccessAlert;
	
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//td[1]") 
	List<WebElement> itemList = new ArrayList <WebElement>();

	String dynamicpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[\" + i + \"]//td[2]//a[@class='btn btn-sm btn btn-danger btncss']";

	public void clickmanageExpense() {
		gnrlUtl.buttonClick(manageExpense);
	}

	public void clickExpenseCategory() {
		gnrlUtl.buttonClick(expenseCtgy);
	}

	public String expenseCateogryPageHeading() {
		return gnrlUtl.getElementText(expenseCtgyPageheading);
	}

	public void clickNewButton() {
		gnrlUtl.buttonClick(newButton);
	}

	public void clickSearchButton() {
		gnrlUtl.buttonClick(searchButton);
	}

	public void clickItemSearch() {
		gnrlUtl.buttonClick(searchItem);
	}

	public void enterTitle(String title) {
		gnrlUtl.inputText(expenseCategoryTitle, title);
	}

	public void inputSearchItem(String title) {
		gnrlUtl.inputText(searchTitle, title);
	}

	public void createNewExpenseCategory() {
		gnrlUtl.buttonClick(createNewExpenseCategoryButton);
	}

	public String addedItemCheck() {
		String val = gnrlUtl.getElementText(addedItem);
		return val;
	}

	public void acceptDeleteAlert() {
		gnrlUtl.acceptAlert(driver);
	}

	public String successAlert() {
		return deleteSuccessAlert.getText();
	}
	
	public String updateSuccessAlert() {
		return updateSuccessAlert.getText();
	}

	public String getNewButtonColor() {
		return gnrlUtl.getBackgroundColor(newButton);
	}

	public String getSearchButtonColor() {
		return gnrlUtl.getBackgroundColor(searchButton);
	}

	public String getResetButtonColor() {
		return gnrlUtl.getBackgroundColor(resetButton);
	}
	
	public void clickEditIcon() {
		editIcon.click();
	}
	

	public void clearSearchField() {
		gnrlUtl.clearField(editField);
	}
	
	public void inputItemToUpdate(String newItem) {
		gnrlUtl.inputText(editField, newItem);
				
	}			
	public void clickUpdateItem() {
		updateItemBtn.click();
	}
	
	public void selectItemToUpdate(String item) {
		String dynamicPath = gnrlUtl.selectDynamicItem(itemList, item, dynamicpath);
		WebElement cellElement = driver.findElement(By.xpath(dynamicPath));
		cellElement.click();
	}

	public void deleteItem(String itemName) {
		String dynamicItemXpath = gnrlUtl.selectDynamicItem(itemList, itemName, dynamicpath);
		WebElement cellElement = driver.findElement(By.xpath(dynamicItemXpath));
		
		cellElement.click();
		driver.switchTo().alert().accept();
	}
}
