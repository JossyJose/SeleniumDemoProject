package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class AdminUser {

	WebDriver driver;
	GeneralUtilities generalUtilities = new GeneralUtilities();

	public AdminUser(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//p[text()='Admin Users']")
	private WebElement adminUser;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement newButton;

	@FindBy(xpath = "//input[@id='username']")
	private WebElement userName;

	@FindBy(xpath = "//input[@id='password']")
	private WebElement passWord;

	@FindBy(xpath = "//select[@id='user_type']")
	private WebElement userType;

	@FindBy(xpath = "//div//button[@name='Create']")
	private WebElement saveButton;

	@FindBy(xpath = "//div//table//tbody//tr[1]//td[2]")
	private WebElement userTypeSelected;

	public void clickAdminUser() {
		adminUser.click();
	}

	public void clickNewButton() {
		newButton.click();
	}

//	public void enterUserName(String uname) {
//		userName.sendKeys(uname);
//	}

	public void enterPassword(String pword) {
		passWord.sendKeys(pword);
	}
	
	public void selectUserType(String utype) {
		generalUtilities.selectDropDownValue(userType, utype);
	}

	public void clickSaveButton(String uname, String pword, String utype) {
		userName.sendKeys(uname);
		passWord.sendKeys(pword);
		generalUtilities.selectDropDownValue(userType, utype);
		saveButton.click();
	}

	public String getUserType() {
		return generalUtilities.getElementText(userTypeSelected);
	}

	public String getAdminUsersPageURL() {
		return generalUtilities.getPageURL(driver);

	}

	public String getAdminUsersPageTitle() {
		return generalUtilities.getPageTitle(driver);

	}

}
