package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class LoginPage {

	WebDriver driver;
	GeneralUtilities gnrlUtl;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		gnrlUtl = new GeneralUtilities();
	}


	@FindBy(xpath = "//button[text()='Sign In']") 
	WebElement SignInText;

	@FindBy(xpath = "//input[@name='username']") 
	WebElement userName;

	@FindBy(xpath = "//input[@name='password']") 
	WebElement password;

	@FindBy(xpath = "//button[text()='Sign In']") 
	WebElement login;

	@FindBy(xpath = "//div[contains(@class,'alert-danger')]") 
	WebElement alertMsg;
	
	@FindBy(xpath = "//input[@id='remember']")
	WebElement verificationOfRememberCheckBox;


	public String getSignInText() {
		return gnrlUtl.getElementText(SignInText);
	}

	public void inputUsername(String user) {
		userName.sendKeys(user);
	}

	public void inputPassword(String pwd) {
		password.sendKeys(pwd);
	}

	public void Login() {
		login.click();
	}

	public void performLogin(String user, String pwd) {
		userName.sendKeys(user);
		password.sendKeys(pwd);
		login.click();
	}

	public String getAlertMsg() {
		return alertMsg.getText();
	}

	public String getSignInButtonColor() {
		return gnrlUtl.getBackgroundColor(login);
	}
	
	public boolean getRememberMe()
	{
	return gnrlUtl.isCheckboxEnabled(verificationOfRememberCheckBox);
	}
	

}
