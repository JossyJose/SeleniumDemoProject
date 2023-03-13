package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class LoginPage {

	WebDriver driver;
	GeneralUtilities generalUtilities;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		generalUtilities = new GeneralUtilities();
	}


	@FindBy(xpath = "//button[text()='Sign In']") 
	private WebElement SignInText;

	@FindBy(xpath = "//input[@name='username']") 
	private WebElement userName;

	@FindBy(xpath = "//input[@name='password']") 
	private WebElement password;

	@FindBy(xpath = "//button[text()='Sign In']") 
	private WebElement login;

	@FindBy(xpath = "//div[contains(@class,'alert-danger')]") 
	private WebElement alertMsg;
	
	@FindBy(xpath = "//input[@id='remember']")
	private WebElement verificationOfRememberCheckBox;


	public String getSignInText() {
		return generalUtilities.getElementText(SignInText);
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
		return generalUtilities.getBackgroundColor(login);
	}
	
	public boolean getRememberMe()
	{
	return generalUtilities.isCheckboxEnabled(verificationOfRememberCheckBox);
	}
	

}
